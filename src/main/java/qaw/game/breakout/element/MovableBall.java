package qaw.game.breakout.element;

import java.awt.Color;

import qaw.game.breakout.type.Movable;

public class MovableBall extends PaintableBall implements Movable {
    private int dx;
    private int dy;

    public MovableBall(int x, int y, int radius) {
        super(x, y, radius);
    }

    public MovableBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
    }

    @Override
    public int getDx() {
        return dx;
    }

    @Override
    public int getDy() {
        return dy;
    }

    @Override
    public void setDx(int dx) {
        this.dx = dx;
    }

    @Override
    public void setDy(int dy) {
        this.dy = dy;
    }

    @Override
    public void move() {
        System.out.printf("move (%d, %d) -> ", getX(), getY());
        moveTo(getX() + getDx(), getY() + getDy());
        System.out.printf("(%d, %d)\n", getX(), getY());
    }

    private void moveTo(int x, int y) {
        setX(x);
        setY(y);
    }
    
}
