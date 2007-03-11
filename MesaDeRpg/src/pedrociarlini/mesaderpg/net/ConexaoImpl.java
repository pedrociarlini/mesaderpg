package pedrociarlini.mesaderpg.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

import pedrociarlini.mesaderpg.net.event.DataEvent;
import pedrociarlini.mesaderpg.net.event.DataReceivedListener;

public class ConexaoImpl implements Conexao {
	
	private Set<DataReceivedListener> listeners = new HashSet<DataReceivedListener>();
	
	private ObjectInputStream ois = null;

    private ObjectOutputStream oos = null;

    private Socket socket;
    
    private String ip;
    
    private int porta;
	
    public ConexaoImpl() {
    }

	public ConexaoImpl(String ip, int porta) throws IOException {
        this.ip = ip;
        this.porta = porta;
    }

    public void addDataReceivedListener(DataReceivedListener listener) {
		this.listeners.add(listener);
	}

	public void close() throws IOException {
        this.socket.close();
	}
	// TODO Implementar criação de socket etc. 

	public void open(String ip, int porta) throws IOException {
        this.ip = ip;
        this.porta = porta;
        open();
	}

    public void open() throws IOException {
        this.socket = new Socket(ip, porta);
        ois = new ObjectInputStream(this.socket.getInputStream());
        oos = new ObjectOutputStream(this.socket.getOutputStream());
        new Thread(new DataReader()).start();
    }
    
    private class DataReader implements Runnable {
        public void run() {
            Object data;
            while (true) {
                try {
                    data = ois.readObject();
                    for (DataReceivedListener listener : ConexaoImpl.this.listeners) {
                        listener.onDataReceived(new DataEvent(this, data));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void send(Object data) throws IOException {
        getOos().writeObject(data);
    }
    
    protected ObjectOutputStream getOos() {
        return oos;
    }
    
    protected String getIp() {
        return ip;
    }
    
    protected int getPorta() {
        return porta;
    }

    protected ObjectInputStream getOis() {
        return ois;
    }
}