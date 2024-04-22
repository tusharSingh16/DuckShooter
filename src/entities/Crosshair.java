package entities; // Package declaration for the 'entities' package

import levels.LevelManager;
import main.Game;
import utility.Constants;

import java.awt.*;
import java.awt.image.BufferedImage;

// Player Class to hold metadata about main player.
public class Crosshair extends Entity{

    // Declaring variables for crosshair images, tick, height, and width
    private BufferedImage crosshairInUse;
    private BufferedImage crosshairIdel;
    private BufferedImage crosshairShoot;
    private int tick;
    private int height;
    private int width;

    // Declaring a variable for the level manager
    private LevelManager lvlManager;

    // Constructor for the 'Crosshair' class
    public Crosshair(float x, float y, LevelManager lvlManager) {
        super(x, y);// Calling the superclass constructor 'Entity'

        tick = 0;
        this.lvlManager = lvlManager;
        crosshairIdel = Game.sprites.hud[Constants.Hud.CROSSHAIR_OUTLINE_LARGE]; // Setting the idle crosshair image
        crosshairShoot = Game.sprites.hud[Constants.Hud.CROSSHAIR_OUTLINE_SMALL]; // Setting the shooting crosshair image
        crosshairInUse = crosshairIdel; // Setting the initial crosshair image
        this.width = crosshairInUse.getWidth(); // Getting the width of the crosshair
        this.height = crosshairInUse.getHeight(); // Getting the height of the crosshair
    }

    // Method to update the crosshair
    public void update() {
        cursorInUse();  // Calling the method to determine which crosshair image to use

    }

    // Method to update the position of the crosshair
    public void updatePos(int x, int y) {
        this.x = x; // Updating the x-coordinate
        this.y = y; // Updating the y-coordinate
    }

    // Method to update the click action
    public void updateClick() {
        tick = 20;
        lvlManager.handleShot((int)x, (int)y); // Handling the shot with the level manager
        crosshairInUse = crosshairShoot; // Setting the crosshair image to shooting mode
    }

    // Method to determine which crosshair image to use
    public void cursorInUse() {
        if (tick == 0) {// If tick is 0
            crosshairInUse = crosshairIdel; // Set the crosshair to idle mode
        } else {
            crosshairInUse = crosshairShoot; // Set the crosshair to shooting mode
            tick--; // Decrement tick
        }
    }

    // Method to render the crosshair
    public void render(Graphics g) {
        this.width = crosshairInUse.getWidth(); // Getting the width of the crosshair
        this.height = crosshairInUse.getHeight(); // Getting the height of the crosshair

        // Rendering the crosshair at the appropriate position
        g.drawImage(crosshairInUse, (int)x-(width/2), (int)y-(height/2), null);
    }
}
