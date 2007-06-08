package arthurlandim.mesaderpg.arena;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pedrociarlini.mesaderpg.model.JogadorVO;

public class ArenaFrame extends JFrame implements ArenaInterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7587352830855485212L;

	ArenaCanvas canvas;

	public ArenaFrame() {
		super();
		Container container = getContentPane();

		canvas = new ArenaCanvas();
		container.add(canvas);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		panel.add(new JLabel("x,y: ", JLabel.RIGHT));
		container.add(panel, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setSize(640, 480);
		setVisible(true);
	}

	public static void main(String arg[]) {
		new ArenaFrame();
	}

	public void adicionarJogador(JogadorVO jogador) {
		canvas.adicionarJogador(jogador);
		
	}

	public void removerJogador(JogadorVO jogador) {
		canvas.removerJogador(jogador);
		
	}

}
