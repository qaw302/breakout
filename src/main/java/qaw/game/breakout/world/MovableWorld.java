package qaw.game.breakout.world;

import qaw.game.breakout.type.Bounded;
import qaw.game.breakout.type.Movable;

public class MovableWorld extends World {
    private int sleepTime;

    public void move() {
        for (Bounded bounded : boundedList) {
            if (bounded instanceof Movable) {
                ((Movable)bounded).move();
            }
        }
        moveCount++;
        repaint();
    }

    public void setSleepTime(int time) {
        this.sleepTime = time;
    }

    public void run(){
        while (maxMoveCount == 0 || moveCount < maxMoveCount) {
            move();
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
    }
}
