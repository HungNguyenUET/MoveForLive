package Controller;

import Model.GameObject;
import Model.Player;
import View.GameDrawer;
import View.ImageDrawer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Viet on 8/19/2016.
 */
public class PlayerController2 extends SingleController  implements Colliable, KeyListener {
    private static final int SPEED = 10;
    private GameInput gameInput;


    public PlayerController2(Player gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameInput = new GameInput();
//        this.starManager = new ControllerManager();
        CollisionPool.instance.add(this);
        //PlayerControllerManager.instance.add(this);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

    @Override
    public void onCollide(Colliable colliable) {

    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {

            case KeyEvent.VK_A:
                this.gameInput.keyA = true;
                this.gameVector.dy = 0;
                break;
            case KeyEvent.VK_D:
                this.gameInput.keyD = true;
                this.gameVector.dy = 0;
                break;
        }

    }


    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                this.gameInput.keyA = false;
                break;
            case KeyEvent.VK_D:
                this.gameInput.keyD = false;
                break;
        }

    }
    @Override
    public void run() {
//        count++;
        this.gameVector.dx = 0;
        this.gameVector.dy = 0;

        if (gameInput.keyA && !gameInput.keyD) {
            this.gameVector.dx = -SPEED;
        } else if (!gameInput.keyA && gameInput.keyD) {
            this.gameVector.dx = SPEED;
        }

        super.run();
//        starManager.run();
        this.getGameObject().moveTo(gameObject.getX() + gameVector.dx, gameObject.getY() + gameVector.dy);
    }
    public final static PlayerController2 instance = new PlayerController2(
            new Player(800, 500),
            new ImageDrawer("resources/demon.png")
    );

    public void moveLeft(){
        this.gameInput.keyA = true;
        this.gameVector.dy = 0;
    }

    public void moveRight(){
        this.gameInput.keyD = true;
        this.gameVector.dy = 0;
    }

    public void stopLeft(){
        this.gameInput.keyA = false;
    }

    public void stopRight(){
        this.gameInput.keyD = false;
    }
}
