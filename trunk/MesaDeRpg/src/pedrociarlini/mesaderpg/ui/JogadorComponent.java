package pedrociarlini.mesaderpg.ui;

import javax.swing.Icon;
import javax.swing.JLabel;

import pedrociarlini.mesaderpg.model.JogadorVO;


public class JogadorComponent extends JLabel {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 4084681321717585434L;

	public JogadorComponent() {
        super();
    }	
	
    public JogadorComponent(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
    }

    public JogadorComponent(Icon image) {
        super(image);
    }

    public JogadorComponent(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
    }

    public JogadorComponent(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    public JogadorComponent(String text) {
        super(text);
    }

    public JogadorComponent(JogadorVO jogador) {
        this(jogador.getNome());
        setJogador(jogador);
    }

    private JogadorVO jogador;
    
    public JogadorVO getJogador() {
        return jogador;
    }

    public void setJogador(JogadorVO jogador) {
        this.jogador = jogador;
    }
    
    public String toString() {
		return jogador.getNome();
	}
}
