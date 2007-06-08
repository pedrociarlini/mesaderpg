package arthurlandim.mesaderpg.arena;

import pedrociarlini.mesaderpg.model.JogadorVO;

public interface ArenaInterface {
	public void adicionarJogador(JogadorVO jogador);

	public void removerJogador(JogadorVO jogador);
}
