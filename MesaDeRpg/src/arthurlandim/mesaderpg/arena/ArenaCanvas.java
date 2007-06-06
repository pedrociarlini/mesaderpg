package arthurlandim.mesaderpg.arena;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class ArenaCanvas extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int x1, y1, x2, y2;

	IconeJogador[] imagem;

	Rectangle2D[] imagemRect;

	String[] jogadores;

	IconeJogador selectedShape;

	Cursor curCursor;

	public ArenaCanvas() {
		setBackground(Color.white);
		addMouseListener(new MyMouseListener());
		addMouseMotionListener(new MyMouseMotionListener());
		try {
			imagem = new IconeJogador[] {
					new IconeJogador(
							ImageIO.read(new File("imagens\\jogador.jpg")), 0, 0),
					new IconeJogador(
							ImageIO.read(new File("imagens\\jogador.jpg")), 0, 30),
					new IconeJogador(
							ImageIO.read(new File("imagens\\jogador.jpg")), 50, 0) };
		} catch (IOException e) {
			e.printStackTrace();
		}

		jogadores = new String[] { "jogador1", "jogador2", "jogador3" };
		imagemRect = new Rectangle2D[imagem.length];
	}

	public void paint(Graphics g) {
		super.paint(g);

		g.clearRect(0, 0, getWidth(), getHeight());

		Graphics2D g2D = (Graphics2D) g;
		for (int i = 0; i < imagem.length; i++) {
			imagemRect[i] = new Rectangle2D.Double(imagem[i].x, imagem[i].y,
					imagem[i].getIconWidth(), imagem[i].getIconHeight());
			g2D.drawImage(imagem[i].getImage(), imagem[i].x, imagem[i].y, this);
			g2D.drawString(jogadores[i], imagem[i].x + 2, imagem[i].y
					+ imagem[i].getIconHeight() + 5);
		}

		if (curCursor != null)
			setCursor(curCursor);
	}

	public int isOverImage(int x, int y) {

		if (imagemRect != null) {
			for (int i = 0; i < imagemRect.length; i++) {
				if (imagemRect[i]!=null && imagemRect[i].contains(x, y)) {
					return i;
				}
			}
		}
		return -1;
	}

	class MyMouseListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {

			int rect = -1;
			if ((rect = isOverImage(e.getX(), e.getY())) != -1) {
				selectedShape = imagem[rect];
				if (imagemRect[rect] != null)
					imagemRect[rect] = imagemRect[rect].getBounds2D();
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
				selectedShape = imagem[rect];

			}

			repaint();
		}

		public void mouseClicked(MouseEvent e) {
			int rect = -1;
			if ((rect = isOverImage(e.getX(), e.getY())) != -1) {
				selectedShape = imagem[rect];
				// boundingRec = ellipse.getBounds2D();

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
				selectedShape = imagem[rect];
				x2 = e.getX();
				y2 = e.getY();
				imagem[rect].x = imagem[rect].x + x2 - x1;
				imagem[rect].y = imagem[rect].y + y2 - y1;
				x1 = x2;
				y1 = y2;
			}
			repaint();
		}

		public void mouseMoved(MouseEvent e) {
			if (imagemRect != null) {
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
