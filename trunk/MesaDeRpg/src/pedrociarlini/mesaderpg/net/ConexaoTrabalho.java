package pedrociarlini.mesaderpg.net;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.uima.internal.util.SerializationUtils;

import pedrociarlini.mesaderpg.net.event.DataEvent;
import pedrociarlini.mesaderpg.net.event.DataReceivedListener;
import pedrociarlini.mesaderpg.net.trabalho.ConnLayer;
import pedrociarlini.mesaderpg.net.trabalho.Connection;
import pedrociarlini.mesaderpg.net.trabalho.ConnectionLayerFactory;
import trabalho.IConnLayer;
import trabalho.IConnection;
import trabalho.IMessage;

public class ConexaoTrabalho extends AbstractConexao {

	private static ServerSocket server;

	private IConnection conn;

	DataReader dataReader;

	private IConnLayer connLayer;

	public boolean closed = false;

	/**
	 * Construtor default.
	 * 
	 */
	public ConexaoTrabalho() {
		connLayer = ConnectionLayerFactory
				.createConnLayerInstance(ConnLayer.CONN_NAME);
	}

	public ConexaoTrabalho(String ip, int porta) throws IOException {
		this();
		setIp(ip);
		setPorta(porta);
	}

	public void open() throws IOException {
		try {
		conn = connLayer.openConnection(InetAddress.getByName(getIp()),
				getPorta());
		}
		catch (Exception ex) {
			throw new IOException(ex.getCause().getMessage());
		}
		dataReader = new DataReader(conn);
		dataReader.start();
	}

	/**
	 * Envia um objeto para o servidor, utilizando a API exigida pelo professor
	 * Nabor.
	 */
	public void send(Serializable obj) throws IOException {
		IMessage m = conn.createBlankMessage();
		m.setBytes(SerializationUtils.serialize(obj));
		conn.send(m);
	}

	public void close() throws IOException {
		closed = true;
		conn.close();
		if (server != null) {
			server.close();
			server = null;
		}
	}

	public boolean isClosed() {
		return closed;
	}

	public void acceptConnection(int porta) throws Exception {
		if(server == null) {
			server = new ServerSocket(porta);
		}
		Socket client = server.accept();
		setIp(client.getInetAddress().getHostAddress());
		setPorta(client.getPort());
		conn = new Connection(client);
		dataReader = new DataReader(conn);
		dataReader.start();
	}

	public Object receive() throws IOException {
		try {
			return dataReader.instantReceive();
		} catch (InterruptedException e) {
			throw new IOException(e.getMessage());
		}
	}

	/**
	 * Implementa um leitor assícrono dos dados.
	 * 
	 * @author Pedro Ciarlini
	 * 
	 */
	private class DataReader extends Thread {
		private IConnection conn;

		LinkedBlockingQueue<Object> dataQueue = new LinkedBlockingQueue<Object>();

		public DataReader(IConnection conn) {
			this.conn = conn;
		}

		public Object instantReceive() throws InterruptedException {
			return dataQueue.take();
		}

		public void run() {
			setName("DataReader");
			IMessage m;

			boolean errorOcurred = false;
			Serializable data;
			while (!ConexaoTrabalho.this.isClosed() && !errorOcurred) {
				m = this.conn.createBlankMessage();
				try {
					this.conn.receive(m);
					data = (Serializable) SerializationUtils.deserialize(m
							.getBytes());
					dataQueue.put(data);
					for (DataReceivedListener listener : ConexaoTrabalho.this
							.getListeners()) {
						listener.onDataReceived(new DataEvent(
								ConexaoTrabalho.this, data));
					}
				} catch (Exception e) {
					errorOcurred = true;
					e.printStackTrace();
				}
			}
		}
	}
}
