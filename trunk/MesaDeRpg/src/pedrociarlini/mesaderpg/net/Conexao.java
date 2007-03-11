package pedrociarlini.mesaderpg.net;

import java.io.IOException;

import pedrociarlini.mesaderpg.net.event.DataReceivedListener;

public interface Conexao {
	/**
	 * envia o objeto passado por parâmetro para o destino da conexão. 
	 * @param obj
	 * @throws IOException
	 */
	public void send(Object obj) throws IOException;
	
	
	public void addDataReceivedListener(DataReceivedListener listener);
	
	public void open(String ip, int porta) throws IOException;

    public void open() throws IOException;

	public void close() throws IOException;

}
