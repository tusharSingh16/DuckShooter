package gamestates;

import levels.LevelManager;
import main.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Playing extends State implements Statemethods{
    private LevelManager lvlManager;
    //private Crosshair crosshair;

    public Playing(Game game) {
        super(game);
        initClasses();
    }

    private void initClasses() {
        lvlManager = new LevelManager(game);
    }
    public LevelManager getlvlManager() {
        return lvlManager;
    }

    @Override
    public void update() {
        lvlManager.update();
    }

    @Override
    public void draw(Graphics g) {
        lvlManager.draw(g);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        lvlManager.getCrosshair().updatePos(e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        lvlManager.getCrosshair().updatePos(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON3)
            Gamestate.state = Gamestate.MENU;
        lvlManager.getCrosshair().updateClick();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
