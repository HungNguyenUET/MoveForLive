package Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by HungNguyen on 8/21/2016.
 */
public class PlayerControllerManager extends ControllerManager implements KeyListener{

    public PlayerControllerManager() {
        this.add(PlayerController.instance);
        this.add(PlayerController2.instance);
    }

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
        if(PlayerController.instance.getGameObject().getHp() <= 0 ||
            PlayerController2.instance.getGameObject().getHp() <= 0){
            if(PlayerController.instance.getGameObject().getPoint() > PlayerController2.instance.getGameObject().getPoint()){
                JOptionPane.showMessageDialog(null, "Player 1: " + PlayerController.instance.gameObject.getPoint() +
                                "\nPlayer 2: " + PlayerController2.instance.gameObject.getPoint() + "\nPLAYER 1 WIN",
                        "Game Over", JOptionPane.WARNING_MESSAGE);
            }
            if(PlayerController.instance.getGameObject().getPoint() < PlayerController2.instance.getGameObject().getPoint()){
                JOptionPane.showMessageDialog(null, "Player 1: " + PlayerController.instance.gameObject.getPoint() +
                                "\nPlayer 2: " + PlayerController2.instance.gameObject.getPoint() + "\nPLAYER 2 WIN",
                        "Game Over", JOptionPane.WARNING_MESSAGE);
            }
            if(PlayerController.instance.getGameObject().getPoint() == PlayerController2.instance.getGameObject().getPoint()){
                JOptionPane.showMessageDialog(null, "Player 1: " + PlayerController.instance.gameObject.getPoint() +
                                "\nPlayer 2: " + PlayerController2.instance.gameObject.getPoint() + "\nDRAW",
                        "Game Over", JOptionPane.WARNING_MESSAGE);
            }
            System.exit(0);
        }
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
