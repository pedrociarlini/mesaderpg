package pedrociarlini.mesaderpg.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

import pedrociarlini.mesaderpg.net.event.DataEvent;
import pedrociarlini.mesaderpg.net.event.DataReceivedListener;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ConexaoImpl implements Conexao {

	private static int sequencial;

	private int mySequencial;

	private Set<DataReceivedListener> listeners = new HashSet<DataReceivedListener>();

	private ObjectInputStream ois = null;

	private ObjectOutputStream oos = null;

	private Socket socket;

	private String ip;

	private int porta;

	private boolean closed = false;

	public ConexaoImpl() {
	}

	public ConexaoImpl(String ip, int porta) throws IOException {
		this.ip = ip;
		this.porta = porta;
	}

	public ConexaoImpl(Socket client) {
		socket = client;
		porta = socket.getPort();
		mySequencial = sequencial++;
		try {
			open();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addDataReceivedListener(DataReceivedListener listener) {
		this.listeners.add(listener);
	}

	public void close() throws IOException {
		closed  = true;
		this.socket.close();
	}

	// TODO Implementar criação de socket etc.

	public void open(String ip, int porta) throws IOException {
		this.ip = ip;
		this.porta = porta;
		open();
	}

	public void open() throws IOException {
		if (this.socket == null || this.socket.isClosed()) {
			this.socket = new Socket(ip, porta);
		}
		Thread t = new Thread(new DataReader());
		t.setName(DataReader.class.getSimpleName());
		t.start();
	}

	private class DataReader implements Runnable {
		public void run() {
			try {
				ois = new ObjectInputStream(ConexaoImpl.this.socket
						.getInputStream());
				oos = new ObjectOutputStream(ConexaoImpl.this.socket
						.getOutputStream());
				Serializable data;
				while (true) {
					try {
						data = (Serializable) ois.readObject();
						for (DataReceivedListener listener : ConexaoImpl.this.listeners) {
							listener.onDataReceived(new DataEvent(
									ConexaoImpl.this, data));
						}
					} catch (IOException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			} catch (IOException e1) {
				System.err.println("Erro ao iniciar o "
						+ this.getClass().getSimpleName());
				e1.printStackTrace();
			}
		}
	}

	public void send(Serializable data) throws IOException {
		getOos().writeObject(data);
	}

	protected ObjectOutputStream getOos() {
		return oos;
	}

	protected String getIp() {
		return ip;
	}

	protected int getPorta() {
		return porta;
	}

	protected ObjectInputStream getOis() {
		return ois;
	}

	public boolean isClosed() {
		return closed;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "(" + mySequencial + ") - "
				+ socket.getLocalPort() + " <-->" + socket.getPort();
	}

    public void acceptConnection(int porta) throws Exception {
        // TODO implementar criação de servidor 
        throw new NotImplementedException();
    }

	public Object receive() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
}