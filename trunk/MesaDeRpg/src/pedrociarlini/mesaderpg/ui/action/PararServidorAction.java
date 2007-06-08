package pedrociarlini.mesaderpg.ui.action;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;

import pedrociarlini.mesaderpg.net.MainServer;
import pedrociarlini.mesaderpg.ui.util.MensagensUtil;

public class PararServidorAction extends AbstractAction {

	public static final String BOTAO_INICAR_SERVIDOR = "KEY_BOTAO_INICAR_SERVIDOR";

	public static final String BOTAO_PARAR_SERVIDOR = "KEY_BOTAO_PARAR_SERVIDOR";

	public static final String LABEL_STATUS_SERVIDOR = "KEY_LABEL_STATUS_SERVIDOR";

	public PararServidorAction() {
		putValue(Action.NAME, "PararServidor");
		putValue(Action.MNEMONIC_KEY, KeyEvent.VK_P);
		putValue(Action.LONG_DESCRIPTION,
				"Inicia o servidor que aceita conexão de outros jogadores.");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -5790855859508272347L;

	public void actionPerformed(ActionEvent ev) {
		JButton butaoIniciar = (JButton) getValue(BOTAO_INICAR_SERVIDOR);
		JButton butaoParar = (JButton) getValue(BOTAO_PARAR_SERVIDOR);
		JLabel status = (JLabel) getValue(LABEL_STATUS_SERVIDOR);
		try {
			MainServer.getInstance().stopServer();
			butaoIniciar.setEnabled(false);
			butaoParar.setEnabled(true);
			status.setText("Iniciado");
			status.setForeground(Color.GREEN);
		} catch (Exception ex) {
			MensagensUtil.showMensagemErro("Erro ao parar servidor: "
					+ ex.getMessage());
		}
	}
}
