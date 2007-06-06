package pedrociarlini.mesaderpg.net;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.uima.internal.util.SerializationUtils;

import pedrociarlini.mesaderpg.model.JogadorVO;
import pedrociarlini.mesaderpg.net.event.DataEvent;
import pedrociarlini.mesaderpg.net.event.DataReceivedListener;
import pedrociarlini.mesaderpg.net.trabalho.Message;

public class ConexaoTrabalhoTeste {

	public static void main(String[] args) {
		try {
			Class.forName("pedrociarlini.mesaderpg.net.trabalho.ConnLayer");

			ServerTest t1 = new ServerTest();
			t1.start();

			ConexaoTrabalho conn = new ConexaoTrabalho("localhost", 5555);
			DataReceivedListener d = new DataReceivedListener() {
				public void onDataReceived(DataEvent ev) {
					System.out.println(ev.getReceivedData());
				}
			};
			conn.addDataReceivedListener(d);
			conn.open();
			Object data = conn.receive();
			System.out.println(data);
			//conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static class ServerTest extends Thread {
		@Override
		public void run() {
			ServerSocket server;
			try {
				setName("ServerTest");
				server = new ServerSocket(5555);
				Socket s = server.accept();
				ObjectOutputStream ois = new ObjectOutputStream(s
						.getOutputStream());

				Message m1 = new Message();
				m1.setBytes(SerializationUtils.serialize(new JogadorVO("Nome", false)));
				ois.writeObject(m1);
				s.close();
				server.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};
}
