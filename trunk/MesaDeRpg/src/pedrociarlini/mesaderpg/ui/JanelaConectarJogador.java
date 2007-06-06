package pedrociarlini.mesaderpg.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pedrociarlini.mesaderpg.net.Conexao;
import pedrociarlini.mesaderpg.net.ConexaoFactory;
import pedrociarlini.mesaderpg.ui.util.MensagensUtil;

public class JanelaConectarJogador extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JTextField textFieldIp = null;

	private JLabel labelIP = null;

	private JButton buttonOk = null;

	private JPanel panelBotoes = null;

	private JButton buttonCancelar = null;

	private Conexao conexaoJogador; // @jve:decl-index=0:

	private JLabel labelPorta = null;

	private JTextField textFieldPorta = null;

	/**
	 * This is the default constructor
	 */
	public JanelaConectarJogador() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(344, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("Conectar jogador");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints21.gridy = 1;
			gridBagConstraints21.weightx = 1.0;
			gridBagConstraints21.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints21.gridx = 1;
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridx = 0;
			gridBagConstraints12.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints12.anchor = GridBagConstraints.EAST;
			gridBagConstraints12.gridy = 1;
			labelPorta = new JLabel();
			labelPorta.setText("Porta:");
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = -1;
			gridBagConstraints.gridy = -1;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridwidth = 2;
			gridBagConstraints2.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints2.gridy = 3;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints11.anchor = GridBagConstraints.EAST;
			gridBagConstraints11.gridy = 0;
			labelIP = new JLabel();
			labelIP.setText("IP:");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints1.gridwidth = 1;
			gridBagConstraints1.gridy = 0;
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(getTextFieldIp(), gridBagConstraints1);
			jContentPane.add(labelIP, gridBagConstraints11);
			jContentPane.add(getPanelBotoes(), gridBagConstraints2);
			jContentPane.add(labelPorta, gridBagConstraints12);
			jContentPane.add(getTextFieldPorta(), gridBagConstraints21);
		}
		return jContentPane;
	}

	/**
	 * This method initializes textFieldIp
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTextFieldIp() {
		if (textFieldIp == null) {
			textFieldIp = new JTextField();
			textFieldIp.setPreferredSize(new Dimension(150, 20));
		}
		return textFieldIp;
	}

	/**
	 * This method initializes buttonOk
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getButtonOk() {
		if (buttonOk == null) {
			buttonOk = new JButton();
			buttonOk.setText("Ok");
			buttonOk.addActionListener(this);
		}
		return buttonOk;
	}

	/**
	 * This method initializes panelBotoes
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelBotoes() {
		if (panelBotoes == null) {
			panelBotoes = new JPanel();
			panelBotoes.setLayout(new FlowLayout());
			panelBotoes.add(getButtonOk(), null);
			panelBotoes.add(getButtonCancelar(), null);
		}
		return panelBotoes;
	}

	/**
	 * This method initializes buttonCancelar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getButtonCancelar() {
		if (buttonCancelar == null) {
			buttonCancelar = new JButton();
			buttonCancelar.setText("Cancelar");
			buttonCancelar.addActionListener(this);
		}
		return buttonCancelar;
	}

	public static Conexao showJogadorDialog() {
		JanelaConectarJogador janela = new JanelaConectarJogador(); // @ivj
		janela.setModal(true);
		janela.setVisible(true);
		return janela.conexaoJogador;
	} // @ijv

	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == getButtonOk()) {
			try {
				this.conexaoJogador = ConexaoFactory.createConexaoInstance();
				this.conexaoJogador.open(getTextFieldIp().getText(), Integer
						.parseInt(getTextFieldPorta().getText()));
				dispose();
			} catch (NumberFormatException ex) {
				MensagensUtil.showMensagemErro("A porta digitada tem que ser numérica.");
			} catch (IOException ex) {
				ex.printStackTrace();
				MensagensUtil.showMensagemErro("Não foi possível se conectar ao jogador remoto." + "(" + ex.getMessage() + ")");
			}
		} else if (ev.getSource() == getButtonCancelar()) {
			this.conexaoJogador = null;
			dispose();
		}
	}

	/**
	 * This method initializes textFieldPorta
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTextFieldPorta() {
		if (textFieldPorta == null) {
			textFieldPorta = new JTextField();
			textFieldPorta.setPreferredSize(new Dimension(150, 20));
		}
		return textFieldPorta;
	}

} // @jve:decl-index=0:visual-constraint="14,10"
