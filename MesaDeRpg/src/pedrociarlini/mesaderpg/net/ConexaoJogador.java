package pedrociarlini.mesaderpg.net;

import java.io.IOException;

import pedrociarlini.mesaderpg.model.JogadorVO;


public class ConexaoJogador extends ConexaoImpl {
    
    public ConexaoJogador() {
        super();
    }

    public ConexaoJogador(String ip, int porta) throws IOException {
        super(ip, porta);
    }
    
    public JogadorVO open(JogadorVO jogador) throws IOException, ClassNotFoundException {
        super.open();
        JogadorVO remoteJogador = (JogadorVO) getOis().readObject();
        send(jogador);
        return remoteJogador;
    }
    
    public int receivePorta() {
        return 0;
    }
}