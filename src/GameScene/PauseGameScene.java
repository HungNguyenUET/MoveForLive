package GameScene;

import Utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Created by Viet on 8/27/2016.
 */
public class PauseGameScene implements GameScene, KeyListener {
    private GameSceneListener gameSceneListener;
    private Image pause;

    public PauseGameScene() {
        pause = Utils.loadImage("resources/pause2.png");
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(pause, 200, 200, null);
    }

    @Override
    public KeyListener getKeyListener() {
        return this;
    }

    @Override
    public MouseListener getMouseListener() {
        return null;
    }

    @Override
    public void setGameSceneListener(GameSceneListener gameSceneListener) {
        this.gameSceneListener = gameSceneListener;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_P) {
            gameSceneListener.changeGameScene(new PlayGameScene(), true);

        }

    }


    @Override
    public void keyReleased(KeyEvent e) {
    }


    @Override
    public void run() {

    }
}
