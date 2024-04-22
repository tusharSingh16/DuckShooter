package frames; // Package declaration for the 'frames' package

import main.Game; // Importing the 'Game' class from the 'main' package
import utility.Constants; // Importing the 'Constants' class from the 'utility' package

import java.awt.*; // Importing the 'Graphics' class from the 'java.awt' package
import java.awt.image.BufferedImage; // Importing the 'BufferedImage' class from the 'java.awt.image' package
import java.util.Random; // Importing the 'Random' class from the 'java.util' package

// Declaring the public class 'BaseFrame'
public class BaseFrame {
     // Declaring constants for the positions of various elements
    private final int cloud1PosX;
    private final int cloud2PosX;
    private final int tree1PosX;
    private final int tree2PosX;

     // Declaring images for the base frame
    BufferedImage wood;
    BufferedImage curtainTopBase;
    BufferedImage cloud1;
    BufferedImage cloud2;

    BufferedImage tree1;
    BufferedImage tree2;

    // Declaring a Random object for generating random positions
    Random random;

    // Constructor for the 'BaseFrame' class
    public BaseFrame() {
        random = new Random(); // Initializing the Random object

        // Generating random positions for clouds and trees
        cloud1PosX = random.nextInt( 100, Game.GAME_WIDTH/3);
        cloud2PosX = random.nextInt( Game.GAME_WIDTH/2, Game.GAME_WIDTH);
        tree1PosX = random.nextInt( 0, Game.GAME_WIDTH/4);
        tree2PosX = random.nextInt( Game.GAME_WIDTH/2+Game.GAME_WIDTH/3, Game.GAME_WIDTH);

        // Initializing images with sprites from the game
        wood = Game.sprites.stall[Constants.stall.BG_WOOD];
        curtainTopBase = Game.sprites.stall[Constants.stall.CURTAIN_TOP];
        cloud1 = Game.sprites.stall[Constants.stall.CLOUD1];
        cloud2 = Game.sprites.stall[Constants.stall.CLOUD1];
        tree1 = Game.sprites.stall[Constants.stall.TREE_OAK];
        tree2 = Game.sprites.stall[Constants.stall.TREE_PINE];
    }

    // Method to render the base frame
    public void render(Graphics g) {
        // Rendering the wooden background
        for (int i=0;i<Game.GAME_WIDTH;i+=wood.getWidth()) {
            for (int j=0;j<Game.GAME_HEIGHT;j+=wood.getHeight()) {
                g.drawImage(wood, (int)i, (int)j, null);
            }
        }

        // Rendering clouds
        g.drawImage(cloud1, (int)cloud1PosX, (int)3*Game.TILES_SIZE, null);
        g.drawImage(cloud2, (int)cloud2PosX, (int)3*Game.TILES_SIZE, null);

        // Rendering trees
        g.drawImage(tree1, (int)tree1PosX, (int)5*Game.TILES_SIZE, null);
        g.drawImage(tree2, (int)tree2PosX, (int)5*Game.TILES_SIZE, null);

        // Rendering curtain top base
        for (int i=0;i<Game.GAME_WIDTH;i+=curtainTopBase.getWidth()-curtainTopBase.getWidth()/4) {
                g.drawImage(curtainTopBase, (int)i, (int)2*Game.TILES_SIZE, null);
        }
    }
}
