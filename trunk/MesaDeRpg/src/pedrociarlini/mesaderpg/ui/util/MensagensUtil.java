package pedrociarlini.mesaderpg.ui.util;

import javax.swing.JOptionPane;

public class MensagensUtil {

	/**
	 * Exibe uma tela de erro.
	 * 
	 * @param msg
	 *            Mensagem a ser exibida.
	 */
	public static void showMensagemErro(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Erro na aplicação",
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Exibe uma tela de alerta.
	 * @param Mensagem a ser exibida.
	 */
	public static void showMensagemAlerta(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Atenção",
				JOptionPane.WARNING_MESSAGE);
	}

}
