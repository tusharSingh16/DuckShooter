package inputs;

import gamestates.Gamestate;
import main.GamePanel; // Importing the 'GamePanel' class from the 'main' package

import java.awt.event.MouseEvent; // Importing the 'MouseEvent' class from the 'java.awt.event' package
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

// Declaring the public class 'MouseInputs' and implementing the 'MouseListener' and 'MouseMotionListener' interfaces
public class MouseInputs implements MouseListener, MouseMotionListener {
    private GamePanel gamePanel; // Declaring a private instance variable 'gamePanel' of type 'GamePanel'

    // Constructor for the 'MouseInputs' class, taking a 'GamePanel' parameter
    public MouseInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
             // No action needed for mouse clicked event
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (Gamestate.state) // Switch statement based on the current game state
        {
            case MENU:
                gamePanel.getGame().getMenu().mousePressed(e); // Handling mouse press event in the menu state
                break;
            case PLAYING:
                gamePanel.getGame().getPlaying().mousePressed(e); // Handling mouse press event in the playing state
                break;
            case INFO:
                gamePanel.getGame().getInfo().mousePressed(e);
            default:
                break; // No action needed for other states

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        gamePanel.getGame().getCrosshair().updateClick();
         // No action needed for mouse released event
    }

    @Override
    public void mouseEntered(MouseEvent e) {
         // No action needed for mouse released event
    }

    @Override
    public void mouseExited(MouseEvent e) {
         // No action needed for mouse released event
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        switch (Gamestate.state) // Switch statement based on the current game state
        {
            case MENU:
                gamePanel.getGame().getMenu().mouseDragged(e); // Handling mouse drag event in the menu state
                break;
            case PLAYING:
                gamePanel.getGame().getPlaying().mouseDragged(e); // Handling mouse drag event in the playing state
                break;
            case INFO:
                gamePanel.getGame().getInfo().mouseDragged(e);
            default:
                break; // No action needed for other states

        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        switch (Gamestate.state) //Switch statement based on the current game state
        {
            case MENU:
                gamePanel.getGame().getMenu().mouseMoved(e); // Handling mouse move event in the menu state
                break;
            case PLAYING:
                gamePanel.getGame().getPlaying().mouseMoved(e); // Handling mouse move event in the playing state
                break;
            case INFO:
                gamePanel.getGame().getInfo().mouseMoved(e); // Handling mouse move event in the info state
            default:
                break; // No action needed for other states

        }

    }
}
