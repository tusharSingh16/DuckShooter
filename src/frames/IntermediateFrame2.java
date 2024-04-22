package frames; // Package declaration for the 'frames' package

import main.Game;
import utility.Constants; // Importing the 'Constants' class from the 'utility' package

import java.awt.*; // Importing the 'Graphics' class from the 'java.awt' package
import java.awt.image.BufferedImage; // Importing the 'BufferedImage' class from the 'java.awt.image' package

// Declaring the public class 'IntermediateFrame2'
public class IntermediateFrame2 {
    BufferedImage[] water; // Declaring an array to store water images

    private int offsetForAnimation; // Declaring a variable to store the offset for animation
    private int speed; // Declaring a variable to control animation speed

     // Constructor for the 'IntermediateFrame2' class
    public IntermediateFrame2() {
        offsetForAnimation = 0;
        speed = 2;

        // Initializing the array with water images from the game sprites
        water = new BufferedImage[2];
        water[0] = Game.sprites.stall[Constants.stall.WATER1];
        water[1] = Game.sprites.stall[Constants.stall.WATER2];
    }

    // Method to render the intermediate frame
    public void render(Graphics g) {
        // If statement to control animation speed
        if (speed-- == 0) {
            offsetForAnimation += 1; // Incrementing the offset for animation
            speed = 2; // Resetting the animation speed
        }

        // Looping to render water tiles across the screen
        for (int i = -water[0].getWidth()*2-water[0].getWidth()/2; i< Game.GAME_WIDTH+water[0].getWidth(); i+=(water[0].getWidth()*2)) {
            int x = i;
            int y = Game.GAME_HEIGHT - (9*Game.TILES_SIZE);

             // Rendering the first water image
            g.drawImage(water[0], x-offsetForAnimation, y, null);

            // Rendering the second water image
            x += water[0].getWidth();
            g.drawImage(water[1], x-offsetForAnimation, y, null);
        }

        // Resetting the offset for animation if it exceeds the width of a water tile
        if (offsetForAnimation >= (water[0].getWidth()*2)) {
            offsetForAnimation = 0;
        }
    }
}
