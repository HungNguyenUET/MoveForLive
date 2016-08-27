package Controller.Gift;

import Controller.Colliable;
import Controller.CollisionPool;
import Controller.PlayerScene1.PlayerController11;
import Controller.PlayerScene1.PlayerController12;
import Controller.PlayerScene2.PlayerController21;
import Controller.PlayerScene2.PlayerController22;
import Controller.SingleController;
import GameScene.GameManager;
import Model.Gift;
import View.GameDrawer;
import View.ImageDrawer;

import java.util.Random;

/**
 * Created by Minh on 8/24/2016.
 */
public class GiftController extends SingleController implements Colliable {
    private static final int SPEED_Y = 10;
    private static final int SPEED_X = 5;
    private Random rand = new Random();

    public GiftController(Gift gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = SPEED_Y;
        int random = rand.nextInt(2);
        if (random == 1){
            this.gameVector.dx = SPEED_X;
        }else{
            this.gameVector.dx = -SPEED_X;
        }

        CollisionPool.instance.add(this);
    }

    @Override
    public void run() {
        super.run();
        switch (GameManager.getInstance().getStackScreen().peek().getStt()) {
            case 1:
                if(gameObject.getY() > 600) {
                    gameObject.destroy();
                }
                break;
            case 2:
                if(gameObject.getX() < 0 || gameObject.getX() > 1000){
                    gameObject.destroy();
                }
                break;
        }
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof PlayerController11) {
            this.getGameObject().destroy();
            if(PlayerController11.instance.gameObject.getHp() > 5){
                PlayerController11.instance.gameObject.setHp(5);
            }
        }
        if (colliable instanceof PlayerController12) {
            this.getGameObject().destroy();
            if(PlayerController12.instance.gameObject.getHp() > 5){
                PlayerController12.instance.gameObject.setHp(5);
            }
        }
        if (colliable instanceof PlayerController21) {
            this.getGameObject().destroy();
            if(PlayerController21.instance.gameObject.getHp() > 5){
                PlayerController21.instance.gameObject.setHp(5);
            }
        }
        if (colliable instanceof PlayerController22) {
            this.getGameObject().destroy();
            if(PlayerController22.instance.gameObject.getHp() > 5){
                PlayerController22.instance.gameObject.setHp(5);
            }
        }
    }
    public static GiftController create(int x, int y){
        GiftController giftController = null;
        switch (GameManager.getInstance().getStackScreen().peek().getStt()) {
            case 1:
                giftController = new GiftController(new Gift(x, y), new ImageDrawer("resources/heart.png"));
                /* TODO: */
                break;
            case 2:
                giftController = new GiftController(new Gift(x, y), new ImageDrawer("resources/heart.png"));
                /* TODO: */
                break;
        }
        return giftController;
    }
}
