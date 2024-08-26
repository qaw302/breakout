package qaw.game.breakout.world;

import java.util.List;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import qaw.game.breakout.type.Bounded;
import qaw.game.breakout.type.Paintable;

public class World extends JPanel {
    protected List<Bounded> boundedList = new ArrayList<>();
    protected int maxMoveCount; 
    protected int moveCount;

    public int getCount() {
        return boundedList.size();
    } 

    public void add(Bounded bounded) {
        boundedList.add(bounded);
    }

    public Bounded get(int index) {
        return boundedList.get(index);
    }

    public int getMaxMoveCount() {
        return maxMoveCount;
    }

    public void setMaxMoveCount(int max) {
        this.maxMoveCount = max;
    }

    public void reset() {
        moveCount = 0;
    }
    
    public void paint(Graphics g) {
        for (Bounded bounded : boundedList) {
            if (bounded instanceof Paintable) {
                ((Paintable)bounded).paint(g);
            }
        }
    }
}
