package qaw.game.breakout.element;

import java.awt.Color;
import java.awt.Graphics;

import qaw.game.breakout.type.Paintable;

public class PaintableBall extends Ball implements Paintable {
    private final static Color DEFAULT_COLOR = Color.DARK_GRAY;
    private Color color;

    public PaintableBall(int x, int y, int radius) {
        this(x, y, radius, DEFAULT_COLOR);
    }

    public PaintableBall(int x, int y, int radius, Color color) {
        super(x, y, radius);
        this.color = color;
    }

    @Override
    public void paint(Graphics g) {
        // g.setColor(Color.BLACK);
        // g.drawRect(getMinX(), getMinY(), getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawOval(getMinX(), getMinY(), getWidth(), getHeight());
        g.setColor(color);
        g.fillOval(getMinX(), getMinY(), getWidth(), getHeight());
    }
    
}
