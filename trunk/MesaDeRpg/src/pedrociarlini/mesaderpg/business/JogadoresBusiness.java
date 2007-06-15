package pedrociarlini.mesaderpg.business;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;

import pedrociarlini.mesaderpg.model.ChatMensagemVO;
import pedrociarlini.mesaderpg.model.JogadorVO;
import pedrociarlini.mesaderpg.net.event.DataEvent;
import pedrociarlini.mesaderpg.net.event.DataReceivedListener;
import pedrociarlini.mesaderpg.ui.JanelaChat;

public class JogadoresBusiness {

	public static final Serializable CONEXAO_START = "OK";

	public static final Serializable CONEXAO_SUCCESS = "SUCCESS";

	private static Map<String, JogadorVO> jogadores = new HashMap<String, JogadorVO>();
	
	private static JogadorVO jogadorLocal;


	/**
	 * Insere um jogador na lista de jogadores da aplicação. Verifica se existe
	 * um jogador na lista antes, e gera uma exceção caso positivo.
	 * 
	 * @param jogador
	 * @throws Exception
	 */
	public static void conectarJogador(JogadorVO jogador) throws Exception {
		if (!jogadores.containsKey(jogador.getNome())) {
			jogadores.put(jogador.getNome(), jogador);
		} else {
			throw new Exception(
					"Já existe um jogador com esse nome cadastrado.");
		}
	}

	public static DataReceivedListener createJogadorListener(String nome) {
		return new JogadorListener(nome);
	}

	/**
	 * Implementa o listener padrão para dados vindos de um jogador remoto.
	 * TODO documentar melhor.
	 * TODO verificar viabilidade de colocar essa classe em outro local.
	 * @author Pedro Ciarlini
	 *
	 */
	private static class JogadorListener implements DataReceivedListener {

		private String nome;

		public JogadorListener(String nome) {
			this.nome = nome;
		}

		public void onDataReceived(DataEvent ev) {
			Object data = ev.getReceivedData();
			if (data instanceof AbstractAction) {
				System.out.println("Ação executada!!!");
			}
			else if (data instanceof ChatMensagemVO) {
				ChatMensagemVO mensagem = (ChatMensagemVO) data;
				JanelaChat chat = JanelaChat.getChat(mensagem.getJogadorNome());
				if(chat == null) {
					chat = new JanelaChat(getJogador(mensagem.getJogadorNome()));
				}
				chat.appendMensagem(mensagem);
			}
			System.out.println("Dados chegando (" + nome + ": " + data);
		}
	}

	public static void setJogadorLocal(JogadorVO jogador) {
		jogadorLocal = jogador;
	}
	
	public static JogadorVO getJogadorLocal() {
		return jogadorLocal;
	}

	public static Object[] getListaJogadores() {
		return jogadores.values().toArray();
	}

	public static JogadorVO getJogador(String nome) {
		return jogadores.get(nome);
	}
}
