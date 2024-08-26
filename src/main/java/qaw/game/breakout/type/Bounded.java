package qaw.game.breakout.type;

import java.awt.Rectangle;

public interface Bounded {
    int getX();
    int getY();
    void setX(int x);
    void setY(int y);

    int getMinX();
    int getMinY();
    int getMaxX();
    int getMaxY();

    int getWidth();
    int getHeight();
    Rectangle getBounds();
    void setBounds(Rectangle bounds);
}
