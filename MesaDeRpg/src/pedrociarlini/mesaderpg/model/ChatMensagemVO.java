package pedrociarlini.mesaderpg.model;

import java.io.Serializable;

public class ChatMensagemVO implements Serializable {

	private String mensagem;

	private String jogadorNome;

	public ChatMensagemVO(String text, String nomeJogador) {
		setMensagem(text);
		setJogadorNome(nomeJogador);
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getJogadorNome() {
		return jogadorNome;
	}

	public void setJogadorNome(String jogadorNome) {
		this.jogadorNome = jogadorNome;
	}

	@Override
	public String toString() {
		return ChatMensagemVO.class.getSimpleName()
				+ "(jogadorNome: "
				+ jogadorNome
				+ "; mensagem: "
				+ mensagem.substring(0,
						(mensagem.length() > 15) ? 14: mensagem.length()
								)
				+ "...)";
	}
}
