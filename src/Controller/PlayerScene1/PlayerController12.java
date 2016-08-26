package Controller.PlayerScene1;

import Controller.*;
import Controller.Enemy.BirdController;
import Controller.Enemy.EnemyController;
import Controller.Gift.GiftController;
import Controller.Weapon.WeaponController;
import Model.Bullet;
import Model.Player;
import Utils.Utils;
import View.GameDrawer;
import View.ImageDrawer;

import java.awt.*;

/**
 * Created by Viet on 8/19/2016.
 */
public class PlayerController12 extends SingleController implements Colliable {
    private static final int SPEED = 10;
    private static final int JUMP_SPEED = 5;
    private static final int ATK_SPEED = 3;
    private int count;
    private GameInput gameInput;
    private ControllerManager bulletManager;


    public PlayerController12(Player gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameInput = new GameInput();
        this.bulletManager = new ControllerManager();
        CollisionPool.instance.add(this);
        //PlayerControllerManager1.instance.add(this);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        bulletManager.draw(g);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof WeaponController) {
            PlayerController12.instance.getGameObject().setHp(PlayerController12.instance.gameObject.getHp() - 1);
            colliable.getGameObject().destroy();
        }
        if (colliable instanceof EnemyController) {
            colliable.getGameObject().destroy();
            PlayerController12.instance.getGameObject().setHp(PlayerController12.instance.gameObject.getHp() - 1);
        }
        if (colliable instanceof BirdController) {
            colliable.getGameObject().destroy();
//            PlayerController12.instance.getGameObject().setHp(PlayerController12.instance.gameObject.getHp() - 1);
        }
        if (colliable instanceof GiftController) {
            PlayerController12.instance.getGameObject().setHp(PlayerController12.instance.gameObject.getHp() + 2);
            colliable.getGameObject().destroy();
        }
        if(PlayerController12.instance.gameObject.getHp() <= 0){
            this.getGameObject().destroy();
            PlayerController12.instance.getGameObject().setHp(0);
        }
    }



    @Override
    public void run() {
        count++;
        this.gameVector.dx = 0;
        if (gameInput.keyLeft&& !gameInput.keyRight) {
            this.gameVector.dx = -SPEED;
            if(this.gameObject.getX() < 600){
                this.gameObject.setX(600);
            }
        } else if (!gameInput.keyLeft && gameInput.keyRight) {
            this.gameVector.dx = SPEED;
            if(this.gameObject.getX() > 1000){
                this.gameObject.setX(1000);
            }
        }
        if (gameInput.keyUp) {
            this.gameVector.dy = -JUMP_SPEED;
        }
//        if (gameInput.keyUp && gameInput.keyLeft){
//            this.gameVector.dy -= JUMP_SPEED;
//            this.gameVector.dx -= SPEED;
//
//
//        } else if (gameInput.keyUp && gameInput.keyRight){
//            this.gameVector.dy -= JUMP_SPEED;
//            this.gameVector.dx = SPEED;
//
//        }
        if (gameInput.keyEnter) {
            bulletrun2();
        }
        if(this.gameObject.getY() >= 500){
            this.gameObject.setY(500);

        }else if (this.gameObject.getY() == 350 ) {
            Utils.playSound("resources/jumpsound.wav", false);
            this.gameVector.dy = JUMP_SPEED;
            gameInput.keyUp = false;
        }else if (gameObject.getX() <= 600) {
            this.gameObject.setX(600);
        }else if ( gameObject.getX() >= 1000) {
            this.gameObject.setX(1000);
        }
        this.getGameObject().moveTo(gameObject.getX() + gameVector.dx, gameObject.getY() + gameVector.dy);
        super.run();
        bulletManager.run();
    }

    public final static PlayerController12 instance = new PlayerController12(
            new Player(750, 500),
            new ImageDrawer("resources/ninja2.png")
    );

    private void bulletrun2() {
        if (count > ATK_SPEED) {
            BulletController bulletController = new BulletController(
                    new Bullet(this.gameObject.getMiddleX() - Bullet.WIDTH / 2, this.gameObject.getY()),
                    new ImageDrawer("resources/star.png"));
            bulletManager.add(bulletController);
            count = 0;
            Utils.playSound("resources/shootsound.wav", false);
            //System.out.println("ban");
        }
    }

    public void moveLeft(){
        this.gameInput.keyA = true;
        this.gameVector.dy = 0;
    }

    public void moveRight(){
        this.gameInput.keyD = true;
        this.gameVector.dy = 0;
    }
    public void moveUp(){
        this.gameInput.keyW = true;
        this.gameVector.dx = 0;
    }

    public void stopLeft(){
        this.gameInput.keyA = false;
    }

    public void stopRight(){
        this.gameInput.keyD = false;
    }

    public void setGameInput(GameInput gameInput) {
        this.gameInput = gameInput;
    }
}
