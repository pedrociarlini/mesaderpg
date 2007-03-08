package pedrociarlini.mesaderpg.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

import pedrociarlini.mesaderpg.net.event.DataReceivedListener;

public class ConexaoJogador implements Conexao {
	
	private Set<DataReceivedListener> listeners = new HashSet<DataReceivedListener>();
	
	private ObjectInputStream ois = null;
	
	public ConexaoJogador(Socket socket) throws IOException {
		if (socket == null) {
			throw new IllegalArgumentException("Socket não pode ser nulo.");
		}
		ois = new ObjectInputStream(socket.getInputStream());
		
	}

	public void addDataReceivedListener(DataReceivedListener listener) {
		this.listeners.add(listener);
	}

	public void send(Object obj) throws IOException {

	}

	public void close() throws IOException {
		// TODO implementar todo o conjunto de operações para abrir e fechar conexão
		
	}
	// TODO Implementar criação de socket etc. 

	public void open() throws IOException {
	}
}
