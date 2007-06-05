package pedrociarlini.mesaderpg.net;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import pedrociarlini.mesaderpg.net.event.DataReceivedListener;

public abstract class AbstractConexao implements Conexao {

	private Set<DataReceivedListener> listeners = new HashSet<DataReceivedListener>();

	private String ip;

	private int porta;

	public void addDataReceivedListener(DataReceivedListener listener) {
		this.listeners.add(listener);
	}

	public void open(String ip, int porta) throws IOException {
		this.ip = ip;
		this.porta = porta;
		open();
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}
	
	protected Set<DataReceivedListener> getListeners() {
		return listeners;
	}
}
