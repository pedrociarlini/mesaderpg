package pedrociarlini.mesaderpg.net;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import pedrociarlini.mesaderpg.net.trabalho.ConnLayer;
import pedrociarlini.mesaderpg.net.trabalho.ConnectionLayerFactory;
import pedrociarlini.mesaderpg.net.trabalho.Message;
import trabalho.IConnLayer;
import trabalho.IConnection;
import trabalho.IMessage;

public class ConnectionTeste {
	public static void main(String[] args) {
		try {
			ServerTest t1 = new ServerTest();
			t1.start();
			
			Class.forName("pedrociarlini.mesaderpg.net.trabalho.ConnLayer");
			IConnLayer cl = ConnectionLayerFactory
					.createConneLayerInstance(ConnLayer.CONN_NAME);
			IConnection conn = cl.openConnection(InetAddress.getByName("localhost"), 5555);
			
			IMessage m = conn.createBlankMessage();
			conn.receive(m);
			System.out.println(m);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static class ServerTest extends Thread{
		@Override
		public void run() {
			ServerSocket server;
			try {
				setName("ServerTest");
				server = new ServerSocket(5555);
				Socket s = server.accept();
				ObjectOutputStream ois = new ObjectOutputStream(s.getOutputStream());

				Message m1 = new Message();
				m1.setBytes(new byte[] {1, 2, 3, 4, 5, 6, 7, 8});
				ois.writeObject(m1);
				s.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};

}
