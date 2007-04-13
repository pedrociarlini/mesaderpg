package pedrociarlini.mesaderpg.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import pedrociarlini.mesaderpg.net.event.DataEvent;
import pedrociarlini.mesaderpg.net.event.DataReceivedListener;

public class ConexaoMainServer implements Runnable {
    
    ServerSocket listener;
    
    List<Conexao> clientes = new ArrayList<Conexao>();
    
	private boolean closed = true;

    public ConexaoMainServer(int port) throws IOException {
    	listener = new ServerSocket(port);
    }

    public void run() {
        try {
	    	closed = false;
            Socket client;
            while (!closed) {
                client = listener.accept();
                // TESTES
                /*
                new ObjectOutputStream(client.getOutputStream())
						.writeObject(new JogadorVO("Pedro Teste", true));
				*/
                Conexao conn = new ConexaoImpl(client);
                conn.addDataReceivedListener(new DataReceivedListener() {
					public void onDataReceived(DataEvent ev) {
						System.out.println( ev.getSource() + " - " + ev.getReceivedData());
					}
                });
                clientes.add(conn);
                
                // TODO Implementar action para inserir o jogador na lista
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void stopServer() {
    	try {
    		closed = true;
			listener.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
    }
}
