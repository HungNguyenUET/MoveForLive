package Controller.Gift;

import Controller.Colliable;
import Controller.CollisionPool;
import Controller.PlayerScene1.PlayerController21;
import Controller.SingleController;
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
        if(gameObject.getY() > 600) {
            gameObject.destroy();
        }
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof PlayerController21) {
            this.getGameObject().destroy();
        }
    }
    public static GiftController create(int x, int y, GiftState giftState){
        GiftController giftController = null;
        switch (giftState) {
            case SCENE1:
                giftController = new GiftController(new Gift(x, y), new ImageDrawer("resources/heart.png"));
                /* TODO: */
                break;
            case SCENE2:
                giftController = new GiftController(new Gift(x, y), new ImageDrawer("resources/heart.png"));
                /* TODO: */
                break;
        }
        return giftController;
    }
}
