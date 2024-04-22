package frames; // Package declaration for the 'frames' package

import main.Game; // Importing the 'Game' class from the 'main' package
import utility.Constants;

import java.awt.*;
import java.awt.image.BufferedImage; // Importing the 'BufferedImage' class from the 'java.awt.image' package

// Declaring the public class 'TopFrame'
public class TopFrame {

     // Declaring private instance variables for different images
    private  BufferedImage wood;
    private BufferedImage curtainTop;
    private BufferedImage curtainSide;
    private BufferedImage curtainRope;

    // Constructor for the 'TopFrame' class
    public TopFrame() {
        // Initializing instance variables with images from the game sprites
        curtainTop = Game.sprites.stall[Constants.stall.CURTAIN_STRAIGHT];
        curtainSide = Game.sprites.stall[Constants.stall.CURTAIN];
        curtainRope = Game.sprites.stall[Constants.stall.CURTAIN_ROPE];
        wood = Game.sprites.stall[Constants.stall.BG_WOOD];
    }

    // Method to render the top frame
    public void render(Graphics g) {
        // Rendering the wooden background
        for (int i=0;i<Game.GAME_WIDTH;i+=wood.getWidth()) {
            g.drawImage(wood, (int)i, (int)(Game.GAME_HEIGHT-wood.getHeight()/3), null);
        }

        // Rendering the side curtains
        g.drawImage(curtainSide, (int)0*Game.TILES_SIZE, (int)0*Game.TILES_SIZE, (int)(curtainSide.getWidth()*1.5),(int)(curtainSide.getHeight()*1.75),
                null);
        g.drawImage(curtainSide, (int)Game.GAME_WIDTH, (int)0*Game.TILES_SIZE, (int)(-1*curtainSide.getWidth()*1.5),(int)(curtainSide.getHeight()*1.75),
                null);

        // Rendering the top curtain
        for (int i=0;i<Game.GAME_WIDTH;i+=curtainTop.getWidth()-curtainTop.getWidth()/4) {
            g.drawImage(curtainTop, (int)i, (int)0*Game.TILES_SIZE, null);
        }

        // Rendering the curtain ropes
        g.drawImage(curtainRope,(int)0*Game.TILES_SIZE-5, (int)(Game.GAME_HEIGHT/2)-20, null);
        g.drawImage(curtainRope,(int)Game.GAME_WIDTH, (int)(Game.GAME_HEIGHT/2)-20, -1*curtainRope.getWidth(), curtainRope.getHeight(), null);
    }
}
