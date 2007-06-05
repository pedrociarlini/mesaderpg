package pedrociarlini.mesaderpg.ui.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class VisualizarArenaAction extends AbstractAction {

    public VisualizarArenaAction() {
        putValue(Action.NAME, "VisualizarArena");
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_J);
        putValue(Action.LONG_DESCRIPTION, "Visualizar a Arena");
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public void actionPerformed(ActionEvent e) {
        //System.out.println(jogador);
    	new arthurlandim.mesaderpg.arena.ArenaFrame().setVisible(true);
    }
}