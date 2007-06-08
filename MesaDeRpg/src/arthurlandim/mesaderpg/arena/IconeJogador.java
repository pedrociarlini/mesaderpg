/**
 * 
 */
package arthurlandim.mesaderpg.arena;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

/**
 * @author Familia
 *
 */
public class IconeJogador extends ImageIcon {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7161521094067925577L;
	private int x,y = 10;
	private String nome;
	private Rectangle2D imagemRect;

	public IconeJogador() {
	}
	
	public IconeJogador(BufferedImage img, int x, int y, String nome) {
		super(img);
		this.x = x;
		this.y = y;
		this.nome=nome;
		imagemRect = new Rectangle2D.Double(x, y,
				getIconWidth(), getIconHeight());

	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.nome.equals(((IconeJogador)obj).getNome());
	}

	/**
	 * @return the imagemRect
	 */
	public Rectangle2D getImagemRect() {
		return imagemRect;
	}

	/**
	 * @param imagemRect the imagemRect to set
	 */
	public void setImagemRect(Rectangle2D imagemRect) {
		this.imagemRect = imagemRect;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
		imagemRect = new Rectangle2D.Double(x, y,
				getIconWidth(), getIconHeight());
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
		imagemRect = new Rectangle2D.Double(x, y,
				getIconWidth(), getIconHeight());
	}
	
	public void mudarPosicao(int x, int y) {
		this.x = x;
		this.y = y;
		imagemRect = new Rectangle2D.Double(x, y,
				getIconWidth(), getIconHeight());
	}
}
