package levels;

//import entities.Duck;
import entities.Target;
import main.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class DuckBottomManager {
    private Level curLevel;
    private Random rand;
    private ArrayList<Target> ducks;
    private float yPos;

    private int tick;
    private int spanned;


    private boolean isDestroyed;
    public DuckBottomManager(Level curLevel) {
        isDestroyed = false;
        this.curLevel = curLevel;
        rand = new Random();
        ducks = new ArrayList<>();

        yPos = Game.TILES_SIZE*14;

        spanned = 0;
        tick = 0;
    }

    public void update() {

        if (tick == 0) {
            tick = rand.nextInt(curLevel.spanSpeedMin, curLevel.spanSpeedMax);
            if (spanned < curLevel.totalSpan) {
                int xPos = rand.nextInt(-300, -100);
                Target t = new Target(xPos, yPos, rand.nextInt(curLevel.speedMin, curLevel.speedMax), "duck");
                ducks.add(t);
                spanned++;
            }
        } else {
            tick--;
        }

        for (int i=0;i<ducks.size();i++) {
            ducks.get(i).update();
        }

        for (int i=0;i<ducks.size();i++) {
            if (ducks.get(i).getX() >= Game.GAME_WIDTH)
                ducks.remove(ducks.get(i));
        }
        if (spanned == curLevel.totalSpan && ducks.isEmpty()) {
            isDestroyed = true;
        }
    }

    public void render(Graphics g) {
        for (int i=0;i<ducks.size();i++) {
            ducks.get(i).render(g);
        }
    }

    public boolean handleShot(int x, int y) {
        boolean flag = false;
        for (int i=0;i<ducks.size();i++) {
            if (ducks.get(i).shot(x, y) == true)
                flag = true;
        }
        return flag;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }
}
