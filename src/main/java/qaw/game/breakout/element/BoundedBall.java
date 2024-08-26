package qaw.game.breakout.element;

import java.awt.Color;
import java.awt.Rectangle;

import qaw.game.breakout.type.Bounded;

public class BoundedBall extends MovableBall {

    public BoundedBall(int x, int y, int radius) {
        super(x, y, radius);
    }

    public BoundedBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
    }


    public boolean isCrash(Bounded bounded) {
        if (this != bounded) {
            return bounded.getBounds().intersects(new Rectangle(getMinX(), getMinY(), getWidth(), getHeight()));
        } else {
            return false;
        }
    }

    private Rectangle getIntersection(Bounded bounded) {
        return bounded.getBounds().intersection(new Rectangle(getMinX(), getMinY(), getWidth(), getHeight()));
    }

    public void move() {
        super.move();
    }

    public void bounce(Bounded bounded) {
        Rectangle section = getIntersection(bounded);
        if ((section.getWidth() != getWidth() || section.getWidth() != bounded.getWidth()) && section.getWidth() < section.getHeight()) {
            setDx(-getDx());
        } else if ((section.getHeight() != getHeight() || section.getHeight() != bounded.getHeight()) && section.getWidth() > section.getHeight()) {
            setDy(-getDy());
        } else {
            setDx(-getDx());
            setDy(-getDy());
        }

    }
    
}
