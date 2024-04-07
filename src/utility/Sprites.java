package utility;

import java.awt.image.BufferedImage;

public class Sprites {
    public BufferedImage[] hud;
    public BufferedImage[] objects;
    public BufferedImage[] stall;

    public Sprites() {
        hud = LoadSave.LoadSprites(LoadSave.HUD);
        objects = LoadSave.LoadSprites(LoadSave.OBJECTS);
        stall = LoadSave.LoadSprites(LoadSave.STALL);
    }
}
