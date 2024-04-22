package inputs;

import gamestates.Gamestate;
import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Declaring the public class 'KeyboardInputs' and implementing the 'KeyListener' interface
public class KeyboardInputs implements KeyListener {
    private GamePanel gamePanel;

    // Constructor for the 'KeyboardInputs' class, taking a 'GamePanel' parameter
    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel; // Assigning the 'gamePanel' parameter to the instance variable 'gamePanel'
    }

    @Override
    public void keyTyped(KeyEvent e) {
             // No action needed for key typed event
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (Gamestate.state)
        {
            case MENU:
                gamePanel.getGame().getMenu().keyPressed(e);
                break;
            case PLAYING:
                gamePanel.getGame().getPlaying().keyPressed(e);
                break;
            default:
                break;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
            // No action needed for key released event
    }
}
