package gamescence;

import Utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Viet on 8/18/2016.
 */
public class MenuGameScence implements GameScence, KeyListener {
    private GameScenceListener gameScenceListener;
    private Image background;

    public MenuGameScence() {
        background = Utils.loadImage("resources/background.jpg");
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background, 0, 0, null);

    }

    @Override
    public KeyListener getKeyListener() {
        return this;
    }

    @Override
    public void setGameSceneListener(GameScenceListener gameSceneListener) {
        this.gameScenceListener = gameSceneListener;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (gameScenceListener != null)
                gameScenceListener.changeGameScence(new PlayGameScene());
        }

    }


    @Override
    public void keyReleased(KeyEvent e) {

    }


    @Override
    public void run() {

    }
}
