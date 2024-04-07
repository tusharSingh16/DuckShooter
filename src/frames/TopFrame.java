package frames;

import main.Game;
import utility.Constants;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TopFrame {

    private  BufferedImage wood;
    private BufferedImage curtainTop;
    private BufferedImage curtainSide;
    private BufferedImage curtainRope;
    public TopFrame() {
        curtainTop = Game.sprites.stall[Constants.stall.CURTAIN_STRAIGHT];
        curtainSide = Game.sprites.stall[Constants.stall.CURTAIN];
        curtainRope = Game.sprites.stall[Constants.stall.CURTAIN_ROPE];
        wood = Game.sprites.stall[Constants.stall.BG_WOOD];
    }

    public void render(Graphics g) {
        for (int i=0;i<Game.GAME_WIDTH;i+=wood.getWidth()) {
            g.drawImage(wood, (int)i, (int)(Game.GAME_HEIGHT-wood.getHeight()/3), null);
        }
        g.drawImage(curtainSide, (int)0*Game.TILES_SIZE, (int)0*Game.TILES_SIZE, (int)(curtainSide.getWidth()*1.5),(int)(curtainSide.getHeight()*1.75),
                null);
        g.drawImage(curtainSide, (int)Game.GAME_WIDTH, (int)0*Game.TILES_SIZE, (int)(-1*curtainSide.getWidth()*1.5),(int)(curtainSide.getHeight()*1.75),
                null);
        for (int i=0;i<Game.GAME_WIDTH;i+=curtainTop.getWidth()-curtainTop.getWidth()/4) {
            g.drawImage(curtainTop, (int)i, (int)0*Game.TILES_SIZE, null);
        }
        g.drawImage(curtainRope,(int)0*Game.TILES_SIZE-5, (int)(Game.GAME_HEIGHT/2)-20, null);
        g.drawImage(curtainRope,(int)Game.GAME_WIDTH, (int)(Game.GAME_HEIGHT/2)-20, -1*curtainRope.getWidth(), curtainRope.getHeight(), null);
    }
}
