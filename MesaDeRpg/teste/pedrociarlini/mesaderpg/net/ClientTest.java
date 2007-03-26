package pedrociarlini.mesaderpg.net;

import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Classe utilizada para testar vários aspectos da conexão
 * @author pedro
 *
 */
public class ClientTest {

	public static void main(String[] args) {
		ConexaoMainServer server = new ConexaoMainServer();
		Thread t = new Thread(server);
		t.setName("Server");
		t.start();
		
		try {
			Socket s;
			for (int i = 1; i <= 3; i++) {
				s = new Socket("localhost", 26270);
				System.out.println("Socket " + i + ": " + s);
				/*
				System.out.println(new ObjectInputStream(s.getInputStream())
						.readObject());
				*/
				new ObjectOutputStream(s.getOutputStream()).writeObject("TESTE HA HA\n");
			}
			server.stopServer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}