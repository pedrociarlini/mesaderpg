package pedrociarlini.mesaderpg.model;

import java.io.Serializable;

public class ChatMensagemVO implements Serializable{
	
	private String mensagem;
	
	private String jogadorNome;

	public ChatMensagemVO(String text, String string) {
		setMensagem(text);
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
}
