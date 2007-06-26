package arthurlandim.mesaderpg.arena;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pedrociarlini.mesaderpg.model.JogadorVO;
import javax.swing.WindowConstants;
import java.awt.Dimension;

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

	private JButton btLigarJogadores = null;

	public ArenaFrame() {
		super();
		initialize();
	}

	private void initialize() {
		this.setContentPane(getPrincipalPane());
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Arena de jogadores");
		setSize(633, 240);
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
			GridLayout gridLayout = new GridLayout(1, 3);
			gridLayout.setColumns(4);
			panelComandos = new JPanel();
			panelComandos.setLayout(gridLayout);
			panelComandos.add(getTextNome());
			panelComandos.add(getBtInserir());
			panelComandos.add(getBtLigarJogadores(), null);
			JLabel label = new JLabel("x,y: ", JLabel.RIGHT);
			panelComandos.add(label);
			getCanvas().setLabel(label);
		}
		return panelComandos;
	}

	/**
	 * This method initializes btLigarJogadores	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtLigarJogadores() {
		if (btLigarJogadores == null) {
			btLigarJogadores = new JButton();
			btLigarJogadores.setText("Ligar jogadores");
			btLigarJogadores.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JOptionPane.showMessageDialog(ArenaFrame.this,
							"Clique nos jogadores em sequencia, para liga-los");
					getCanvas().setLigandoJogadores(true);
				}
			});
		}
		return btLigarJogadores;
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
}  //  @jve:decl-index=0:visual-constraint="20,-19"
