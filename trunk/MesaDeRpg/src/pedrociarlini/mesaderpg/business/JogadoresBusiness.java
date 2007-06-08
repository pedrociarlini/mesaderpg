package pedrociarlini.mesaderpg.business;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.AbstractAction;

import pedrociarlini.mesaderpg.model.JogadorVO;
import pedrociarlini.mesaderpg.net.event.DataEvent;
import pedrociarlini.mesaderpg.net.event.DataReceivedListener;

public class JogadoresBusiness {

	public static final Serializable CONEXAO_START = "OK";

	public static final Serializable CONEXAO_SUCCESS = "SUCCESS";

	private static final Vector<JogadorVO> listaJogadores = new Vector<JogadorVO>();

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
			System.out.println("Dados chegando (" + nome + ": " + data);
		}
	}

	public static void setJogadorLocal(JogadorVO jogador) {
		jogadorLocal = jogador;
	}
	
	public static JogadorVO getJogadorLocal() {
		return jogadorLocal;
	}
	
	public static JogadorVO[] getListaJogadores() {
		return (JogadorVO[]) jogadores.values().toArray();
	}
}
