package main;

import levels.LevelManager;
import utility.Sprites;

import java.awt.*;

// Initialize everything and starts game loop
public class Game implements Runnable{
    private Thread gameThread;
    private GameWindow gameWindow;
    private GamePanel gamePanel;

    private final int FPS = 150;
    private final int UPS = 500;

    public final static int TILE_DEFAULT_SIZE = 32;
    public final static float SCALE = 1.0f;
    public final static int TILE_IN_WIDTH = 40;

    public final static int TILE_IN_HEIGHT = 24;
    public final static int TILES_SIZE = (int)(SCALE * TILE_DEFAULT_SIZE);
    public final static int GAME_WIDTH = TILE_IN_WIDTH * TILES_SIZE;
    public final static int GAME_HEIGHT = TILE_IN_HEIGHT * TILES_SIZE;
    public static Sprites sprites;

    private LevelManager lvlManager;

    public Game() {
        sprites = new Sprites();

        initClasses();

        this.gamePanel = new GamePanel(this);
        this.gameWindow = new GameWindow(gamePanel);

        startGameLoop();

    }

    private void initClasses() {
        lvlManager = new LevelManager(this);
    }

    public void update() {
        lvlManager.update();
    }

    public void render(Graphics g) {
        lvlManager.draw(g);
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double timePerFrame = 1.0e9f / FPS;
        double timePerUpdate = 1.0e9f / UPS;

        int frames = 0;
        int updates = 0;

        double deltaF = 0;
        double deltaU = 0;

        long previoustime = System.nanoTime();
        long lastCheck = System.currentTimeMillis();

        while(true) {
            long currentTime = System.nanoTime();

            deltaF += (currentTime - previoustime)/timePerFrame;
            deltaU += (currentTime - previoustime)/timePerUpdate;
            previoustime = currentTime;
            if (deltaF>=1) {
                gamePanel.repaint();
                frames++;
                deltaF--;
            }
            if (deltaU>=1) {
                gamePanel.updateGame();
                updates++;
                deltaU--;
            }
            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;

            }
        }
    }

    public LevelManager getlvlManager() {
        return lvlManager;
    }
}
