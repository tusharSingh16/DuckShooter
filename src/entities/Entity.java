package entities;

import main.Game;
import utility.Sprites;

import java.util.Random;

// Base class for every moving object in game
public abstract class Entity {
    protected float x, y;
    Random rand;
    protected int TOTAL_SHOTS;
    public Entity(float x, float y) {
        this.x = x;
        this.y = y;

        rand = new Random();
        TOTAL_SHOTS = 3;
    }

    public float getX() {
        return x;
    }
}
