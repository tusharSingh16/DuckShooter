package gamestates;

import main.Game;
import utility.Constants;
import utility.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static main.Game.TILES_SIZE;

public class Menu extends State implements Statemethods {
    private BufferedImage bg;
    private BufferedImage playButtonInUse;
    private BufferedImage playButtonIdle;
    private BufferedImage playButtonHover;
    private BufferedImage infoButtonInUse;
    private BufferedImage infoButtonIdle;
    private BufferedImage infoButtonHover;
    private BufferedImage backButtonInUse;
    private BufferedImage backButtonIdle;
    private BufferedImage backButtonHover;

    public Menu(Game game) {
        super(game);
        bg = Game.sprites.stall[Constants.stall.BG_WOOD];

        playButtonInUse = playButtonIdle = LoadSave.getSpriteAtlas("play01");
        playButtonHover = LoadSave.getSpriteAtlas("play02");

        infoButtonInUse = infoButtonIdle = LoadSave.getSpriteAtlas("information01");
        infoButtonHover = LoadSave.getSpriteAtlas("information02");

        backButtonInUse = backButtonIdle = LoadSave.getSpriteAtlas("back01");
        backButtonHover = LoadSave.getSpriteAtlas("back02");

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
        g.drawImage(playButtonInUse,Game.GAME_WIDTH/2 - playButtonIdle.getWidth()/2, Game.GAME_HEIGHT/4 - playButtonIdle.getHeight()/2, null);
        g.drawImage(infoButtonInUse,Game.GAME_WIDTH/2 - playButtonIdle.getWidth()/2, Game.GAME_HEIGHT/4 + TILES_SIZE * 2 - infoButtonIdle.getHeight()/2, null);
        g.drawImage(backButtonInUse,Game.GAME_WIDTH/2 - backButtonIdle.getWidth()/2, Game.GAME_HEIGHT/4 + TILES_SIZE * 4 - backButtonIdle.getHeight()/2, null);
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

        if(xPos >= Game.GAME_WIDTH/2 - playButtonIdle.getWidth()/2 && xPos <= Game.GAME_WIDTH/2 + playButtonIdle.getWidth()/2) {
            if (yPos >= Game.GAME_HEIGHT / 4 - playButtonIdle.getHeight() / 2 && yPos <= Game.GAME_HEIGHT / 4 + playButtonIdle.getHeight() / 2) {
                playButtonInUse = playButtonHover;
            }
            else playButtonInUse = playButtonIdle;
            if (yPos >= Game.GAME_HEIGHT / 4 + TILES_SIZE * 2 - infoButtonIdle.getHeight() / 2 && yPos <= Game.GAME_HEIGHT / 4 + TILES_SIZE * 2 + infoButtonIdle.getHeight() / 2) {
                infoButtonInUse = infoButtonHover;
            }
            else infoButtonInUse = infoButtonIdle;
            if (yPos >= Game.GAME_HEIGHT / 4 + TILES_SIZE * 4 - backButtonIdle.getHeight() / 2 && yPos <= Game.GAME_HEIGHT / 4 + TILES_SIZE * 4 + backButtonIdle.getHeight() / 2) {
                backButtonInUse = backButtonHover;
            }
            else backButtonInUse = backButtonIdle;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int xPos = e.getX();
        int yPos = e.getY();

        if(xPos >= Game.GAME_WIDTH/2 - playButtonInUse.getWidth()/2 && xPos <= Game.GAME_WIDTH/2 + playButtonInUse.getWidth()/2)
        {
            if(yPos >= Game.GAME_HEIGHT/4 - playButtonInUse.getHeight()/2 && yPos <= Game.GAME_HEIGHT/4 + playButtonInUse.getHeight()/2) {
                Gamestate.state = Gamestate.PLAYING;
            }else if (yPos >= Game.GAME_HEIGHT / 4 + TILES_SIZE * 2 - infoButtonIdle.getHeight() / 2 && yPos <= Game.GAME_HEIGHT / 4 + TILES_SIZE * 2 + infoButtonIdle.getHeight() / 2) {
                System.out.println("INFO SCREEN");
            }
            else if (yPos >= Game.GAME_HEIGHT / 4 + TILES_SIZE * 4 - backButtonIdle.getHeight() / 2 && yPos <= Game.GAME_HEIGHT / 4 + TILES_SIZE * 4 + backButtonIdle.getHeight() / 2) {
                System.exit(0);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void help()
    {
        System.out.println("Help Screen");
    }
}
