package pedrociarlini.mesaderpg.net.trabalho;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import trabalho.IConnection;
import trabalho.IMessage;

/**
 * O protocolo de transporte usado é o TCP
 * @author pedro
 */
public class Connection implements IConnection {

	Socket socket;

    ObjectInputStream receiver;

    ObjectOutputStream sender;
    
    private static int connectionCounter = 0;

    /**
     * Cria uma <code>Connection</code> baseada no endereço e porta passados
     * por parâmetro. O protocolo de transporte usado é o TCP.
     * 
     * @param ip
     *            Endereço a ser conectado.
     * @param porta
     *            Porta que estará com a aplicação esperando a conexão.
     * @throws Exception
     *             Para qualquer erro que ocorrer.
     */
    Connection(InetAddress ip, int porta) throws Exception {
        this(new Socket(ip, porta));
    }
    
    public Connection(Socket client) throws Exception {
        socket = client;
        connectionCounter++;
        receiver = new ObjectInputStream(socket.getInputStream());
        sender = new ObjectOutputStream(socket.getOutputStream());
    }

    /**
     * Fecha a conexão com a máquina remota.
     */
    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Não foi possível fechar a conexão.");
        }
    }

    /**
     * Altera os bytes da mensagem passada por parâmetro, colocando os
     * bytes que foram enviados pelo host remoto.
     * 
     * Esse método bloqueia a execução até que uma nova mensagem esteja disponível.
     * 
     * @param m
     *            Mensagem a ser alterada.
     * @return Tamanho da mensagem que chegou.
     */
    public int receive(IMessage m) {
        IMessage incomingMessage = null;
        try {
        	if (socket.isConnected()) {
        		incomingMessage = (IMessage) receiver.readObject();
        	}
        	else {
        		throw new IOException("Conexão já estava fechada.");
        	}
        } catch (EOFException e) {
        	throw new RuntimeException("Conexão deve ter sido fechada: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException("Erro de I/O: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Classe \"IMessage\" não encontrada. (" + e.getMessage() + ")");
        }
        m.setBytes(incomingMessage.getBytes());
        return incomingMessage.getBytes().length;
    }

    /**
     * Envia a mensagem passada por parâmetro.
     */
    public int send(IMessage m) {
        try {
            sender.writeObject(m);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao enviar mensagem: " + e.getMessage());
        }
        return 0;
    }

    /**
     * Cria uma nova mensagem, funcionando como fábrica de mensagens.
     */
	public IMessage createBlankMessage() {
		return new Message();
	}
}