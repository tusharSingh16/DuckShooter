package levels;

import java.awt.Graphics;

import frames.*;
import entities.Crosshair;
import main.Game;
import utility.LoadSave;

public class LevelManager {

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

    public LevelManager(Game game) {
        this.game = game;
        curLevel = new Level();

//        shotHit = "/Users/devanshu/IdeaProjects/DuckShooter/res/gunshot2.wav";
        shotHit = "gunshot2";
        shotMiss = "missed";
//        curLevel.updateLevel();
//        curLevel.updateLevel();
        curLevel.updateLevel();
        curLevel.updateLevel();
        initClasses();
    }

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

    public void update() {
        crosshair.update();
        tm.update();
        dtm.update();
        dbm.update();
        if (tm.isDestroyed() && dtm.isDestroyed() && dbm.isDestroyed()) {
            curLevel.updateLevel();
            tm = new TargetManager(curLevel);
            dtm = new DuckTopManager(curLevel);
            dbm = new DuckBottomManager(curLevel);
        }
    }

    public void draw(Graphics g) {
        bf.render(g);
        tm.render(g);
        if1.render(g);
        dtm.render(g);
        if2.render(g);
        dbm.render(g);
        if3.render(g);
        crosshair.render(g);
        tf.render(g);
        g.drawString("Current Level: " + curLevel.curLevel,  Game.GAME_WIDTH-110, Game.GAME_HEIGHT-10);
    }

    public void handleShot(int x, int y) {
        boolean hit1, hit2, hit3;
        hit1 = tm.handleShot(x, y);
        hit2 = dtm.handleShot(x, y);
        hit3 = dbm.handleShot(x, y);

        if (hit1 || hit2 || hit3) {
            LoadSave.playSound(shotHit);
        } else {
            LoadSave.playSound(shotMiss);
        }
    }

    public Level getCurrentLevel() {
        return curLevel;
    }

    public Crosshair getCrosshair() {
        return crosshair;
    }
}