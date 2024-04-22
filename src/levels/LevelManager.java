package levels;

import java.awt.Graphics;

import frames.*;
import entities.Crosshair;
import main.Game;
import utility.LoadSave;

public class LevelManager { // Declaring the public class 'LevelManager'

    private Game game;
    private Level curLevel;

    // Static Frames
    private BaseFrame bf;
    private IntermediateFrame1 if1;
    private IntermediateFrame2 if2;
    private IntermediateFrame3 if3;
    private TopFrame tf;

    private TargetManager tm;
    private DuckTopManager dtm;
    private DuckBottomManager dbm;
    private Crosshair crosshair;


    private String shotHit;
    private String shotMiss;

    // Constructor for the 'LevelManager' class, taking a 'Game' parameter
    public LevelManager(Game game) {
        this.game = game; // Assigning the 'game' parameter to the 'game' instance variable
        curLevel = new Level(); // Creating a new 'Level' object and assigning it to 'curLevel'

//        shotHit = "/Users/devanshu/IdeaProjects/DuckShooter/res/gunshot2.wav";
        // Setting file paths for sound effects
        shotHit = "gunshot2";
        shotMiss = "missed";
//        curLevel.updateLevel();
//        curLevel.updateLevel();

        // Updating the level initially
        curLevel.updateLevel();
        curLevel.updateLevel();

        // Initializing various classes used in the game
        initClasses();
    }

    // Method to initialize various classes used in the game
    private void initClasses() {
        bf = new BaseFrame();
        if1 = new IntermediateFrame1();
        if2 = new IntermediateFrame2();
        if3 = new IntermediateFrame3();
        tf = new TopFrame();
        crosshair = new Crosshair(0, 0, this);
        tm = new TargetManager(curLevel);
        dtm = new DuckTopManager(curLevel);
        dbm = new DuckBottomManager(curLevel);
    }

    // Method to update the game state
    public void update() {
        crosshair.update(); // Updating the crosshair
        tm.update(); // Updating the target manager
        dtm.update(); // Updating the duck top manager
        dbm.update(); // Updating the duck bottom manager

        // Checking if all targets and ducks are destroyed to proceed to the next level
        if (tm.isDestroyed() && dtm.isDestroyed() && dbm.isDestroyed()) {

            curLevel.updateLevel(); // Updating the current level

            // Re-initializing target manager and duck managers for the new level
            tm = new TargetManager(curLevel);
            dtm = new DuckTopManager(curLevel);
            dbm = new DuckBottomManager(curLevel);
        }
    }
    // Method to draw all elements on the screen
    public void draw(Graphics g) {
        bf.render(g); // Rendering the base frame
        tm.render(g); // Rendering the targets
        if1.render(g); // Rendering intermediate frame 1
        dtm.render(g); // Rendering the top ducks
        if2.render(g); // Rendering intermediate frame 2
        dbm.render(g); // Rendering the bottom ducks
        if3.render(g); // Rendering intermediate frame 3
        crosshair.render(g);  // Rendering the crosshair
        tf.render(g); // Rendering the top frame
        //Displaying current level information on screen
        g.drawString("Current Level: " + curLevel.curLevel,  Game.GAME_WIDTH-110, Game.GAME_HEIGHT-10);
    }
    // Method to handle a shot fired by the player
    public void handleShot(int x, int y) {
        // Handling shot for targets and ducks separately
        boolean hit1, hit2, hit3;
        hit1 = tm.handleShot(x, y);
        hit2 = dtm.handleShot(x, y);
        hit3 = dbm.handleShot(x, y);
         
        // Playing sound effects based on whether any target or duck was hit
        if (hit1 || hit2 || hit3) {
            LoadSave.playSound(shotHit);// Playing the gunshot sound
        } else {
            LoadSave.playSound(shotMiss);// Playing the miss sound
        }
    }

     // Getter method for the current leve
    public Level getCurrentLevel() {
        return curLevel;
    }
     // Getter method for the crosshair
    public Crosshair getCrosshair() {
        return crosshair;
    }
}