package entities; // Package declaration for the 'entities' package

import main.Game;
import utility.Constants;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

// Declaring the 'Target' class, which extends 'Entity' and implements 'isShootable' interface
public class Target extends Entity implements isShootable {
    // Declaring variables for target images
    private BufferedImage targetInUse;
    private BufferedImage targetIdle;
    private BufferedImage targetShot;

    // Declaring variables for stick images
    private BufferedImage stickInUse;
    private BufferedImage stickIdle;
    private BufferedImage stickShot;

    // Declaring variables for shot images and shot positions
    private BufferedImage shotImg;
    private ArrayList<Point> shotsXY;

    // Declaring variables for shots, speed, and tick
    private int shots;
    private int speed;
    private int tick;

     // Declaring a variable for score
    private int score;

    // Constructor for the 'Target' class
    public Target(float x, float y, int speed) {
        super(x, y); // Calling the superclass constructor 'Entity'

        // Initializing target images
        targetInUse = targetIdle = Game.sprites.objects[Constants.objects.TARGETS[rand.nextInt(0, Constants.objects.TARGETS.length)]];
        targetShot = Game.sprites.objects[Constants.objects.TARGET_BACK_OUTLINE];

        // Selecting stick images randomly
        int stickIndex = rand.nextInt(0, Constants.objects.STICKS.length);
        stickInUse = stickIdle = Game.sprites.objects[Constants.objects.STICKS[stickIndex]];
        stickShot = Game.sprites.objects[Constants.objects.STICKS_BROKEN[stickIndex]];

         // Selecting shot image randomly and initializing shot positions
        shotImg = Game.sprites.objects[Constants.objects.SHOTS[rand.nextInt(0, Constants.objects.SHOTS.length)]];
        shotsXY = new ArrayList<>();
        shots = 0;

        tick = 0;
        this.speed = speed;

        score = 0;
    }

    // Overloaded constructor for ducks
    public Target(float x, float y, int speed, String str) {
        super(x, y); // Calling the superclass constructor 'Entity'

        // Initializing target images for ducks
        targetInUse = targetIdle = Game.sprites.objects[Constants.objects.DUCKS[rand.nextInt(0, Constants.objects.DUCKS.length)]];
        targetShot = Game.sprites.objects[Constants.objects.DUCK_OUTLINE_BACK];

        // Selecting stick images randomly for ducks
        int stickIndex = rand.nextInt(0, Constants.objects.STICKS.length);
        stickInUse = stickIdle = Game.sprites.objects[Constants.objects.STICKS[stickIndex]];
        stickShot = Game.sprites.objects[Constants.objects.STICKS_BROKEN[stickIndex]];

        // Selecting shot image randomly and initializing shot positions for ducks
        shotImg = Game.sprites.objects[Constants.objects.SHOTS[rand.nextInt(0, Constants.objects.SHOTS.length)]];
        shotsXY = new ArrayList<>();
        shots = 0;



        tick = 0;
        this.speed = speed;

        score = 0;
    }

    // Method to update the target's position
    public void update() {
        // If tick reaches the speed value
        if (tick >= speed) {
            this.x+=1;// Incrementing the x-coordinate
            tick = 0; // Resetting tick

            // Updating shot positions
            shotsXY.replaceAll(point -> new Point((int) (point.getX() + 1), (int) point.getY()));
        }
        tick++;
    }

    /*
    * Shot?
    * Yes - MaxShotDone?
    *       Yes - pass Sound
    *       No - Create an img; Play shot sound;
    * No - Miss sound
    * */

    @Override
    // Method to handle shot on the target
    public boolean shot(int px, int py) {
        if (targetInUse == null) return false; // If the target is null, return false

        int h = targetInUse.getHeight(); // Getting the height of the target
        int w = targetInUse.getWidth();  // Getting the width of the target

         // Checking if the shot coordinates are within the target's boundaries
        if (px >= this.x && py >= this.y && px <= (this.x + h) && py <= (this.y + w)){
            // If the target is already shot
            if (targetInUse == targetShot) {
                stickInUse = stickShot; // Change the stick image to broken
                targetInUse = null; // Set the target image to null
            } 
            // If shots are less than the total allowed shots
            else if (shots < TOTAL_SHOTS) {
                Point p = new Point(px, py); // Create a new point for shot coordinates
                shotsXY.add(p); // Add the point to the list of shot positions
                shots++; // Increment the shots counter
                score += updateScore(px, py); // Update the score based on shot position

                // If maximum shots are reached
                if (shots == TOTAL_SHOTS) {
                    targetInUse = targetShot; // Set the target image to shot outline
                }
            }
            return true; // Return true indicating the target is shot
        }
        return false; // Return false indicating the target is not shot
    }

     // Method to update the score based on shot position
    private int updateScore(int px, int py) {
        return 0;
    }

    // Method to render the target and shots
    public void render(Graphics g) {
         // Calculate stick position
        int stickXPos = (int)(this.x + targetIdle.getWidth()/2 - stickInUse.getWidth()/2);
        int stickYPos = (int)(this.y + targetIdle.getHeight()) - 10;

        // Render stick image
        if (targetInUse != null) {
            g.drawImage(stickInUse, stickXPos, stickYPos, null);
        } else {
            g.drawImage(stickInUse, stickXPos, stickYPos+15, null);
        }

        // Render target image
        if (targetInUse != null) {
            g.drawImage(targetInUse, (int)this.x, (int)this.y, null);

        }

        // Render shots
        if (targetInUse != null) {
            for (int i=0;i<shotsXY.size();i++) {
                g.drawImage(shotImg, (int) (shotsXY.get(i).getX() - shotImg.getWidth() / 2), (int) (shotsXY.get(i).getY() - shotImg.getHeight() / 2), null);
            }
        }
    }
}


