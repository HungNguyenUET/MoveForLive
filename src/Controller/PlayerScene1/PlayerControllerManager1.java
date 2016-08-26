package Controller.PlayerScene1;

import Controller.ControllerManager;
import Controller.GameInput;
import GameScene.PauseGameScene;
import GameScene.PlayGameScene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by HungNguyen on 8/21/2016.
 */
public class PlayerControllerManager1 extends ControllerManager implements KeyListener{
    GameInput gameInput;

    public PlayerControllerManager1() {
        this.add(Controller.PlayerScene1.PlayerController21.instance);
        this.add(PlayerController12.instance);
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
        Controller.PlayerScene1.PlayerController21.instance.setGameInput(gameInput);
        PlayerController12.instance.setGameInput(gameInput);
        super.run();
        if(gameInput.keyP){
            gameInput.keyP = false;
            PlayGameScene.gameScenceListener.changeGameScene(new PauseGameScene(), true);
        }
        if(Controller.PlayerScene1.PlayerController21.instance.getGameObject().getHp() <= 0 &&
            PlayerController12.instance.getGameObject().getHp() <= 0){
            if(Controller.PlayerScene1.PlayerController21.instance.getGameObject().getPoint() > PlayerController12.instance.getGameObject().getPoint()){
                JOptionPane.showMessageDialog(null, "PlayerScene1 1: " + Controller.PlayerScene1.PlayerController21.instance.gameObject.getPoint() +
                                "\nPlayerScene1 2: " + PlayerController12.instance.gameObject.getPoint() + "\nPLAYER 1 WIN",
                        "Game Over", JOptionPane.WARNING_MESSAGE);
            }
            if(Controller.PlayerScene1.PlayerController21.instance.getGameObject().getPoint() < PlayerController12.instance.getGameObject().getPoint()){
                JOptionPane.showMessageDialog(null, "PlayerScene1 1: " + Controller.PlayerScene1.PlayerController21.instance.gameObject.getPoint() +
                                "\nPlayerScene1 2: " + PlayerController12.instance.gameObject.getPoint() + "\nPLAYER 2 WIN",
                        "Game Over", JOptionPane.WARNING_MESSAGE);
            }
            if(Controller.PlayerScene1.PlayerController21.instance.getGameObject().getPoint() == PlayerController12.instance.getGameObject().getPoint()){
                JOptionPane.showMessageDialog(null, "PlayerScene1 1: " + Controller.PlayerScene1.PlayerController21.instance.gameObject.getPoint() +
                                "\nPlayerScene1 2: " + PlayerController12.instance.gameObject.getPoint() + "\nDRAW",
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
            case KeyEvent.VK_P:
                gameInput.keyP = true;
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

    public final static PlayerControllerManager1 instance = new PlayerControllerManager1();
}
