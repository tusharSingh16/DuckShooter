/*

NOT USING ANYMORE

package entities;

import main.Game;
import utility.Constants;
import utility.LoadSave;

import java.awt.*;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Duck extends Entity implements isShootable {
    private BufferedImage duckIdle;
    private BufferedImage duckShot;
    private BufferedImage duckInUse;

    private BufferedImage stickInUse;
    private BufferedImage stickIdle;
    private BufferedImage stickShot;

    private BufferedImage shotImg;
    private ArrayList<Point> shotsXY;

    private String shotHit;

    private int shots;

    private int speed;
    private int tick;
    private int score;
    public Duck(float x, float y, int speed) {
        super(x, y);
        duckInUse = duckIdle = Game.sprites.objects[Constants.objects.DUCKS[rand.nextInt(0, Constants.objects.DUCKS.length)]];
        duckShot = Game.sprites.objects[Constants.objects.DUCK_OUTLINE_BACK];

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

    @Override
    public boolean shot(int px, int py) {
        if (duckInUse == null) return false;

        int h = duckInUse.getHeight();
        int w = duckInUse.getWidth();
        if (px >= this.x && py >= this.y && px <= (this.x + h) && py <= (this.y + w)){
            if (duckInUse == duckShot) {
                stickInUse = stickShot;
                duckInUse = null;
            } else if (shots < TOTAL_SHOTS) {
                Point p = new Point(px, py);
                shotsXY.add(p);
                shots++;
                score += updateScore(px, py);
                if (shots == TOTAL_SHOTS)
                    duckInUse = duckShot;
            }
            return true;
        }
        return false;
    }

    private int updateScore(int x, int y) {
        // update
        return 0;
    }

    public void render(Graphics g) {
        int stickXPos = (int)(this.x + duckIdle.getWidth()/2 - stickInUse.getWidth()/2);
        int stickYPos = (int)(this.y + duckIdle.getHeight()) - 10;
        if (duckInUse != null) {
            g.drawImage(stickInUse, stickXPos, stickYPos, null);
        } else {
            g.drawImage(stickInUse, stickXPos, stickYPos+15, null);
        }


        if (duckInUse != null)
            g.drawImage(duckInUse, (int)this.x, (int)this.y, null);

        if (duckInUse != null) {
            for (int i=0;i<shotsXY.size();i++) {
                g.drawImage(shotImg, (int) (shotsXY.get(i).getX() - shotImg.getWidth() / 2), (int) (shotsXY.get(i).getY() - shotImg.getHeight() / 2), null);
            }
        }
    }
}

 */
