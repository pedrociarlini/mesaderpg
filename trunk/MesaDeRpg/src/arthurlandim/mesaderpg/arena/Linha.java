package arthurlandim.mesaderpg.arena;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Linha extends Line2D {

    private IconeJogador jogador1;

    private IconeJogador jogador2;

    private Rectangle2D rect;

    public Linha(IconeJogador jogador1, IconeJogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }

    @Override
    public Point2D getP1() {
        return jogador1.getPoint2D();
    }

    @Override
    public Point2D getP2() {
        // TODO Auto-generated method stub
        return jogador2.getPoint2D();
    }

    @Override
    public double getX1() {
        return jogador1.getImagemRect().getCenterX();
    }

    @Override
    public double getX2() {
        return jogador2.getImagemRect().getCenterX();
    }

    @Override
    public double getY1() {
        return jogador1.getImagemRect().getCenterY();
    }

    @Override
    public double getY2() {
        return jogador2.getImagemRect().getCenterY();
    }

    @Override
    public void setLine(double X1, double Y1, double X2, double Y2) {
    }

    public Rectangle2D getBounds2D() {
        rect.setRect(jogador1.getImagemRect().getCenterX(), jogador1
                .getImagemRect().getCenterY(), jogador2.getImagemRect()
                .getCenterX()
                - jogador1.getImagemRect().getCenterX(), jogador2
                .getImagemRect().getCenterX()
                - jogador1.getImagemRect().getCenterX());
        return rect;
    }
}
