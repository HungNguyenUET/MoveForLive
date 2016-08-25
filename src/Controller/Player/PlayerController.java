package Controller.Player;

import Controller.*;
import Controller.Enemy.EnemyController;
import Controller.Gift.GiftController;
import Controller.Weapon.WeaponController;
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
public class PlayerController extends SingleController implements Colliable {

    private static final int SPEED = 10;
    private static final int JUMP_SPEED = 5;
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
        }else if (gameInput.keyUp) {
            this.gameVector.dy = -JUMP_SPEED;
        }else if (gameInput.keySpace) {
            bulletrun();
        }
        if (this.gameObject.getY() == 350 ) {
            this.gameVector.dy = JUMP_SPEED;
            gameInput.keyUp = false;
        } else if(this.gameObject.getY() >= 500){
            this.gameObject.setY(500);
        }
        else if (this.gameObject.getX() <= 0){
            this.gameObject.setX(0);
        }else if (this.gameObject.getX() >= 450){
            this.gameObject.setX(450);
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
        if (colliable instanceof GiftController) {
            PlayerController.instance.getGameObject().setHp(PlayerController.instance.gameObject.getHp() + 5);
            colliable.getGameObject().destroy();
        }
    }

    public void setGameInput(GameInput gameInput) {
        this.gameInput = gameInput;
    }

    public void bulletrun() {
        count++;
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

    public void moveUp(){
        this.gameInput.keyUp = true;
        this.gameVector.dx = 0;
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