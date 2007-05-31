package arthurlandim.mesaderpg.arena;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ArenaFrame extends JFrame {
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

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setSize(640, 480);
		setVisible(true);
	}

	public static void main(String arg[]) {
		new ArenaFrame();
	}


}
