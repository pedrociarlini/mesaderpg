package pedrociarlini.mesaderpg.ui.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JList;

import pedrociarlini.mesaderpg.model.JogadorVO;
import pedrociarlini.mesaderpg.net.ConexaoJogador;
import pedrociarlini.mesaderpg.ui.JanelaConectarJogador;
import pedrociarlini.mesaderpg.ui.JogadorComponent;


public class ConectarJogadorAction extends AbstractAction {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public static final String JOGADOR_LIST = "JOGADOR_LIST";
    
    public static final String JOGADOR_VO = "KEY_JOGADOR_VO";
    
    public ConectarJogadorAction() {
        putValue(Action.NAME, "ConectarJogador");
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_J);
        putValue(Action.LONG_DESCRIPTION, "Conecta um jogador que esteja na rede.");
    }

    public void actionPerformed(ActionEvent e) {
        JList listaJogadores = (JList) getValue(JOGADOR_LIST);
        JogadorVO jogador = (JogadorVO) getValue(JOGADOR_VO);;
        JogadorVO remoteJogador = null;
        ConexaoJogador conn = null;
        try {
            conn = JanelaConectarJogador.showJogadorDialog();
            remoteJogador = conn.open(jogador);
            remoteJogador.setConn(conn);
            listaJogadores.add(new JogadorComponent(remoteJogador));
        } catch (IOException e1) {
            // TODO Implementar tratamento para o erro.
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
