package arthurlandim.mesaderpg.arena;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pedrociarlini.mesaderpg.model.JogadorVO;
import javax.swing.WindowConstants;

public class ArenaFrame extends JFrame implements ArenaInterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7587352830855485212L;

	ArenaCanvas canvas;

	private JPanel panelComandos;

	private JButton btInserir;

	private JTextField textNome;

	private JPanel principalPane;

	public ArenaFrame() {
		super();
		initialize();
	}

	private void initialize() {
		this.setContentPane(getPrincipalPane());
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Arena de jogadores");
		setSize(640, 480);
		setVisible(true);
	}

	/**
	 * This method initializes principalPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPrincipalPane() {
		if (principalPane == null) {
			BorderLayout borderLayout = new BorderLayout(1, 0);
			principalPane = new JPanel();
			principalPane.setLayout(borderLayout);
			principalPane.add(getCanvas(), BorderLayout.CENTER);

			principalPane.add(getPanelComandos(), BorderLayout.SOUTH);

		}
		return principalPane;
	}

	private JPanel getPanelComandos() {
		if (panelComandos == null) {
			panelComandos = new JPanel();
			panelComandos.setLayout(new GridLayout(1, 3));
			panelComandos.add(getTextNome());
			panelComandos.add(getBtInserir());
			JLabel label = new JLabel("x,y: ", JLabel.RIGHT);
			panelComandos.add(label);
			getCanvas().setLabel(label);
		}
		return panelComandos;
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

	public JButton getBtInserir() {
		if (btInserir == null) {
			btInserir = new JButton();
			btInserir.setText("Inserir Jogador");
			btInserir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					adicionarJogador(new JogadorVO(getTextNome().getText(),
							false));
					getTextNome().setText(getTextNome().getText() + " 2");
				}
			});
		}
		return btInserir;
	}

	public JTextField getTextNome() {
		if (textNome == null) {
			textNome = new JTextField();
		}
		return textNome;
	}

	public ArenaCanvas getCanvas() {
		if (canvas == null) {
			canvas = new ArenaCanvas();
		}
		return canvas;
	}
}
