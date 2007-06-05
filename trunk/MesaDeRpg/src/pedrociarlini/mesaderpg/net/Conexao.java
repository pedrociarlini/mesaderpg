package pedrociarlini.mesaderpg.net;

import java.io.IOException;
import java.io.Serializable;

import pedrociarlini.mesaderpg.net.event.DataReceivedListener;

public interface Conexao {
	/**
	 * envia o objeto passado por parâmetro para o destino da conexão. 
	 * @param obj
	 * @throws IOException
	 */
	public void send(Serializable obj) throws IOException;
	
	
	public void addDataReceivedListener(DataReceivedListener listener);
	
	public void open(String ip, int porta) throws IOException;

    public void open() throws IOException, IllegalStateException;

	public void close() throws IOException;
	
	public boolean isClosed();

}
