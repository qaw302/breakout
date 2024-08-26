package qaw.game.breakout.type;

public interface Movable extends Bounded {
    int getDx();
    int getDy();
    void setDx(int dx);
    void setDy(int dy);
    void move();
}
