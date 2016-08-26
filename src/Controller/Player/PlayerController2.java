package Controller.Player;

import Controller.Colliable;
import Controller.CollisionPool;
import Controller.Enemy.EnemyController;
import Controller.GameInput;
import Controller.Gift.GiftController;
import Controller.SingleController;
import Controller.Weapon.WeaponController;
import Model.Player;
import View.GameDrawer;
import View.ImageDrawer;

import java.awt.*;

/**
 * Created by Viet on 8/19/2016.
 */
public class PlayerController2 extends SingleController implements Colliable {
    private static final int SPEED = 10;
    private static final int JUMP_SPEED = 5;
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
        if (colliable instanceof WeaponController) {
            PlayerController2.instance.getGameObject().setHp(PlayerController2.instance.gameObject.getHp() - 1);
            colliable.getGameObject().destroy();
        }
        if (colliable instanceof EnemyController) {
            colliable.getGameObject().destroy();
            PlayerController2.instance.getGameObject().setHp(PlayerController2.instance.gameObject.getHp() - 1);
        }
        if (colliable instanceof GiftController) {
            PlayerController2.instance.getGameObject().setHp(PlayerController2.instance.gameObject.getHp() + 5);
            colliable.getGameObject().destroy();
        }
        if(PlayerController2.instance.gameObject.getHp() == 0){
            this.getGameObject().destroy();
            if (colliable instanceof WeaponController || colliable instanceof EnemyController || colliable instanceof GiftController) {
                PlayerController2.instance.getGameObject().setHp(0);
                PlayerController2.instance.getGameObject().setPoint(PlayerController2.instance.gameObject.getPoint() + 0);
                colliable.getGameObject().destroy();
            }
        }
    }



    @Override
    public void run() {
//        count++;
        this.gameVector.dx = 0;
        if (gameInput.keyA && !gameInput.keyD) {
            this.gameVector.dx = -SPEED;
            if(this.gameObject.getX() < 700){
                this.gameObject.setX(700);
            }
        } else if (!gameInput.keyA && gameInput.keyD) {
            this.gameVector.dx = SPEED;
            if(this.gameObject.getX() > 1350){
                this.gameObject.setX(1350);
            }
        }else if (gameInput.keyW) {
            this.gameVector.dy = -JUMP_SPEED;
        }

        if (gameObject.getX() <= 700) {
            this.gameVector.dx = 700;
        }else if (this.gameObject.getY() == 500 ) {
            this.gameVector.dy = JUMP_SPEED;
            gameInput.keyW = false;
        }else if(this.gameObject.getY() >= 600){
            this.gameObject.setY(600);
        } else if ( gameObject.getX() >= 1350) {
            this.gameVector.dx = 1350;
        }
        this.getGameObject().moveTo(gameObject.getX() + gameVector.dx, gameObject.getY() + gameVector.dy);
        super.run();
    }

    public final static PlayerController2 instance = new PlayerController2(
            new Player(1050, 600),
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
