package GameScene;

import Controller.GameInput;
import Utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Created by Viet on 8/27/2016.
 */
public class PauseGameScene implements Scene,KeyListener {
    private Image pause;
    private GameInput gameInput;
    public int getStt() {
        return stt;
    }

    private final int stt = -1;

    public PauseGameScene() {
        pause = Utils.loadImage("resources/pause2.png");
        gameInput = new GameInput();
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {
        gameInput.keyP = true;
    }


    @Override
    public void keyReleased(KeyEvent e) {
        gameInput.keyP = false;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(pause, 550, 250, null);
    }

    @Override
    public void run() {
        if(gameInput.keyP){
            GameManager.getInstance().getStackScreen().pop();
            gameInput.keyP = false;
        }
    }

    @Override
    public KeyListener getKeyListener() {
        return this;
    }

    @Override
    public MouseListener getMouseListenr() {
        return null;
    }

    @Override
    public void setGameInput(GameInput gameInput) {

    }
}
