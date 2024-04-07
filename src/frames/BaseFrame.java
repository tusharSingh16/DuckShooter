package frames;

import main.Game;
import utility.Constants;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class BaseFrame {
    private final int cloud1PosX;
    private final int cloud2PosX;
    private final int tree1PosX;
    private final int tree2PosX;
    BufferedImage wood;
    BufferedImage curtainTopBase;
    BufferedImage cloud1;
    BufferedImage cloud2;

    BufferedImage tree1;
    BufferedImage tree2;
    Random random;

    public BaseFrame() {
        random = new Random();
        cloud1PosX = random.nextInt( 100, Game.GAME_WIDTH/3);
        cloud2PosX = random.nextInt( Game.GAME_WIDTH/2, Game.GAME_WIDTH);
        tree1PosX = random.nextInt( 0, Game.GAME_WIDTH/4);
        tree2PosX = random.nextInt( Game.GAME_WIDTH/2+Game.GAME_WIDTH/3, Game.GAME_WIDTH);

        wood = Game.sprites.stall[Constants.stall.BG_WOOD];
        curtainTopBase = Game.sprites.stall[Constants.stall.CURTAIN_TOP];
        cloud1 = Game.sprites.stall[Constants.stall.CLOUD1];
        cloud2 = Game.sprites.stall[Constants.stall.CLOUD1];
        tree1 = Game.sprites.stall[Constants.stall.TREE_OAK];
        tree2 = Game.sprites.stall[Constants.stall.TREE_PINE];
    }

    public void render(Graphics g) {
        for (int i=0;i<Game.GAME_WIDTH;i+=wood.getWidth()) {
            for (int j=0;j<Game.GAME_HEIGHT;j+=wood.getHeight()) {
                g.drawImage(wood, (int)i, (int)j, null);
            }
        }

        g.drawImage(cloud1, (int)cloud1PosX, (int)3*Game.TILES_SIZE, null);
        g.drawImage(cloud2, (int)cloud2PosX, (int)3*Game.TILES_SIZE, null);

        g.drawImage(tree1, (int)tree1PosX, (int)5*Game.TILES_SIZE, null);
        g.drawImage(tree2, (int)tree2PosX, (int)5*Game.TILES_SIZE, null);

        for (int i=0;i<Game.GAME_WIDTH;i+=curtainTopBase.getWidth()-curtainTopBase.getWidth()/4) {
                g.drawImage(curtainTopBase, (int)i, (int)2*Game.TILES_SIZE, null);
        }
    }
}
