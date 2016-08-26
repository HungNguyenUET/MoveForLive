package Controller.Player;

import Controller.ControllerManager;
import Controller.GameInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by HungNguyen on 8/21/2016.
 */
public class PlayerControllerManager extends ControllerManager implements KeyListener{
    GameInput gameInput;

    public PlayerControllerManager() {
        this.add(PlayerController.instance);
        this.add(PlayerController2.instance);
        gameInput = new GameInput();
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
        PlayerController.instance.setGameInput(gameInput);
        PlayerController2.instance.setGameInput(gameInput);
        super.run();
        if(PlayerController.instance.getGameObject().getHp() <= 0 &&
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
                gameInput.keyLeft = true;
                break;
            case KeyEvent.VK_RIGHT:
                gameInput.keyRight = true;
                break;
            case KeyEvent.VK_UP:
                gameInput.keyUp = true;
                break;
            case KeyEvent.VK_SPACE:
                gameInput.keySpace = true;
                break;
            case KeyEvent.VK_A:
                gameInput.keyA = true;
                break;
            case KeyEvent.VK_D:
                gameInput.keyD = true;
                break;
            case KeyEvent.VK_W:
                gameInput.keyW = true;
                break;
            case KeyEvent.VK_ENTER:
                gameInput.keyEnter = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                gameInput.keyLeft = false;
                break;
            case KeyEvent.VK_RIGHT:
                gameInput.keyRight = false;
                break;
            case KeyEvent.VK_SPACE:
                gameInput.keySpace = false;
                break;
            case KeyEvent.VK_ENTER:
                gameInput.keyEnter = false;
                break;
            case KeyEvent.VK_A:
                gameInput.keyA = false;
                break;
            case KeyEvent.VK_D:
                gameInput.keyD = false;
                break;

        }
    }

    public final static PlayerControllerManager instance = new PlayerControllerManager();
}
