package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

// GamePanel - Working area or panel for the game (InnerShell)
public class GamePanel extends JPanel {
    private final Game game;
    GamePanel(Game game) {
        this.game = game;
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(new MouseInputs(this));
        addMouseMotionListener(new MouseInputs(this));
    }

    private void setPanelSize() {
        Dimension size = new Dimension(Game.GAME_WIDTH, Game.GAME_HEIGHT);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void paintComponent(Graphics g) {
        // pass g to JPanel class to do the preprocessing code
        super.paintComponent(g);
        game.render(g);
    }

    public void updateGame() {
        game.update();
    }
    public Game getGame() {
        return game;
    }
}
