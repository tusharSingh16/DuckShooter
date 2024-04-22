package gamestates;

import main.Game;
import utility.Constants;
import utility.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static main.Game.TILES_SIZE;

// This class represents the menu page of the game
public class Menu extends State implements Statemethods {

    // Background image
    private BufferedImage bg;

    // Images for different buttons
    private BufferedImage playButtonInUse;
    private BufferedImage playButtonIdle;
    private BufferedImage playButtonHover;
    private BufferedImage resumeButtonInUse;
    private BufferedImage resumeButtonIdle;
    private BufferedImage resumeButtonHover;
    private BufferedImage infoButtonInUse;
    private BufferedImage infoButtonIdle;
    private BufferedImage infoButtonHover;
    private BufferedImage backButtonInUse;
    private BufferedImage backButtonIdle;
    private BufferedImage backButtonHover;
    public static boolean isMenu = true;

    public Menu(Game game) {
        super(game);
        // Load background image
        bg = Game.sprites.stall[Constants.stall.BG_WOOD];

        // Load images for play button
        playButtonInUse = playButtonIdle = LoadSave.getSpriteAtlas("play01");
        playButtonHover = LoadSave.getSpriteAtlas("play02");

        // Load images for info button
        infoButtonInUse = infoButtonIdle = LoadSave.getSpriteAtlas("information01");
        infoButtonHover = LoadSave.getSpriteAtlas("information02");

        // Load images for back button
        backButtonInUse = backButtonIdle = LoadSave.getSpriteAtlas("back01");
        backButtonHover = LoadSave.getSpriteAtlas("back02");
        resumeButtonInUse = resumeButtonIdle = LoadSave.getSpriteAtlas("replay01");
        resumeButtonHover = LoadSave.getSpriteAtlas("replay02");

    }

    @Override
    public void update() {

    }

    // Draw method to render the menu
    @Override
    public void draw(Graphics g) {
        // Draw background
        g.setColor(Color.BLACK);
//        g.drawString(",Game.GAME_WIDTH/2,200);
        for (int i=0;i<Game.GAME_WIDTH;i+=bg.getWidth()) {
            for (int j = 0; j < Game.GAME_HEIGHT; j += bg.getHeight()) {
                g.drawImage(bg, (int) i, (int) j, null);
            }
        }
        // Draw buttons
        if(isMenu) g.drawImage(playButtonInUse,Game.GAME_WIDTH/2 - playButtonIdle.getWidth()/2, Game.GAME_HEIGHT/4 - playButtonIdle.getHeight()/2, null);
        else g.drawImage(resumeButtonIdle, Game.GAME_WIDTH/2 - resumeButtonInUse.getWidth()/2, Game.GAME_HEIGHT/4 - resumeButtonInUse.getHeight()/2, null);
        g.drawImage(infoButtonInUse,Game.GAME_WIDTH/2 - playButtonIdle.getWidth()/2, Game.GAME_HEIGHT/4 + TILES_SIZE * 2 - infoButtonIdle.getHeight()/2, null);
        g.drawImage(backButtonInUse,Game.GAME_WIDTH/2 - backButtonIdle.getWidth()/2, Game.GAME_HEIGHT/4 + TILES_SIZE * 4 - backButtonIdle.getHeight()/2, null);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    // Handle mouse move event
    @Override
    public void mouseMoved(MouseEvent e) {
        int xPos = e.getX();
        int yPos = e.getY();

        if(isMenu) {
            if (xPos >= Game.GAME_WIDTH / 2 - playButtonIdle.getWidth() / 2 && xPos <= Game.GAME_WIDTH / 2 + playButtonIdle.getWidth() / 2) {
                if (yPos >= Game.GAME_HEIGHT / 4 - playButtonIdle.getHeight() / 2 && yPos <= Game.GAME_HEIGHT / 4 + playButtonIdle.getHeight() / 2) {
                    playButtonInUse = playButtonHover;
                } else playButtonInUse = playButtonIdle;
                if (yPos >= Game.GAME_HEIGHT / 4 + TILES_SIZE * 2 - infoButtonIdle.getHeight() / 2 && yPos <= Game.GAME_HEIGHT / 4 + TILES_SIZE * 2 + infoButtonIdle.getHeight() / 2) {
                    infoButtonInUse = infoButtonHover;
                } else infoButtonInUse = infoButtonIdle;
                if (yPos >= Game.GAME_HEIGHT / 4 + TILES_SIZE * 4 - backButtonIdle.getHeight() / 2 && yPos <= Game.GAME_HEIGHT / 4 + TILES_SIZE * 4 + backButtonIdle.getHeight() / 2) {
                    backButtonInUse = backButtonHover;
                } else backButtonInUse = backButtonIdle;
            }
        }
        else
        if (xPos >= Game.GAME_WIDTH / 2 - resumeButtonIdle.getWidth() / 2 && xPos <= Game.GAME_WIDTH / 2 + resumeButtonIdle.getWidth() / 2) {
            if (yPos >= Game.GAME_HEIGHT / 4 - resumeButtonIdle.getHeight() / 2 && yPos <= Game.GAME_HEIGHT / 4 + resumeButtonIdle.getHeight() / 2) {
                resumeButtonInUse = resumeButtonHover;
            } else resumeButtonInUse = resumeButtonIdle;
            if (yPos >= Game.GAME_HEIGHT / 4 + TILES_SIZE * 2 - infoButtonIdle.getHeight() / 2 && yPos <= Game.GAME_HEIGHT / 4 + TILES_SIZE * 2 + infoButtonIdle.getHeight() / 2) {
                infoButtonInUse = infoButtonHover;
            } else infoButtonInUse = infoButtonIdle;
            if (yPos >= Game.GAME_HEIGHT / 4 + TILES_SIZE * 4 - backButtonIdle.getHeight() / 2 && yPos <= Game.GAME_HEIGHT / 4 + TILES_SIZE * 4 + backButtonIdle.getHeight() / 2) {
                backButtonInUse = backButtonHover;
            } else backButtonInUse = backButtonIdle;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int xPos = e.getX();
        int yPos = e.getY();

        // Check which button is pressed and perform corresponding action
        if(isMenu) {
            if (xPos >= Game.GAME_WIDTH / 2 - playButtonInUse.getWidth() / 2 && xPos <= Game.GAME_WIDTH / 2 + playButtonInUse.getWidth() / 2) {
                //play button opens the main game
                if (yPos >= Game.GAME_HEIGHT / 4 - playButtonInUse.getHeight() / 2 && yPos <= Game.GAME_HEIGHT / 4 + playButtonInUse.getHeight() / 2) {
                    isMenu = false;
                    Gamestate.state = Gamestate.PLAYING;
                    // information button open info page but here we used terminal
                } else if (yPos >= Game.GAME_HEIGHT / 4 + TILES_SIZE * 2 - infoButtonIdle.getHeight() / 2 && yPos <= Game.GAME_HEIGHT / 4 + TILES_SIZE * 2 + infoButtonIdle.getHeight() / 2) {
                    System.out.println("INFO SCREEN");
                }
                // back button exit the game
                else if (yPos >= Game.GAME_HEIGHT / 4 + TILES_SIZE * 4 - backButtonIdle.getHeight() / 2 && yPos <= Game.GAME_HEIGHT / 4 + TILES_SIZE * 4 + backButtonIdle.getHeight() / 2) {
                    System.exit(0);
                }
            }
        }
        else
        if (xPos >= Game.GAME_WIDTH / 2 - resumeButtonInUse.getWidth() / 2 && xPos <= Game.GAME_WIDTH / 2 + resumeButtonInUse.getWidth() / 2) {
            //play button opens the main game
            if (yPos >= Game.GAME_HEIGHT / 4 - resumeButtonInUse.getHeight() / 2 && yPos <= Game.GAME_HEIGHT / 4 + resumeButtonInUse.getHeight() / 2) {
                Gamestate.state = Gamestate.PLAYING;
                // information button open info page but here we used terminal
            } else if (yPos >= Game.GAME_HEIGHT / 4 + TILES_SIZE * 2 - infoButtonIdle.getHeight() / 2 && yPos <= Game.GAME_HEIGHT / 4 + TILES_SIZE * 2 + infoButtonIdle.getHeight() / 2) {
                System.out.println("INFO SCREEN");
            }
            // back button exit the game
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


}
