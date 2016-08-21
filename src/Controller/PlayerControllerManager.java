package Controller;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by HungNguyen on 8/21/2016.
 */
public class PlayerControllerManager extends ControllerManager implements KeyListener{

    public KeyListener getKeyListener(){
        return this;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                PlayerController.instance.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
//                this.gameVector.dx = SPEED;
                PlayerController.instance.moveRight();
                break;
            case KeyEvent.VK_SPACE:
                break;
            case KeyEvent.VK_A:
                PlayerController2.instance.moveLeft();
                break;
            case KeyEvent.VK_D:
                PlayerController2.instance.moveRight();
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                PlayerController.instance.stopLeft();
                break;
            case KeyEvent.VK_RIGHT:
//                this.gameVector.dx = SPEED;
                PlayerController.instance.stopRight();
                break;
            case KeyEvent.VK_SPACE:
                break;
            case KeyEvent.VK_A:
                PlayerController2.instance.stopLeft();
                break;
            case KeyEvent.VK_D:
                PlayerController2.instance.stopRight();
                break;

        }
    }

    public final static PlayerControllerManager instance = new PlayerControllerManager();
}
