package frames;

import main.Game;
import utility.Constants;

import java.awt.*;
import java.awt.image.BufferedImage;

public class IntermediateFrame1 {
    private BufferedImage[] grass;

    public IntermediateFrame1() {
        grass = new BufferedImage[2];
        grass[0] = Game.sprites.stall[Constants.stall.GRASS2];
        grass[1] = Game.sprites.stall[Constants.stall.GRASS1];

    }

    public void render(Graphics g) {
        for (int i = 0; i< Game.GAME_WIDTH; i+=(grass[0].getWidth()*2)) {
            int x = i;
            int y = Game.GAME_HEIGHT - (6*Game.TILES_SIZE)  - grass[0].getHeight();
            g.drawImage(grass[0], x, y, null);
            x += grass[0].getWidth();
            y = Game.GAME_HEIGHT - (6*Game.TILES_SIZE)  - grass[1].getHeight();
            g.drawImage(grass[1], x, y, null);
        }
    }
}
