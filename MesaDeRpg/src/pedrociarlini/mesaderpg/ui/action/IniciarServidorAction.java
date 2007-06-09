package pedrociarlini.mesaderpg.ui.action;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

import pedrociarlini.mesaderpg.business.ServidorBusiness;
import pedrociarlini.mesaderpg.model.ServidorVO;
import pedrociarlini.mesaderpg.net.MainServer;
import pedrociarlini.mesaderpg.ui.util.MensagensUtil;

public class IniciarServidorAction extends AbstractAction {

	public static final String BOTAO_INICAR_SERVIDOR = "KEY_BOTAO_INICAR_SERVIDOR";

	public static final String BOTAO_PARAR_SERVIDOR = "KEY_BOTAO_PARAR_SERVIDOR";

	public static final String LABEL_STATUS_SERVIDOR = "KEY_LABEL_STATUS_SERVIDOR";

	public static final String LISTA_JOGADORES = "KEY_LISTA_JOGADORES";

	public IniciarServidorAction() {
		putValue(Action.NAME, "IniciarServidor");
		putValue(Action.MNEMONIC_KEY, KeyEvent.VK_I);
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
		JList listaJogatores = (JList) getValue(LISTA_JOGADORES);
		
		JLabel status = (JLabel) getValue(LABEL_STATUS_SERVIDOR);
		ServidorVO conf = ServidorBusiness.getConfiguracaoServidor();
		try {
			MainServer server = MainServer.createInstance(conf.getPorta());
			server.setListaJogadores(listaJogatores);
			server.startServer();
			butaoIniciar.setEnabled(false);
			butaoParar.setEnabled(true);
			status.setText("Iniciado");
			status.setForeground(Color.GREEN);
		} catch (Exception ex) {
			MensagensUtil.showMensagemErro("Erro ao iniciar servidor: "
					+ ex.getMessage());
		}
	}
}
