package Controller;

import Model.Bullet;
import Model.Player;
import View.GameDrawer;
import View.ImageDrawer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by giaqu on 8/14/2016.
 */
public class PlayerController extends SingleController implements KeyListener, Colliable {

    private static final int SPEED = 10;
    private static final int ATK_SPEED = 3;
    private int count;

    private GameInput gameInput;
    private ControllerManager starManager;
    private ControllerManager bulletManager;


    private PlayerController(Player player, GameDrawer gameDrawer) {
        super(player, gameDrawer);
        this.gameInput = new GameInput();
        this.starManager = new ControllerManager();
        this.bulletManager = new ControllerManager();
        CollisionPool.instance.add(this);
        //PlayerControllerManager.instance.add(this);
        //this.gameVector.dx = SPEED;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        bulletManager.draw(g);

    }

    @Override
    public void run() {
        count++;
        this.gameVector.dx = 0;
        this.gameVector.dy = 0;

        if (gameInput.keyLeft && !gameInput.keyRight) {
            this.gameVector.dx = -SPEED;
            if(this.gameObject.getX() < 50){
                this.gameObject.setX(50);
            }
        } else if (!gameInput.keyLeft && gameInput.keyRight) {
            this.gameVector.dx = SPEED;
            if(this.gameObject.getX() > 450){
                this.gameObject.setX(450);
            }
        } else if (gameInput.keySpace) {
//            if (count > ATK_SPEED) {
//                BulletController bulletController = new BulletController(
//                        new Bullet(this.gameObject.getMiddleX() - Bullet.WIDTH / 2, this.gameObject.getY()),
//                        new ImageDrawer("resources/butter.png"));
//                bulletManager.add(bulletController);
//                count = 0;
//            }

        }

        super.run();
        bulletManager.run();
    }

    public final static PlayerController instance = new PlayerController(
            new Player(300, 500),
             new ImageDrawer("resources/ninja.png")
    );

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof WeaponController) {
            if(PlayerController.instance.gameObject.getHp() == 0){
                this.getGameObject().destroy();
                //JOptionPane.showMessageDialog(null, "Điểm: " + PlayerController.instance.gameObject.getPoint(), "Game Over", JOptionPane.WARNING_MESSAGE);
                //System.exit(0);
            }
            PlayerController.instance.getGameObject().setHp(PlayerController.instance.gameObject.getHp() - 1);
            colliable.getGameObject().destroy();
        }
        if (colliable instanceof EnemyController) {
            colliable.getGameObject().destroy();
            PlayerController.instance.getGameObject().setHp(PlayerController.instance.gameObject.getHp() - 1);
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
    public void bulletrun() {
        count ++;
        if (count > ATK_SPEED) {
            BulletController bulletController = new BulletController(
                    new Bullet(this.gameObject.getMiddleX() - Bullet.WIDTH / 2, this.gameObject.getY()),
                    new ImageDrawer("resources/butter.png"));
            bulletManager.add(bulletController);
            count = 0;
            System.out.println("ban");
        }
    }
    public void stopbullet() {
        this.gameInput.keySpace = false;
    }

    public void moveLeft(){
        this.gameInput.keyLeft = true;
        this.gameVector.dy = 0;
    }

    public void moveRight(){
        this.gameInput.keyRight = true;
        this.gameVector.dy = 0;
    }

    public void stopLeft(){
        this.gameInput.keyLeft = false;
    }

    public void stopRight(){
        this.gameInput.keyRight = false;
    }

}