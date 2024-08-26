package qaw.game.breakout.element;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import qaw.game.breakout.type.Bounded;
import qaw.game.breakout.type.Paintable;
import qaw.game.breakout.type.Breakable;

public class Brick implements Bounded, Paintable, Breakable {
    private final static Color DEFAULT_COLOR = Color.DARK_GRAY;
    private int x;
    private int y;
    private Rectangle bounds;
    private Color color;

    public Brick(int x, int y, int width, int height) {
        this(x, y, width, height, DEFAULT_COLOR);
    }

    public Brick(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.bounds = new Rectangle(x, y, width, height);
        this.color = color;
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
    public int getWidth() {
        return (int)bounds.getWidth();
    }

    @Override
    public int getHeight() {
        return (int) bounds.getHeight();
    }

    @Override
    public int getMinX() {
        return x - (getWidth()/2);
    }

    @Override
    public int getMinY() {
        return y - (getHeight()/2);
    }

    @Override
    public int getMaxX() {
        return x + (getWidth()/2);
    }

    @Override
    public int getMaxY() {
        return y + (getHeight()/2);
    }

    @Override
    public Rectangle getBounds() {
        return bounds;
    }

    @Override
    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(getMinX(), getMinY(), getWidth(), getHeight());
        g.setColor(color);
        g.fillRect(getMinX(), getMinY(), getWidth(), getHeight());
    }

}
