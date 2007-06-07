package pedrociarlini.mesaderpg.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelServidorStatus extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton buttonIniciar = null;
	private JButton buttonParar = null;
	private JLabel labelStatus = null;

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
			buttonIniciar.setText("Iniciar");
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
			buttonParar.setText("Parar");
			buttonParar.setEnabled(false);
		}
		return buttonParar;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
