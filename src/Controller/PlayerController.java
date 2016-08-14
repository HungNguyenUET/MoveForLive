package Controller;

import Model.Player;
import View.GameDrawer;
import View.ImageDrawer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by giaqu on 8/14/2016.
 */
public class PlayerController extends SingleController implements KeyListener, Colliable {

    private static final int SPEED = 3;
    private GameInput gameInput;

    public PlayerController(Player player, GameDrawer gameDrawer) {
        super(player, gameDrawer);
        this.gameInput = new GameInput();
        CollisionPool.instance.add(this);
        //this.gameVector.dx = SPEED;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

    @Override
    public void run() {
        this.gameVector.dx = 0;
        this.gameVector.dy = 0;

        if (gameInput.keyLeft && !gameInput.keyRight) {
            this.gameVector.dx = -SPEED;
        } else if (!gameInput.keyLeft && gameInput.keyRight) {
            this.gameVector.dx = SPEED;
        }
        if (gameInput.keySpace){
            
        }
        super.run();
        this.getGameObject().moveTo(gameObject.getX() + gameVector.dx, gameObject.getY() + gameVector.dy);
    }

    public final static PlayerController playerController = new PlayerController(
            new Player(300, 700),
            new ImageDrawer("resources/Ahuy.png")
    );

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof WeaponController) {
            if(PlayerController.playerController.gameObject.getHp() == 0){
                this.getGameObject().destroy();
                JOptionPane.showMessageDialog(null, "Điểm: " + PlayerController.playerController.gameObject.getPoint(), "Game Over", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
            PlayerController.playerController.getGameObject().setHp(PlayerController.playerController.gameObject.getHp() - 1);
            colliable.getGameObject().destroy();
        }
        if (colliable instanceof EnemyController) {
            colliable.getGameObject().destroy();
            PlayerController.playerController.getGameObject().setHp(PlayerController.playerController.gameObject.getHp() - 1);
        }
//        if (colliable instanceof TrapController) {
//            // PlayerController.playcontroller.getGameObject().setPoint(PlayerController.playcontroller.gameObject.getPoint() - 100);
//            colliable.getGameObject().destroy();
//        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                this.gameInput.keyLeft = true;
                this.gameVector.dy = 0;
                break;
            case KeyEvent.VK_RIGHT:
//                this.gameVector.dx = SPEED;
                this.gameInput.keyRight = true;
                this.gameVector.dy = 0;
                break;
            case KeyEvent.VK_SPACE:
                this.gameInput.keySpace = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                this.gameInput.keyLeft = false;
                break;
            case KeyEvent.VK_RIGHT:
                this.gameInput.keyRight = false;
                break;
            case KeyEvent.VK_SPACE:
                this.gameInput.keySpace = false;
                break;
        }

    }
}