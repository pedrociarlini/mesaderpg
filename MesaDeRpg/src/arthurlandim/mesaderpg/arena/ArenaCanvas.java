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
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pedrociarlini.mesaderpg.model.JogadorVO;

class ArenaCanvas extends JPanel implements ArenaInterface {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    int x1, y1, x2, y2;

    Map<String, IconeJogador> jogadores;

    IconeJogador selectedShape;

    Cursor curCursor;

    private JLabel label;

    private boolean ligandoJogadores;

    private IconeJogador jogador1;

    private List<Linha> linhas;

    public ArenaCanvas() {
    	jogadores = Collections.synchronizedMap(jogadores);
    	linhas = Collections.synchronizedList(linhas);
        setBackground(Color.white);
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseMotionListener());
    }

    /*
     * (non-Javadoc)
     * 
     * @see arthurlandim.mesaderpg.arena.ArenaInterface#adicionarJogador(pedrociarlini.mesaderpg.model.JogadorVO)
     */
    public void adicionarJogador(JogadorVO jogador) {
        IconeJogador iconJogador = null;
        try {
            iconJogador = new IconeJogador(ImageIO.read(new File(
                    "imagens\\jogador.jpg")), 10, 10, jogador.getNome());
        } catch (IOException e) {
            e.printStackTrace();
        }
        jogadores.put(iconJogador.getNome(), iconJogador);
        repaint();
    }

    /*
     * (non-Javadoc)
     * 
     * @see arthurlandim.mesaderpg.arena.ArenaInterface#removerJogador(pedrociarlini.mesaderpg.model.JogadorVO)
     */
    public void removerJogador(JogadorVO jogador) {
        jogadores.remove(jogador.getNome());
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.clearRect(0, 0, getWidth(), getHeight());

        Graphics2D g2D = (Graphics2D) g;
        for (IconeJogador jogador : jogadores.values()) {
            g2D.drawImage(jogador.getImage(), jogador.getX(), jogador.getY(),
                    this);
            g2D.drawString(jogador.getNome(), jogador.getX(), jogador.getY()
                    + jogador.getIconHeight() + 30);
        }
        for (Linha linha : linhas) {
            g2D.draw(linha);
        }
        if (curCursor != null) setCursor(curCursor);
    }

    public boolean isOverImage(int x, int y) {
        if (getImageUnderPosition(x, y) == null)
            return false;
        else
            return true;
    }

    private IconeJogador getImageUnderPosition(int x, int y) {
        if (jogadores != null) {
            for (IconeJogador imagemRectangle : jogadores.values()) {
                if (imagemRectangle != null
                        && imagemRectangle.getImagemRect().contains(x, y)) { return imagemRectangle; }
            }
        }
        return null;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public void setLigandoJogadores(boolean b) {
        ligandoJogadores = b;
    }

    private void marcarJogador(IconeJogador jogadorSelecionado) {
        if(jogador1 == null) {
            jogador1 = jogadorSelecionado;
        }
        else {
            linhas.add(new Linha(jogador1, selectedShape));
            jogador1 = null;
        }
    }

    class MyMouseListener extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            selectedShape = getImageUnderPosition(e.getX(), e.getY());
            if (selectedShape != null) {
                if (selectedShape.getImagemRect() != null) {
                    selectedShape.setImagemRect(selectedShape.getImagemRect()
                            .getBounds2D());
                }
                repaint();
            }
            x1 = e.getX();
            y1 = e.getY();
        }

        public void mouseReleased(MouseEvent e) {
            if (selectedShape != null) {
                selectedShape = null;
                repaint();
            }
        }

        public void mouseClicked(MouseEvent e) {
            selectedShape = getImageUnderPosition(e.getX(), e.getY());
            if (selectedShape != null) {
                if (ligandoJogadores) {
                    marcarJogador(selectedShape);
                }
                // TODO fazer o icone parecer marcado
                repaint();
            }
        }
    }

    class MyMouseMotionListener extends MouseMotionAdapter {

        public void mouseDragged(MouseEvent e) {
            label.setText(e.getX() + ", " + e.getY());
            if (selectedShape != null) {
                // boundingRec = null;
                x2 = e.getX();
                y2 = e.getY();
                selectedShape.setPosicao(selectedShape.getX() + x2 - x1,
                        selectedShape.getY() + y2 - y1);
                x1 = x2;
                y1 = y2;
                repaint();
            }
        }

        public void mouseMoved(MouseEvent e) {
            label.setText(e.getX() + ", " + e.getY());
            if (jogadores.size() > 0) {
                if (isOverImage(e.getX(), e.getY())) {
                    curCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
                } else {
                    curCursor = Cursor.getDefaultCursor();
                }
            }
            repaint();
        }
    }
}
