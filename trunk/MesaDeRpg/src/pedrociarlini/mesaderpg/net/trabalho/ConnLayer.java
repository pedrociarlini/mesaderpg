package pedrociarlini.mesaderpg.net.trabalho;

import java.net.InetAddress;

import trabalho.IConnLayer;
import trabalho.IConnection;


public class ConnLayer implements IConnLayer {

	public static final String CONN_NAME = "TCP_CIARLINI_CONN";
    
    static {
    	ConnectionLayerFactory.registerConnection(CONN_NAME, ConnLayer.class);
    }

    /**
     * Cria uma nova instância da classe <code>Connection</code>.
     */
    public IConnection openConnection(InetAddress ip, int porta) {
        Connection conn = null;
        try {
            conn = new Connection(ip, porta);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }
  
}
