package pedrociarlini.mesaderpg.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import pedrociarlini.mesaderpg.net.event.DataEvent;
import pedrociarlini.mesaderpg.net.event.DataReceivedListener;

public class MainServer implements Runnable {
    
    ServerSocket listener;
    
    private int porta;
    
    List<Conexao> clientes = new ArrayList<Conexao>();
    
	private boolean closed = true;

    public MainServer(int port) throws IOException {
    	porta = port;
    }

    public void run() {
        try {
	    	closed = false;
            Socket client;
            while (!closed) {
                Conexao conn = ConexaoFactory.createConexaoInstance();
                conn.acceptConnection(porta);
                
                conn.addDataReceivedListener(new DataReceivedListener() {
					public void onDataReceived(DataEvent ev) {
						System.out.println( ev.getSource() + " - " + ev.getReceivedData());
					}
                });
                clientes.add(conn);
                
                // TODO Implementar action para inserir o jogador na lista
            }
        } catch (Exception e) {
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
