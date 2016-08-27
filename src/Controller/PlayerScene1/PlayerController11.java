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
 * Created by giaqu on 8/14/2016.
 */
public class PlayerController11 extends SingleController implements Colliable {

    private static final int SPEED = 10;
    private static final int JUMP_SPEED = 5;
    private static final int ATK_SPEED = 3;
    private int count;

    private static int x;
    private static int y;
    private GameInput gameInput;
    private ControllerManager bulletManager;


    private PlayerController11(Player player, GameDrawer gameDrawer) {
        super(player, gameDrawer);
        this.gameInput = new GameInput();
        this.bulletManager = new ControllerManager();
        CollisionPool.instance.add(this);
        //PlayerControllerManager1.instance.add(this);
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
        if (gameInput.keyA && !gameInput.keyD) {
            this.gameVector.dx = -SPEED;
            if(this.gameObject.getX() < 50){
                this.gameObject.setX(50);
            }
        } else if (!gameInput.keyA && gameInput.keyD) {
            this.gameVector.dx = SPEED;
            if(this.gameObject.getX() > 500){
                this.gameObject.setX(500);
            }
        }
        if (gameInput.keyW) {
            this.gameVector.dy = -JUMP_SPEED;
        }
//        if (gameInput.keyW && gameInput.keyA){
//            this.gameVector.dy -= JUMP_SPEED;
//            this.gameVector.dx -= SPEED;
//
//
//        } else if (gameInput.keyW && gameInput.keyD) {
//            this.gameVector.dy -= JUMP_SPEED;
//            this.gameVector.dx = SPEED;
//        }
//        } else if (gameInput.keyW && !gameInput.keyA){
//            this.gameVector.dy -= JUMP_SPEED;
//        } else if (!gameInput.keyW && gameInput.keyA){
//            this.gameVector.dx -= SPEED;
//        }
        if (gameInput.keySpace) {
             bulletrun();
        }
        if(this.gameObject.getY() >= 500){
            this.gameObject.setY(500);

        } else if (this.gameObject.getY() == 350 ) {
             Utils.playSound("resources/jumpsound.wav", false);
            this.gameVector.dy = JUMP_SPEED;
            gameInput.keyW = false;
        }
        else if (this.gameObject.getX() <= 50){
            this.gameObject.setX(50);
        }else if (this.gameObject.getX() >= 500){
            this.gameObject.setX(500);
        }
        super.run();
        bulletManager.run();
    }

    public static PlayerController11 instance = new PlayerController11(new Player(250, 500), new ImageDrawer("resources/ninja1.png"));

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof WeaponController) {
            PlayerController11.instance.getGameObject().setHp(PlayerController11.instance.gameObject.getHp() - 1);
            colliable.getGameObject().destroy();
        }
        if (colliable instanceof EnemyController) {
            colliable.getGameObject().destroy();
            PlayerController11.instance.getGameObject().setHp(PlayerController11.instance.gameObject.getHp() - 1);
        }
        if (colliable instanceof BirdController) {
            colliable.getGameObject().destroy();
        }
        if (colliable instanceof GiftController) {
            PlayerController11.instance.getGameObject().setHp(PlayerController11.instance.gameObject.getHp() + 2);
            colliable.getGameObject().destroy();
        }
        if(PlayerController11.instance.gameObject.getHp() <= 0){
            this.getGameObject().destroy();
            PlayerController11.instance.getGameObject().setHp(0);

        }
    }

    public void setGameInput(GameInput gameInput) {
        this.gameInput = gameInput;
    }

    private void bulletrun() {
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

}