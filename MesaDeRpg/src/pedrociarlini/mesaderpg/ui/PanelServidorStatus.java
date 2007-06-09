package pedrociarlini.mesaderpg.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import pedrociarlini.mesaderpg.ui.action.IniciarServidorAction;
import pedrociarlini.mesaderpg.ui.action.PararServidorAction;

public class PanelServidorStatus extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton buttonIniciar = null;

	private JButton buttonParar = null;

	private JLabel labelStatus = null;

	private IniciarServidorAction iniciarServidorAction = null; // @jve:decl-index=0:visual-constraint="386,14"

	private PararServidorAction pararServidorAction = null; // @jve:decl-index=0:visual-constraint="385,62"

	private JList jogadores;

	/**
	 * This is the default constructor
	 */
	public PanelServidorStatus() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		labelStatus = new JLabel();
		labelStatus.setText("PARADO");
		labelStatus.setFont(new Font("Dialog", Font.BOLD, 12));
		labelStatus.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
		labelStatus.setForeground(Color.red);
		labelStatus.setHorizontalAlignment(SwingConstants.CENTER);
		GridLayout gridLayout = new GridLayout();
		gridLayout.setRows(1);
		gridLayout.setColumns(2);
		this.setLayout(gridLayout);
		this.setSize(300, 28);
		this.add(getButtonIniciar(), null);
		this.add(getButtonParar(), null);
		this.add(labelStatus, null);
	}

	/**
	 * This method initializes buttonIniciar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getButtonIniciar() {
		if (buttonIniciar == null) {
			buttonIniciar = new JButton();
			buttonIniciar.setAction(getIniciarServidorAction());
			buttonIniciar.setText("Iniciar");
			getIniciarServidorAction().putValue(
					IniciarServidorAction.BOTAO_INICAR_SERVIDOR, buttonIniciar);
			getIniciarServidorAction().putValue(
					IniciarServidorAction.BOTAO_PARAR_SERVIDOR,
					getButtonParar());
			getIniciarServidorAction().putValue(
					IniciarServidorAction.LABEL_STATUS_SERVIDOR, labelStatus);
			getIniciarServidorAction().putValue(
					IniciarServidorAction.LISTA_JOGADORES, jogadores);
		}
		return buttonIniciar;
	}

	/**
	 * This method initializes buttonParar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getButtonParar() {
		if (buttonParar == null) {
			buttonParar = new JButton();
			buttonParar.setAction(getPararServidorAction());
			buttonParar.setText("Parar");
			buttonParar.setEnabled(false);
			getPararServidorAction().putValue(
					IniciarServidorAction.BOTAO_INICAR_SERVIDOR,
					getButtonIniciar());
			getPararServidorAction().putValue(
					IniciarServidorAction.BOTAO_PARAR_SERVIDOR,
					getButtonParar());
			getPararServidorAction().putValue(
					IniciarServidorAction.LABEL_STATUS_SERVIDOR, labelStatus);
		}
		return buttonParar;
	}

	/**
	 * This method initializes iniciarServidorAction
	 * 
	 * @return pedrociarlini.mesaderpg.ui.action.IniciarServidorAction
	 */
	private IniciarServidorAction getIniciarServidorAction() {
		if (iniciarServidorAction == null) {
			iniciarServidorAction = new IniciarServidorAction();
		}
		return iniciarServidorAction;
	}

	/**
	 * This method initializes pararServidorAction
	 * 
	 * @return pedrociarlini.mesaderpg.ui.action.PararServidorAction
	 */
	private PararServidorAction getPararServidorAction() {
		if (pararServidorAction == null) {
			pararServidorAction = new PararServidorAction();
		}
		return pararServidorAction;
	}

	public void setListJogadores(JList jogadores) {
		this.jogadores = jogadores;
		getIniciarServidorAction().putValue(
				IniciarServidorAction.LISTA_JOGADORES, jogadores);
	}

} // @jve:decl-index=0:visual-constraint="10,10"
