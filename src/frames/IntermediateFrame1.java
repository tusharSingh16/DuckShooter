package frames; // Package declaration for the 'frames' package

import main.Game; // Importing the 'Game' class from the 'main' package
import utility.Constants; // Importing the 'Constants' class from the 'utility' package

import java.awt.*;
import java.awt.image.BufferedImage; // Importing the 'BufferedImage' class from the 'java.awt.image' package

// Declaring the public class 'IntermediateFrame1'
public class IntermediateFrame1 {
    private BufferedImage[] grass; // Declaring an array to store grass images

      // Constructor for the 'IntermediateFrame1' class
    public IntermediateFrame1() {
         // Initializing the array with grass images from the game sprites
        grass = new BufferedImage[2];
        grass[0] = Game.sprites.stall[Constants.stall.GRASS2];
        grass[1] = Game.sprites.stall[Constants.stall.GRASS1];

    }

    // Method to render the intermediate frame
    public void render(Graphics g) {
        // Looping to render grass tiles across the screen
        for (int i = 0; i< Game.GAME_WIDTH; i+=(grass[0].getWidth()*2)) {
            int x = i;
            // Calculating the y-coordinate for grass rendering
            int y = Game.GAME_HEIGHT - (6*Game.TILES_SIZE)  - grass[0].getHeight();

            // Rendering the first grass image
            g.drawImage(grass[0], x, y, null);

             // Rendering the second grass image
            x += grass[0].getWidth();
            y = Game.GAME_HEIGHT - (6*Game.TILES_SIZE)  - grass[1].getHeight();
            g.drawImage(grass[1], x, y, null);
        }
    }
}
