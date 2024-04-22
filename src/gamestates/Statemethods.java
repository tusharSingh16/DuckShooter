package gamestates;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent; // Importing the 'MouseEvent' class from the 'java.awt.event' package

// Declaring the public interface 'Statemethods'
public interface Statemethods {
    // Method declarations for updating the state
    public void update();

    // Method declarations for drawing the state
    public void draw(Graphics g);

    // Method declarations for handling mouse click events
    public void mouseClicked(MouseEvent e);

    // Method declarations for handling mouse drag events
    public void mouseDragged(MouseEvent e);

     // Method declarations for handling mouse move events
    public void mouseMoved(MouseEvent e);

    // Method declarations for handling mouse release events
    public void mouseReleased(MouseEvent e);

    // Method declarations for handling mouse press events
    public void mousePressed(MouseEvent e);

    // Method declarations for handling key press events
    public void keyPressed(KeyEvent e);

    // Method declarations for handling key release events
    public void keyReleased(KeyEvent e);
}
