package levels;

import entities.Target;
import main.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class TargetManager {
    private Level curLevel;
    private Random rand;
    private ArrayList<Target> targets;

    private float yPos;

    private int tick;
    private int spanned;

    private boolean isDestroyed;
    public TargetManager(Level curLevel) {
        isDestroyed = false;

        this.curLevel = curLevel;
        rand = new Random();
        targets = new ArrayList<>();

        yPos = Game.TILES_SIZE*6;

        spanned = 0;
        tick = 0;
    }

    public void update() {

        if (tick == 0) {
            tick = rand.nextInt(curLevel.spanSpeedMin, curLevel.spanSpeedMax);
            if (spanned < curLevel.totalSpan) {
                int xPos = rand.nextInt(-300, -100);
                Target t = new Target(xPos, yPos, rand.nextInt(curLevel.speedMin, curLevel.speedMax));
                targets.add(t);
                spanned++;
            }
        } else {
            tick--;
        }

        for (Target target : targets) {
            target.update();
        }

        for (int i=0;i<targets.size();i++) {
            if (targets.get(i).getX() >= Game.GAME_WIDTH)
                targets.remove(targets.get(i));
        }
        if (spanned == curLevel.totalSpan && targets.isEmpty()) {
            isDestroyed = true;
        }
    }

    public void render(Graphics g) {
         for (Target target : targets) {
            target.render(g);
        }
    }

    public boolean handleShot(int x, int y) {
        boolean flag = false;
        for (int i=0;i<targets.size();i++) {
            if (targets.get(i).shot(x, y) == true)
                flag = true;
        }
        return flag;
    }
    public boolean isDestroyed() {
        return isDestroyed;
    }
}
