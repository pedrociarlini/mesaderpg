package pedrociarlini.mesaderpg.net;

import java.awt.event.ActionEvent;
import java.io.IOException;

import pedrociarlini.mesaderpg.ui.action.AceitarConexaoJogadorAction;

public class MainServer implements Runnable {

	private int porta;

	Conexao conn;

	private boolean closed = true;

	private static MainServer instance;

	private MainServer(int port) throws IOException {
		porta = port;
	}

	public static MainServer createInstance(int porta) throws Exception {
		if (instance == null) {
			instance = new MainServer(porta);
		} else {
			throw new Exception(
					"Servidor já está criado. É necessário pará-lo antes.");
		}
		return instance;
	}

	public static MainServer getInstance() throws Exception {
		if (instance == null) {
			throw new Exception(
					"O servidor não foi criado. É necessário criá-lo antes.");
		}
		return instance;
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
		AceitarConexaoJogadorAction action = new AceitarConexaoJogadorAction();
		action.putValue(AceitarConexaoJogadorAction.JOGADOR_CONEXAO, conn);
		action.actionPerformed(new ActionEvent(this, 0,
				AceitarConexaoJogadorAction.class.getSimpleName()));
	}

	public void startServer() throws Exception {
		new Thread(instance, "MainServer").start();
	}
	
	public void stopServer() {
		try {
			closed = true;
			instance = null;
			conn.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
