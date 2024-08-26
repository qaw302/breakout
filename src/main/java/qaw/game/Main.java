package qaw.game;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import qaw.game.breakout.element.BoundedBall;
import qaw.game.breakout.element.Box;
import qaw.game.breakout.type.Bounded;
import qaw.game.breakout.type.Movable;
import qaw.game.breakout.world.BoundedWorld;

public class Main {
    final static int FRAME_WIDTH = 500;
    final static int FRAME_HEIGHT = 500;

    final static int BRICK_LINE = 4;
    final static int BRICK_COUNT_PER_FRAME_WIDTH = 10;
    final static int BRICK_WIDHT = FRAME_WIDTH / BRICK_COUNT_PER_FRAME_WIDTH;
    final static int BRICK_HEIGHT = 20;

    final static int MAX_MOVE_COUNT = 0;
    final static int SLEEP_TIME = 3;

    final static Color[] colors = new Color[] {
        Color.DARK_GRAY, Color.LIGHT_GRAY, Color.GREEN, Color.YELLOW, Color.PINK
    };

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        BoundedWorld world = new BoundedWorld();

        frame.add(world);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);

        Bounded powerBall = new BoundedBall(FRAME_WIDTH/2, FRAME_HEIGHT-60, 10 , Color.BLACK);
        ((Movable)powerBall).setDx(1);
        ((Movable)powerBall).setDy(-1);
        world.add(powerBall);

        Bounded paddle = new Box(FRAME_WIDTH/2, FRAME_HEIGHT-40, 60, 10);
        world.setPaddle(paddle);

        for (int line=0; line<BRICK_LINE; line++) {
            for (int x=0; x<BRICK_COUNT_PER_FRAME_WIDTH; x++) {
                Bounded brick = new Box(BRICK_WIDHT/2 + x*BRICK_WIDHT, BRICK_HEIGHT/2 +line*BRICK_HEIGHT , BRICK_WIDHT, BRICK_HEIGHT, colors[line%colors.length]);
                world.add(brick);
            }
        }

        frame.repaint();
        world.setSleepTime(SLEEP_TIME);
        world.setMaxMoveCount(MAX_MOVE_COUNT);
        world.run();
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}