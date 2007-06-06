package pedrociarlini.mesaderpg.net;

import java.awt.event.ActionEvent;
import java.io.IOException;

import pedrociarlini.mesaderpg.ui.action.AceitarConexaoJogador;

public class MainServer implements Runnable {
    
    private int porta;

    Conexao conn;
    
	private boolean closed = true;

    public MainServer(int port) throws IOException {
    	porta = port;
    }

    public void run() {
        try {
	    	closed = false;
            while (!closed) {
                conn = ConexaoFactory.createConexaoInstance();
                conn.acceptConnection(porta);
                
                aceitarJogador(conn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void aceitarJogador(Conexao conn) {
        AceitarConexaoJogador action = new AceitarConexaoJogador();
        action.putValue(AceitarConexaoJogador.JOGADOR_CONEXAO, conn);
        action.actionPerformed(new ActionEvent(this, 0,
				AceitarConexaoJogador.class.getSimpleName()));
	}

	public void stopServer() {
    	try {
    		closed = true;
    		conn.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
    }
}
