package entities;

import main.Game;
import utility.Constants;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Target extends Entity implements isShootable {
    private BufferedImage targetInUse;
    private BufferedImage targetIdle;
    private BufferedImage targetShot;

    private BufferedImage stickInUse;
    private BufferedImage stickIdle;
    private BufferedImage stickShot;

    private BufferedImage shotImg;
    private ArrayList<Point> shotsXY;

    private int shots;
    private int speed;
    private int tick;

    private int score;
    public Target(float x, float y, int speed) {
        super(x, y);
        targetInUse = targetIdle = Game.sprites.objects[Constants.objects.TARGETS[rand.nextInt(0, Constants.objects.TARGETS.length)]];
        targetShot = Game.sprites.objects[Constants.objects.TARGET_BACK_OUTLINE];

        int stickIndex = rand.nextInt(0, Constants.objects.STICKS.length);
        stickInUse = stickIdle = Game.sprites.objects[Constants.objects.STICKS[stickIndex]];
        stickShot = Game.sprites.objects[Constants.objects.STICKS_BROKEN[stickIndex]];

        shotImg = Game.sprites.objects[Constants.objects.SHOTS[rand.nextInt(0, Constants.objects.SHOTS.length)]];
        shotsXY = new ArrayList<>();
        shots = 0;

        tick = 0;
        this.speed = speed;

        score = 0;
    }

    public Target(float x, float y, int speed, String str) {
        super(x, y);
        targetInUse = targetIdle = Game.sprites.objects[Constants.objects.DUCKS[rand.nextInt(0, Constants.objects.DUCKS.length)]];
        targetShot = Game.sprites.objects[Constants.objects.DUCK_OUTLINE_BACK];

        int stickIndex = rand.nextInt(0, Constants.objects.STICKS.length);
        stickInUse = stickIdle = Game.sprites.objects[Constants.objects.STICKS[stickIndex]];
        stickShot = Game.sprites.objects[Constants.objects.STICKS_BROKEN[stickIndex]];

        shotImg = Game.sprites.objects[Constants.objects.SHOTS[rand.nextInt(0, Constants.objects.SHOTS.length)]];
        shotsXY = new ArrayList<>();
        shots = 0;



        tick = 0;
        this.speed = speed;

        score = 0;
    }

    public void update() {
        if (tick >= speed) {
            this.x+=1;
            tick = 0;

            shotsXY.replaceAll(point -> new Point((int) (point.getX() + 1), (int) point.getY()));
        }
        tick++;
    }

    /*
    * Shot?
    * Yes - MaxShotDone?
    *       Yes - pass Sound
    *       No - Create an img; Play shot sound;
    * No - Miss sound
    * */

    @Override
    public boolean shot(int px, int py) {
        if (targetInUse == null) return false;

        int h = targetInUse.getHeight();
        int w = targetInUse.getWidth();
        if (px >= this.x && py >= this.y && px <= (this.x + h) && py <= (this.y + w)){
            if (targetInUse == targetShot) {
                stickInUse = stickShot;
                targetInUse = null;
            } else if (shots < TOTAL_SHOTS) {
                Point p = new Point(px, py);
                shotsXY.add(p);
                shots++;
                score += updateScore(px, py);
                if (shots == TOTAL_SHOTS) {
                    targetInUse = targetShot;
                }
            }
            return true;
        }
        return false;
    }

    private int updateScore(int px, int py) {
        return 0;
    }

    public void render(Graphics g) {
        int stickXPos = (int)(this.x + targetIdle.getWidth()/2 - stickInUse.getWidth()/2);
        int stickYPos = (int)(this.y + targetIdle.getHeight()) - 10;
        if (targetInUse != null) {
            g.drawImage(stickInUse, stickXPos, stickYPos, null);
        } else {
            g.drawImage(stickInUse, stickXPos, stickYPos+15, null);
        }

        if (targetInUse != null) {
            g.drawImage(targetInUse, (int)this.x, (int)this.y, null);

        }
        // Shots

        if (targetInUse != null) {
            for (int i=0;i<shotsXY.size();i++) {
                g.drawImage(shotImg, (int) (shotsXY.get(i).getX() - shotImg.getWidth() / 2), (int) (shotsXY.get(i).getY() - shotImg.getHeight() / 2), null);
            }
        }
    }
}


