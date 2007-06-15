package pedrociarlini.mesaderpg.ui.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JList;

import pedrociarlini.mesaderpg.business.JogadoresBusiness;
import pedrociarlini.mesaderpg.model.JogadorVO;
import pedrociarlini.mesaderpg.net.Conexao;
import pedrociarlini.mesaderpg.ui.JogadorComponent;
import pedrociarlini.mesaderpg.ui.util.MensagensUtil;

public class AceitarConexaoJogadorAction extends AbstractAction {

	public static final String JOGADOR_CONEXAO = "KEY_JOGADOR_CONEXAO";

	public static final String LISTA_JOGADORES = "KEY_LISTA_JOGADORES";

	public AceitarConexaoJogadorAction() {
		putValue(Action.NAME, "AceitarConexaoJogador");
		putValue(Action.MNEMONIC_KEY, KeyEvent.VK_X);
		putValue(Action.LONG_DESCRIPTION,
				"Aceita a tentativa de um jogador de se conectar.");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -5790825859508272347L;

	public void actionPerformed(ActionEvent ev) {
		JogadorVO jogador;
		Conexao conn = (Conexao) getValue(JOGADOR_CONEXAO);
		JList listaJogatores = (JList) getValue(LISTA_JOGADORES);
		try {
			conn.send(JogadoresBusiness.CONEXAO_START);
			jogador = (JogadorVO) conn.receive();
			jogador.setConn(conn);
			JogadoresBusiness.conectarJogador(jogador);
			conn.send(JogadoresBusiness.CONEXAO_SUCCESS);
			conn.send(JogadoresBusiness.getJogadorLocal());
			conn.addDataReceivedListener(JogadoresBusiness
					.createJogadorListener(jogador.getNome()));
			listaJogatores.setListData(getJogadorComponents(JogadoresBusiness
					.getListaJogadores()));
			
		} catch (Throwable ex) {
			try {
				conn.send(ex);
			} catch (IOException e) {
				MensagensUtil.showMensagemErro("Erro ao enviar dados: "
						+ e.getMessage());
			}
		}
	}

	private JogadorComponent[] getJogadorComponents(Object[] jogadores) {
		JogadorComponent[] jogs = new JogadorComponent[jogadores.length];
		for (int i = 0; i < jogadores.length; i++) {
			jogs[i] = new JogadorComponent((JogadorVO)jogadores[i]);
		}
		return jogs;
	}
}
