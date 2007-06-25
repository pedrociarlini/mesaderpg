package pedrociarlini.mesaderpg.ui.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JList;

import pedrociarlini.mesaderpg.business.JogadoresBusiness;
import pedrociarlini.mesaderpg.model.JogadorVO;
import pedrociarlini.mesaderpg.ui.JanelaChat;
import pedrociarlini.mesaderpg.ui.JogadorComponent;
import pedrociarlini.mesaderpg.ui.util.MensagensUtil;

/**
 * Inicia um chat com um jogador. Abre a janela com aquele jogador caso a mesma
 * ainda não esteja aberta.
 * 
 * @author Pedro Ciarlini
 */
public class IniciarChatAction extends AbstractAction {

	public static final String JOGADOR_VO = "KEY_JOGADOR_VO";

	public static final String JLIST_JOGADORES = "KEY_JLIST_JOGADORES";

	public IniciarChatAction() {
		putValue(Action.NAME, "IniciarChat");
		putValue(Action.MNEMONIC_KEY, KeyEvent.VK_C);
		putValue(Action.LONG_DESCRIPTION,
				"Inicia um chat com um ou mais jogadores selecionados.");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -5790855859508272347L;

	public void actionPerformed(ActionEvent ev) {
		JogadorVO jogador = (JogadorVO) getValue(JOGADOR_VO);
		JList jListJogadores = (JList) getValue(JLIST_JOGADORES);
		try {
			if (jListJogadores != null) {
				for (Object obj : jListJogadores.getSelectedValues()) {
					iniciarChat(((JogadorComponent)obj).getJogador());
				}
			} else {
				if (jogador != null) {
					iniciarChat(jogador);
				} else {
					throw new Exception("Nenhum jogador selecionado");
				}
			}
		} catch (Exception ex) {
			MensagensUtil.showMensagemErro("Erro ao iniciar chat: "
					+ ex.getMessage());
		}
	}
	
	private void iniciarChat(JogadorVO jogador) {
		String nome = jogador.getNome();
		JanelaChat chat = JanelaChat.getChat(nome);
		if (chat != null) {
			chat.setVisible(true);
			chat.requestFocusInWindow();
		} else {
			new JanelaChat(JogadoresBusiness.getJogador(nome)).setVisible(true);
		}
	}
}