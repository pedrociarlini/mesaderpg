package pedrociarlini.mesaderpg.net.trabalho;

import java.net.InetAddress;

import pedrociarlini.mesaderpg.net.Conexao;
import pedrociarlini.mesaderpg.net.ConexaoImpl;

import trabalho.IConnLayer;
import trabalho.IConnection;


public class ConnLayer implements IConnLayer {

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
