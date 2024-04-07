package entities;

import levels.LevelManager;
import main.Game;
import utility.Constants;

import java.awt.*;
import java.awt.image.BufferedImage;

// Player Class to hold metadata about main player.
public class Crosshair extends Entity{
    private BufferedImage crosshairInUse;
    private BufferedImage crosshairIdel;
    private BufferedImage crosshairShoot;
    private int tick;
    private int height;
    private int width;

    private LevelManager lvlManager;

    public Crosshair(float x, float y, LevelManager lvlManager) {
        super(x, y);
        tick = 0;
        this.lvlManager = lvlManager;
        crosshairIdel = Game.sprites.hud[Constants.Hud.CROSSHAIR_OUTLINE_LARGE];
        crosshairShoot = Game.sprites.hud[Constants.Hud.CROSSHAIR_OUTLINE_SMALL];
        crosshairInUse = crosshairIdel;
        this.width = crosshairInUse.getWidth();
        this.height = crosshairInUse.getHeight();
        loadAnimations();
    }

    private void loadAnimations() {
    }

    public void update() {
        cursorInUse();
    }

    public void updatePos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void updateClick() {
        tick = 20;
        lvlManager.handleShot((int)x, (int)y);
        crosshairInUse = crosshairShoot;
    }

    public void cursorInUse() {
        if (tick == 0) {
            crosshairInUse = crosshairIdel;
        } else {
            crosshairInUse = crosshairShoot;
            tick--;
        }
    }

    public void render(Graphics g) {
        this.width = crosshairInUse.getWidth();
        this.height = crosshairInUse.getHeight();
        g.drawImage(crosshairInUse, (int)x-(width/2), (int)y-(height/2), null);
    }
}
