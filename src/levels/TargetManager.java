package levels;

import entities.Target;
import main.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class TargetManager { // Declaring the public class 'TargetManager'
    private Level curLevel; // Declaring a private instance variable 'curLevel' of type 'Level'
    private Random rand; // Declaring a private instance variable 'rand' of type 'Random'
    public ArrayList<Target> targets; // Declaring a private instance variable 'targets' of type 'ArrayList<Target>'


    private float yPos;// Declaring a private instance variable 'yPos' of type 'float'
    public final static int Y_POS_TOP = Game.TILES_SIZE*6;
    public final static int Y_POS_MIDDLE = Game.TILES_SIZE*11;
    public final static int Y_POS_BOTTOM  = Game.TILES_SIZE*14;


    private int tick;// Declaring a private instance variable 'tick' of type 'int'
    private int spanned;// Declaring a private instance variable 'spanned' of type 'int'


    private boolean isDestroyed; // Declaring a private instance variable 'isDestroyed' of type 'boolean'

     // Constructor for the 'TargetManager' class, taking a 'Level' parameter
    public TargetManager(Level curLevel, int yPos) {
        isDestroyed = false;

        this.curLevel = curLevel;// Assigning the 'curLevel' parameter to the instance variable 'curLevel'
        this.yPos = yPos;

        rand = new Random(); // Initializing the 'rand' instance variable with a new instance of 'Random'
        targets = new ArrayList<>();  // Initializing the 'targets' instance variable with a new ArrayList

        yPos = Game.TILES_SIZE*6; // Assigning a value to the 'yPos' variable

        spanned = 0;// Initializing 'spanned' to 0
        tick = 0;// Initializing 'tick' to 0
    }

   // Method to update the state of the 'TargetManager'

    public void update() {
        // If statement to control the spawning of new targets based on the tick count
        if (tick == 0) {
            tick = rand.nextInt(curLevel.spanSpeedMin, curLevel.spanSpeedMax); // Generating a random tick count
             // Checking if the total number of spawned targets is less than the maximum allowed
            if (spanned < curLevel.totalSpan) {

                int xPos = rand.nextInt(-300, -100); // Generating a random x position for the new target

                // Creating a new target with random attributes and adding it to the targets list
                Target t = null;
                if (yPos == Y_POS_TOP) {
                    t = new Target(xPos, yPos, rand.nextInt(curLevel.speedMin, curLevel.speedMax));
                } else if (yPos == Y_POS_MIDDLE) {
                    t = new Target(xPos, yPos, rand.nextInt(curLevel.speedMin, curLevel.speedMax), "duck");
                } else if (yPos == Y_POS_BOTTOM) {
                    t = new Target(xPos, yPos, rand.nextInt(curLevel.speedMin, curLevel.speedMax), "duck");
                }
                if (t != null) {
                    targets.add(t);
                }

                spanned++; // Incrementing the count of spawned targets
            }
        } else {
            tick--; // Decrementing the tick count if it's not 0
        }
        
        // Looping through all targets and updating their state
        for (Target target : targets) {
            target.update();
        }
        
        // Looping through the targets list to remove targets that have moved off the screen
        for (int i=0;i<targets.size();i++) {
            if (targets.get(i).getX() >= Game.GAME_WIDTH)
                targets.remove(targets.get(i));
        }
        // Checking if all targets have been spawned and there are no targets left
        if (spanned == curLevel.totalSpan && targets.isEmpty()) {
            isDestroyed = true;
        }
    }
    
    // Method to render all targets on the screen
    public void render(Graphics g) {
         for (Target target : targets) {
            target.render(g);
        }
    }

    // Method to handle a shot fired at the targets
    public boolean handleShot(int x, int y) {
        boolean flag = false; // Initializing a flag variable to false

        // Looping through all targets to check if any of them have been hit by the shot
        for (int i=0;i<targets.size();i++) {
            if (targets.get(i).shot(x, y) == true)
                flag = true; // Setting the flag to true if a target has been hit
        }
        return flag; // Returning the flag indicating if any target was hit
    }
    
    // Method to check if all targets have been destroyed
    public boolean isDestroyed() {
        return isDestroyed;
    }
}
