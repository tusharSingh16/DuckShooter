package gamestates;

import main.Game;
import utility.Constants;
import utility.LoadSave;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static main.Game.TILES_SIZE;

public class Info extends State implements Statemethods{

    private BufferedImage bg;
    private BufferedImage backButtonInUse;
    private BufferedImage backButtonIdle;
    private BufferedImage backButtonHover;

    public Info(Game game) {
        super(game);
        bg = Game.sprites.stall[Constants.stall.BG_WOOD];
        backButtonInUse = backButtonIdle = LoadSave.getSpriteAtlas("back01");
        backButtonHover = LoadSave.getSpriteAtlas("back02");
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        for (int i=0;i<Game.GAME_WIDTH;i+=bg.getWidth()) {
            for (int j = 0; j < Game.GAME_HEIGHT; j += bg.getHeight()) {
                g.drawImage(bg, (int) i, (int) j, null);
            }
        } // drawing the background for info screen
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman",Font.BOLD,22));
        g.drawString("Credits : Devanshu Domendra Sakcham Tushar", Game.GAME_WIDTH/2 -240, Game.GAME_HEIGHT/2);
        g.drawImage(backButtonInUse,Game.GAME_WIDTH/2 - backButtonIdle.getWidth()/2, Game.GAME_HEIGHT/4 - backButtonIdle.getHeight()/2, null); // creates back button to return to main menu
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int xPos = e.getX();
        int yPos = e.getY();

        // changes the animation of button on mouse hover
        if(xPos >= Game.GAME_WIDTH/2 - backButtonIdle.getWidth()/2 && xPos <= Game.GAME_WIDTH/2 + backButtonIdle.getWidth()/2)
        {
            if(yPos >= Game.GAME_HEIGHT/4 - backButtonIdle.getHeight()/2 && yPos <= Game.GAME_HEIGHT/4 + backButtonIdle.getHeight()/2) {
                backButtonInUse = backButtonHover;
            }
            else
                backButtonInUse = backButtonIdle;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int xPos = e.getX();
        int yPos = e.getY();

        // return back to menu when clicked
        if(xPos >= Game.GAME_WIDTH/2 - backButtonIdle.getWidth()/2 && xPos <= Game.GAME_WIDTH/2 + backButtonIdle.getWidth()/2) {
            if (yPos >= Game.GAME_HEIGHT / 4 - backButtonIdle.getHeight() / 2 && yPos <= Game.GAME_HEIGHT / 4 + backButtonIdle.getHeight() / 2) {
                Gamestate.state = Gamestate.MENU;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
