package Controller.Player;

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
public class PlayerController2 extends SingleController implements Colliable {
    private static final int SPEED = 10;
    private static final int JUMP_SPEED = 5;
    private static final int ATK_SPEED = 3;
    private int count;
    private GameInput gameInput;
    private ControllerManager bulletManager;


    public PlayerController2(Player gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameInput = new GameInput();
        this.bulletManager = new ControllerManager();
        CollisionPool.instance.add(this);
        //PlayerControllerManager.instance.add(this);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        bulletManager.draw(g);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof WeaponController) {
            PlayerController2.instance.getGameObject().setHp(PlayerController2.instance.gameObject.getHp() - 1);
            colliable.getGameObject().destroy();
        }
        if (colliable instanceof EnemyController) {
            colliable.getGameObject().destroy();
            PlayerController2.instance.getGameObject().setHp(PlayerController2.instance.gameObject.getHp() - 1);
        }
        if (colliable instanceof BirdController) {
            colliable.getGameObject().destroy();
            PlayerController2.instance.getGameObject().setHp(PlayerController2.instance.gameObject.getHp() - 1);
        }
        if (colliable instanceof GiftController) {
            PlayerController2.instance.getGameObject().setHp(PlayerController2.instance.gameObject.getHp() + 2);
            colliable.getGameObject().destroy();
        }
        if(PlayerController2.instance.gameObject.getHp() == 0){
            this.getGameObject().destroy();
        }
    }



    @Override
    public void run() {
        count++;
        this.gameVector.dx = 0;
        if (gameInput.keyA && !gameInput.keyD) {
            this.gameVector.dx = -SPEED;
            if(this.gameObject.getX() < 750){
                this.gameObject.setX(750);
            }
        } else if (!gameInput.keyA && gameInput.keyD) {
            this.gameVector.dx = SPEED;
            if(this.gameObject.getX() > 1300){
                this.gameObject.setX(1300);
            }
        }else if (gameInput.keyW) {
            this.gameVector.dy = -JUMP_SPEED;
        }
        if (gameInput.keyG) {
            bulletrun2();
        }
        if(this.gameObject.getY() >= 600){
            this.gameObject.setY(600);

        }else if (this.gameObject.getY() == 450 ) {
            Utils.playSound("resources/jumpsound.wav", false);
            this.gameVector.dy = JUMP_SPEED;
            gameInput.keyW = false;
        }else if (gameObject.getX() <= 750) {
            this.gameVector.dx = 750;
        } else if ( gameObject.getX() >= 1300) {
            this.gameVector.dx = 1300;
        }
        this.getGameObject().moveTo(gameObject.getX() + gameVector.dx, gameObject.getY() + gameVector.dy);
        super.run();
        bulletManager.run();
    }

    public final static PlayerController2 instance = new PlayerController2(
            new Player(1050, 600),
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
