package levels;

//import entities.Duck;
import entities.Target;
import main.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class DuckTopManager { // Declaring the public class 'DuckTopManager'
    private Level curLevel;
    private Random rand;
    private ArrayList<Target> ducks;

    private float yPos;

    private int tick;
    private int spanned;
    private boolean isDestroyed;

     // Constructor for the 'DuckTopManager' class, taking a 'Level' parameter
    public DuckTopManager(Level curLevel) {
        isDestroyed = false;

        this.curLevel = curLevel;
        rand = new Random();
        ducks = new ArrayList<>(); // Initializing the 'ducks' instance variable with a new ArrayList

        yPos = Game.TILES_SIZE * 11;

        spanned = 0; // Initializing 'spanned' to 0
        tick = 0; // Initializing 'tick' to 0
    }

      // Method to update the state of the 'DuckTopManager'
    public void update() {

        // If statement to control the spawning of new ducks based on the tick count
        if (tick == 0) {
            tick = rand.nextInt(curLevel.spanSpeedMin, curLevel.spanSpeedMax); // Generating a random tick count
            // Checking if the total number of spawned ducks is less than the maximum allowed
            if (spanned < curLevel.totalSpan) {
                int xPos = rand.nextInt(-800, -100); // Generating a random x position for the new duck

                // Creating a new duck with random attributes and adding it to the ducks list
                Target t = new Target(xPos, yPos, rand.nextInt(curLevel.speedMin, curLevel.speedMax), "Duck");
                ducks.add(t);

                spanned++; // Incrementing the count of spawned ducks
            }
        } else {
            tick--; // Decrementing the tick count if it's not 0
        }

         // Looping through all ducks and updating their state
        for (int i=0;i<ducks.size();i++) {
            ducks.get(i).update();
        }

        // Checking if all ducks have been spawned and there are no ducks left
        for (int i=0;i<ducks.size();i++) {
            if (ducks.get(i).getX() >= Game.GAME_WIDTH)
                ducks.remove(ducks.get(i));
        }

        // Checking if all ducks have been spawned and there are no ducks left
        if (spanned == curLevel.totalSpan && ducks.isEmpty()) {
            isDestroyed = true; // Setting 'isDestroyed' to true
        }
    }

    // Method to render all ducks on the screen
    public void render(Graphics g) {
        for (int i=0;i<ducks.size();i++) {
            ducks.get(i).render(g);
        }
    }

     // Method to handle a shot fired at the ducks
    public boolean handleShot(int x, int y) {
        boolean flag = false; // Initializing a flag variable to false

        // Looping through all ducks to check if any of them have been hit by the shot
        for (int i=0;i<ducks.size();i++) {
            if (ducks.get(i).shot(x, y))
                flag = true;  // Setting the flag to true if a duck has been hit
        }
        return flag; // Returning the flag indicating if any duck was hit
    }

    // Method to check if all ducks have been destroyed
    public boolean isDestroyed() {
        return isDestroyed; // Returning the value of 'isDestroyed'
    }
}
