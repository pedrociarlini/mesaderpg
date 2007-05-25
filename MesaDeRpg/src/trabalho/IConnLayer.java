package trabalho;

import java.net.*;

public interface IConnLayer {

    IConnection openConnection(InetAddress ip, int porta);
    // IServer createServer(int porta);
    // IConnection accessConnection(IServer s);
}
