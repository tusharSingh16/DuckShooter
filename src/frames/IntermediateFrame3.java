package frames;

import main.Game;
import utility.Constants;

import java.awt.*;
import java.awt.image.BufferedImage;

public class IntermediateFrame3 {
    BufferedImage[] water;

    private int offsetForAnimation;
    private int speed;
    public IntermediateFrame3() {
        offsetForAnimation = 0;
        speed = 2;
        water = new BufferedImage[2];
        water[0] = Game.sprites.stall[Constants.stall.WATER1];
        water[1] = Game.sprites.stall[Constants.stall.WATER2];
    }

    public void render(Graphics g) {
        if (speed-- == 0) {
            offsetForAnimation += 1;
            speed = 2;
        }
        for (int i = -water[0].getWidth()*2; i< Game.GAME_WIDTH+water[0].getWidth(); i+=(water[0].getWidth()*2)) {
            int x = i;
            int y = Game.GAME_HEIGHT - (6*Game.TILES_SIZE);
            g.drawImage(water[0], x+offsetForAnimation, y, null);
            x += water[0].getWidth();
            g.drawImage(water[1], x+offsetForAnimation, y, null);
        }
        if (offsetForAnimation >= (water[0].getWidth()*2)) {
            offsetForAnimation = 0;
        }
    }
}
