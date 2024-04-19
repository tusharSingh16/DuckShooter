package gamestates;

import main.Game;
import utility.Constants;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Menu extends State implements Statemethods {

    private BufferedImage StartGame;
    private BufferedImage bg;
    public Menu(Game game) {
        super(game);
        StartGame = Game.sprites.hud[Constants.Hud.TEXT_READY];
        bg = Game.sprites.stall[Constants.stall.BG_RED];
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
//        g.drawString(",Game.GAME_WIDTH/2,200);
        for (int i=0;i<Game.GAME_WIDTH;i+=bg.getWidth()) {
            for (int j = 0; j < Game.GAME_HEIGHT; j += bg.getHeight()) {
                g.drawImage(bg, (int) i, (int) j, null);
            }
        }
        g.drawImage(StartGame,Game.GAME_WIDTH/2 - StartGame.getWidth()/2, Game.GAME_HEIGHT/2 - StartGame.getHeight()/2, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON3)
            Gamestate.state = Gamestate.PLAYING;
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
