package qaw.game.breakout.world;


import java.util.HashSet;
import java.util.Set;

import qaw.game.breakout.element.BoundedBall;
import qaw.game.breakout.type.Bounded;
import qaw.game.breakout.type.Breakable;
import qaw.game.breakout.type.Movable;

public class BoundedWorld extends MovableWorld {

    private boolean isOutOfHorizontal(Bounded bounded) {
        return bounded.getMinX() <= getBounds().getMinX() || bounded.getMaxX() >= getBounds().getMaxX();
    }

    private boolean isOutOfVertical(Bounded bounded) {
        return bounded.getMinY() <= getBounds().getMinY() || bounded.getMaxY() >= getBounds().getMaxY();
    }

    public boolean isOutOfBounds(Bounded bounded) {
        return isOutOfHorizontal(bounded) || isOutOfVertical(bounded);
    }

    public void bounce(Movable element) {
        if (isOutOfHorizontal(element)) {
            element.setDx(-element.getDx());
        }
        if (isOutOfVertical(element)) {
            element.setDy(-element.getDy());
        }
    }

    private void correct(Bounded bounded) {
        if (bounded.getMinX() < getBounds().getMinX()) {
            bounded.setX((int) getBounds().getMinX() + bounded.getWidth()/2);
        } else if (bounded.getMaxX() > getBounds().getMaxX()) {
            bounded.setX((int) getBounds().getMaxX() - bounded.getWidth()/2);
        }
        if (bounded.getMinY() < getBounds().getMinY()) {
            bounded.setY((int)getBounds().getMinY() + bounded.getWidth()/2);
        } else if (bounded.getMaxY() > getBounds().getMaxY()) {
            bounded.setY((int) getBounds().getMaxY() - bounded.getHeight()/2);
        }
    }

    public void move() {
        Set<Bounded> breaks = new HashSet<>();
        for (Bounded bounded : boundedList) {
            if (bounded instanceof Movable) {
                ((Movable)bounded).move();
            }

            if (bounded instanceof BoundedBall) {
                if (isOutOfBounds(bounded)) {
                    correct(bounded);
                    bounce((BoundedBall)bounded);
                }
                
                for (Bounded other : boundedList) {
                    if (((BoundedBall)bounded).isCrash(other)) {
                        ((BoundedBall)bounded).bounce(other);
                    }
                }
            }
            if (bounded instanceof Breakable) {
                for (Bounded other : boundedList) {
                    if (other instanceof BoundedBall) {
                        if (((BoundedBall)other).isCrash(bounded)) {
                            breaks.add(bounded);
                        }
                    }
                }
            }
        }
        for (Bounded breakd : breaks) {
            boundedList.remove(breakd);
        }

        moveCount++;
        repaint();
    }
}
