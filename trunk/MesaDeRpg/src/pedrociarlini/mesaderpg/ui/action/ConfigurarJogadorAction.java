package pedrociarlini.mesaderpg.ui.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import pedrociarlini.mesaderpg.model.JogadorVO;
import pedrociarlini.mesaderpg.ui.JanelaConfigurarJogador;

public class ConfigurarJogadorAction extends AbstractAction {

    public static final String JOGADOR_VO = "KEY_JOGADOR_VO";

    public ConfigurarJogadorAction() {
        putValue(Action.NAME, "ConfigurarJogador");
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_J);
        putValue(Action.LONG_DESCRIPTION, "Configura o seu jogador.");
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public void actionPerformed(ActionEvent e) {
        JogadorVO jogador = (JogadorVO) getValue(JOGADOR_VO);
        JogadorVO novoJogador = JanelaConfigurarJogador.showJogadorDialog(jogador);
        if (novoJogador != null) {
            fillJogadorVO(novoJogador, jogador);
        }
    }

    private void fillJogadorVO(JogadorVO source, JogadorVO dest) {
        if (dest != null && source != null) {
            dest.setNome(source.getNome());
            dest.setMestre(source.isMestre());
        }
    }
}