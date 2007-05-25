package trabalho;

public interface IConnection {

    int send(IMessage m);

    int receive(IMessage m);

    void close();
}
