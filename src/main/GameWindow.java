package main;

import utility.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.image.BufferedImage;

// GameWindow - A frame for the Panel to stick on (OuterShell)
public class GameWindow {
    private JFrame jFrame;

    GameWindow(JPanel jPanel) {
        jFrame = new JFrame();
        jFrame.add(jPanel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setTitle("Duck Shooter");
        jFrame.setIconImage(Game.sprites.objects[Constants.objects.DUCK_BROWN]);


    }

    // Hides the cursor in application
    public void setCursorInvisible() {
        Cursor invisibleCursor = Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "invisibleCursor");
        jFrame.setCursor(invisibleCursor);
    }

    public void setCursorVisible() {
        Cursor invisibleCursor = Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "invisibleCursor");
        jFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }


}
