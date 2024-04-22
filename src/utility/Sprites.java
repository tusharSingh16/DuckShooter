package utility;

import java.awt.image.BufferedImage;

// Class to manage sprite loading
public class Sprites {

    // Arrays to hold loaded sprites for HUD, objects, and stalls
    public BufferedImage[] hud;
    public BufferedImage[] objects;
    public BufferedImage[] stall;

    // Constructor to load sprites
    public Sprites() {
        hud = LoadSave.LoadSprites(LoadSave.HUD); // Load HUD sprites
        objects = LoadSave.LoadSprites(LoadSave.OBJECTS); // Load object sprites
        stall = LoadSave.LoadSprites(LoadSave.STALL); // Load stall sprites
    }
}
