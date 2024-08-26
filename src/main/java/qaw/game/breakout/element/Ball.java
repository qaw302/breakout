package qaw.game.breakout.element;

import java.awt.Rectangle;

import qaw.game.breakout.type.Bounded;

public class Ball implements Bounded{
    private int x;
    private int y;
    private int radius;
    private Rectangle bounds;

    public Ball(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        bounds = new Rectangle(x-radius, y-radius, radius*2, radius*2);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getMinX() {
        return x - radius;
    }

    @Override
    public int getMinY() {
        return y - radius;
    }

    @Override
    public int getMaxX() {
        return x + radius;
    }

    @Override
    public int getMaxY() {
        return y + radius;
    }

    @Override
    public int getWidth() {
        return radius*2;
    }

    @Override
    public int getHeight() {
        return radius*2;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getMinX(), getMinY(), getWidth(), getHeight());
    }

    @Override
    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }
    
}
