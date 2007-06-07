package pedrociarlini.mesaderpg.ui.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import pedrociarlini.mesaderpg.model.ServidorVO;
import pedrociarlini.mesaderpg.ui.JanelaConfigurarServidor;

public class ConfigurarServidorAction extends AbstractAction {

    public static final String SERVIDOR_VO = "KEY_SERVIDOR_VO";

    public ConfigurarServidorAction() {
        putValue(Action.NAME, "ConfigurarServidor");
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_S);
        putValue(Action.LONG_DESCRIPTION, "Configura o servidor que aceitará conexões de outros jogadores.");
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public void actionPerformed(ActionEvent e) {
    	ServidorVO jogador = (ServidorVO) getValue(SERVIDOR_VO);
    	ServidorVO novoJogador = JanelaConfigurarServidor.showServidorDialog(jogador);
        if (novoJogador != null) {
            fillServidorVO(novoJogador, jogador);
        }
    }

    private void fillServidorVO(ServidorVO source, ServidorVO dest) {
        if (dest != null && source != null) {
            dest.setPorta(source.getPorta());
            dest.setBackLog(source.getBackLog());
        }
    }
}