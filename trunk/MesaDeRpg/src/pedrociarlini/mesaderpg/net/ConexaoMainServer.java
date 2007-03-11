package pedrociarlini.mesaderpg.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConexaoMainServer extends Thread {
    
    public ConexaoMainServer() {
        this(ConexaoMainServer.class.getName());
    }

    public ConexaoMainServer(String name) {
        super(name);
    }

    public void run() {
        try {
            ServerSocket listener = new ServerSocket(26270);
            Socket client;
            while (true) {
                client = listener.accept();
                // TODO Implementar action para inserir o jogador na lista
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
