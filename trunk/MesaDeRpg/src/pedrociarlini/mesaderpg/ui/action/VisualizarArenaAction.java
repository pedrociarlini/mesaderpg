package pedrociarlini.mesaderpg.ui.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import pedrociarlini.mesaderpg.model.JogadorVO;

import arthurlandim.mesaderpg.arena.ArenaFrame;

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
    	ArenaFrame frame = new arthurlandim.mesaderpg.arena.ArenaFrame();
    	frame.setVisible(true);
    	new AdicionarJogador(frame).start();
    }
    
    class AdicionarJogador extends Thread {
    	ArenaFrame frame;
    	public AdicionarJogador(ArenaFrame frame) {
			this.frame = frame;
		}
    	
    	@Override
    	public void run() {
    		// TODO Auto-generated method stub
    		super.run();
    		JogadorVO jogador;
    		while (true) {
    			
    			jogador = new JogadorVO();
    			jogador.setNome("Teste " + System.currentTimeMillis());
    			
        		frame.adicionarJogador(jogador);
        		try {
					sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	}
    }
}