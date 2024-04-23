package entities;

import java.awt.*;
import java.util.Random;

// Base class for every moving object in game
public abstract class Entity {
     // Declaring variables for x and y coordinates, and a random number generator
    protected float x, y;
    Random rand;
    protected int TOTAL_SHOTS; // Total number of shots allowed

    // Constructor for the 'Entity' class
    public Entity(float x, float y) {
        this.x = x; // Initializing the x-coordinate
        this.y = y; // Initializing the y-coordinate

        rand = new Random(); // Initializing the random number generator
        TOTAL_SHOTS = 3; // Setting the total number of shots allowed
    }

    abstract public void update();
    abstract public void render(Graphics g);

    // Getter method for the x-coordinate
    public float getX() {
        return x;
    }
}
