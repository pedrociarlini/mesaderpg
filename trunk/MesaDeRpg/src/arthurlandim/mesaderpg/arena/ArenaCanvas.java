package arthurlandim.mesaderpg.arena;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import pedrociarlini.mesaderpg.model.JogadorVO;

class ArenaCanvas extends JPanel implements ArenaInterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int x1, y1, x2, y2;

	List<IconeJogador> jogadores = new ArrayList<IconeJogador>();

	IconeJogador selectedShape;

	Cursor curCursor;

	
	/* (non-Javadoc)
	 * @see arthurlandim.mesaderpg.arena.ArenaInterface#adicionarJogador(pedrociarlini.mesaderpg.model.JogadorVO)
	 */
	public void adicionarJogador(JogadorVO jogador) {
		
		IconeJogador joga = null;
		try {
			joga = new IconeJogador(ImageIO.read(new File("imagens\\jogador.jpg")), 10, 10, jogador.getNome());
		} catch (IOException e) {
			e.printStackTrace();
		}
		jogadores.add(joga);
	}

	/* (non-Javadoc)
	 * @see arthurlandim.mesaderpg.arena.ArenaInterface#removerJogador(pedrociarlini.mesaderpg.model.JogadorVO)
	 */
	public void removerJogador(JogadorVO jogador) {

		IconeJogador joga = null;
		try {
			joga = new IconeJogador(ImageIO.read(new File("imagens\\jogador.jpg")), 10, 10, jogador.getNome());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		jogadores.remove(jogadores.indexOf(joga));
		
	}

	public ArenaCanvas() {
		setBackground(Color.white);
		addMouseListener(new MyMouseListener());
		addMouseMotionListener(new MyMouseMotionListener());
//		try {
//			imagem = new IconeJogador[] {
//					new IconeJogador(
//							ImageIO.read(new File("imagens\\jogador.jpg")), 0, 0),
//					new IconeJogador(
//							ImageIO.read(new File("imagens\\jogador.jpg")), 0, 30),
//					new IconeJogador(
//							ImageIO.read(new File("imagens\\jogador.jpg")), 50, 0) };
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		imagemRect = new Rectangle2D[imagem.size()];
	}

	public void paint(Graphics g) {
		super.paint(g);

		g.clearRect(0, 0, getWidth(), getHeight());

		Graphics2D g2D = (Graphics2D) g;
		for (IconeJogador jogador : jogadores) {
//			imagemRect.add(
//					new Rectangle2D.Double(jogador.x, jogador.y,
//							jogador.getIconWidth(), jogador.getIconHeight())	
//			);
			
			g2D.drawImage(jogador.getImage(), jogador.getX(), jogador.getY(), this);
			g2D.drawString(jogador.getNome(), jogador.getX(), jogador.getY()
					+ jogador.getIconHeight() + 8);
		}
//		for (int i = 0; i < imagem.length; i++) {
//			imagemRect[i] = new Rectangle2D.Double(imagem[i].x, imagem[i].y,
//					imagem[i].getIconWidth(), imagem[i].getIconHeight());
//			g2D.drawImage(imagem[i].getImage(), imagem[i].x, imagem[i].y, this);
//			g2D.drawString(imagem[i].getNome(), imagem[i].x + 2, imagem[i].y
//					+ imagem[i].getIconHeight() + 5);
//		}

		if (curCursor != null)
			setCursor(curCursor);
	}

	public int isOverImage(int x, int y) {

		if (jogadores != null) {
			for (IconeJogador imagemRectangle : jogadores) {
				if (imagemRectangle!=null && imagemRectangle.getImagemRect().contains(x, y)) {
					return jogadores.indexOf(imagemRectangle);
				}
			}
//			for (int i = 0; i < imagemRect.length; i++) {
//				if (imagemRect[i]!=null && imagemRect[i].contains(x, y)) {
//					return i;
//				}
//			}
		}
		return -1;
	}

	class MyMouseListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {

			int rect = -1;
			if ((rect = isOverImage(e.getX(), e.getY())) != -1) {
				selectedShape = jogadores.get(rect);//imagem[rect];
				if (jogadores.get(rect).getImagemRect() != null) {
//					imagemRect[rect] = imagemRect[rect].getBounds2D();
					jogadores.get(rect).setImagemRect(jogadores.get(rect).getImagemRect().getBounds2D());
				}
			} else {
				// boundingRec = null;
			}
			repaint();
			x1 = e.getX();
			y1 = e.getY();
		}

		public void mouseReleased(MouseEvent e) {
			int rect = -1;
			if ((rect = isOverImage(e.getX(), e.getY())) != -1) {
				selectedShape = jogadores.get(rect);

			}

			repaint();
		}

		public void mouseClicked(MouseEvent e) {
			int rect = -1;
			if ((rect = isOverImage(e.getX(), e.getY())) != -1) {
				selectedShape = jogadores.get(rect);
				// boundingRec = ellipse.getBounds2D();
				jogadores.get(rect).setImagemRect(jogadores.get(rect).getImagemRect().getBounds2D());
			} else {
				// if (boundingRec != null)
				// boundingRec = null;
			}
			repaint();
		}
	}

	class MyMouseMotionListener extends MouseMotionAdapter {
		public void mouseDragged(MouseEvent e) {
			int rect = -1;
			if ((rect = isOverImage(e.getX(), e.getY())) != -1) {
				// boundingRec = null;
				x2 = e.getX();
				y2 = e.getY();
//				jogadores.get(rect).setX(jogadores.get(rect).getX() + x2 - x1);
//				jogadores.get(rect).setY(jogadores.get(rect).getY() + y2 - y1);
				jogadores.get(rect).mudarPosicao(
						jogadores.get(rect).getX() + x2 - x1, 
						jogadores.get(rect).getY() + y2 - y1);
				x1 = x2;
				y1 = y2;
				selectedShape = jogadores.get(rect);
			}
			repaint();
		}

		public void mouseMoved(MouseEvent e) {
			if (jogadores.size() > 0) {
				if (isOverImage(e.getX(), e.getY()) != -1) {
					curCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
				} else {
					curCursor = Cursor.getDefaultCursor();
				}
			}

			repaint();
		}
	}

	@Override
	public void repaint() {
		// super.getGraphics().clearRect(0,0,getWidth(),getHeight());
		super.repaint();
	}

}
