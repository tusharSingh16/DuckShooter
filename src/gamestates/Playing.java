package gamestates;

import levels.LevelManager;
import main.Game;
import utility.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static main.Game.TILES_SIZE;

public class Playing extends State implements Statemethods{
    private LevelManager lvlManager;
    private BufferedImage pauseButtonInUse;
    private BufferedImage pauseButtonIdle;
    private BufferedImage pauseButtonHover;
    public Playing(Game game) {
        super(game);
        initClasses();
        pauseButtonInUse = pauseButtonIdle = LoadSave.getSpriteAtlas("pause01");
        pauseButtonHover = LoadSave.getSpriteAtlas("pause02");
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
        g.drawImage(pauseButtonInUse, 0, 0, null);

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
        int xPos = e.getX();
        int yPos = e.getY();

        if (xPos >= 0 && xPos <= pauseButtonIdle.getWidth()) {
            if (yPos >= 0 && yPos <= pauseButtonIdle.getHeight()) {
                pauseButtonInUse = pauseButtonHover;
            } else pauseButtonInUse = pauseButtonIdle;
        }

        lvlManager.getCrosshair().updatePos(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int xPos = e.getX();
        int yPos = e.getY();

        if (xPos >= 0 && xPos <= pauseButtonIdle.getWidth()) {
            if (yPos >= 0 && yPos <= pauseButtonIdle.getHeight()) {
                Gamestate.state = Gamestate.MENU;

            }
            if (e.getButton() == MouseEvent.BUTTON3)
                Gamestate.state = Gamestate.MENU;
        }
        lvlManager.getCrosshair().updateClick();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
