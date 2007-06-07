package pedrociarlini.mesaderpg.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pedrociarlini.mesaderpg.model.ServidorVO;

public class JanelaConfigurarServidor extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JTextField textFieldPorta = null;

	private JLabel labelPorta = null;

	private JButton buttonOk = null;

	private JPanel panelBotoes = null;

	private JButton buttonCancelar = null;

	private ServidorVO servidorVO;

	private JLabel labelFicha = null;

	private JTextField textFieldBackLog = null;

	private JLabel labelBackLog = null;

	/**
	 * This is the default constructor
	 */
	public JanelaConfigurarServidor() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(459, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("Configurar Jogador");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 0;
			gridBagConstraints21.anchor = GridBagConstraints.EAST;
			gridBagConstraints21.weightx = 0.4;
			gridBagConstraints21.gridy = 1;
			labelBackLog = new JLabel();
			labelBackLog.setText("BackLog:");
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints12.gridy = 1;
			gridBagConstraints12.weightx = 0.6;
			gridBagConstraints12.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints12.gridx = 1;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.gridwidth = 2;
			gridBagConstraints4.gridy = 2;
			labelFicha = new JLabel();
			labelFicha
					.setText("Vale a pena configurar e salvar a ficha também? pedrociarlini@gmail.com");
			labelFicha.setFont(new Font("Dialog", Font.PLAIN, 10));
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
			gridBagConstraints11.weightx = 0.4;
			gridBagConstraints11.gridy = 0;
			labelPorta = new JLabel();
			labelPorta.setText("Porta:");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints1.gridwidth = 1;
			gridBagConstraints1.weightx = 0.6;
			gridBagConstraints1.gridy = 0;
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(getTextFieldPorta(), gridBagConstraints1);
			jContentPane.add(labelPorta, gridBagConstraints11);
			jContentPane.add(getPanelBotoes(), gridBagConstraints2);
			jContentPane.add(labelFicha, gridBagConstraints4);
			jContentPane.add(getTextFieldBackLog(), gridBagConstraints12);
			jContentPane.add(labelBackLog, gridBagConstraints21);
		}
		return jContentPane;
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

	public static ServidorVO showJogadorDialog() {
		JanelaConfigurarServidor janela = new JanelaConfigurarServidor(); // @ivj
		janela.setModal(true);
		janela.setVisible(true);
		return janela.servidorVO;
	} // @ijv

	private void fillValues(ServidorVO atual) {
		getTextFieldPorta().setText("" + atual.getPorta());
		getTextFieldBackLog().setText("" + atual.getBackLog());
	}

	public static ServidorVO showServidorDialog(ServidorVO jogador) {
		JanelaConfigurarServidor janela = new JanelaConfigurarServidor(); // @ivj
		janela.fillValues(jogador);
		janela.setModal(true);
		janela.setVisible(true);
		return janela.servidorVO;
	} // @ijv

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getButtonOk()) {
			this.servidorVO = new ServidorVO(Integer
					.parseInt(getTextFieldPorta().getText()), Integer
					.parseInt(getTextFieldBackLog().getText()));
			dispose();
		} else if (e.getSource() == getButtonCancelar()) {
			dispose();
		}
	}

	/**
	 * This method initializes textFieldBackLog
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTextFieldBackLog() {
		if (textFieldBackLog == null) {
			textFieldBackLog = new JTextField();
			textFieldBackLog.setPreferredSize(new Dimension(150, 20));
		}
		return textFieldBackLog;
	}

} // @jve:decl-index=0:visual-constraint="189,156"
