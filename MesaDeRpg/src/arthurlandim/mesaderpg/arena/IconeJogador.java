/**
 * 
 */
package arthurlandim.mesaderpg.arena;

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
	int x,y;

	public IconeJogador() {
		// TODO Auto-generated constructor stub
	}
	
	public IconeJogador(BufferedImage img, int x, int y) {
		// TODO Auto-generated constructor stub
		super(img);
		this.x = x;
		this.y = y;
	}
	
	
}
