package Controller.Enemy;

import Controller.BulletController;
import Controller.Colliable;
import Controller.CollisionPool;
import Controller.SingleController;
import Model.Bird;
import Model.GameObject;
import Utils.Utils;
import View.AnimationDrawer;
import View.GameDrawer;

import java.awt.*;

/**
 * Created by Viet on 8/24/2016.
 */
public class BirdController extends SingleController implements Colliable {
    private static final int SPEED = 5;

    public BirdController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.instance.add(this);
        this.gameVector.dy += SPEED;
    }


    @Override
    public void draw(Graphics g) {
        super.draw(g);
        if (gameDrawer instanceof AnimationDrawer) {
            if (((AnimationDrawer) gameDrawer).animationReachEnd()) {
                gameObject.destroy();
            }
        }
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof BulletController){
            this.getGameObject().destroy();
        }
    }
    public static BirdController create(int x, int y, BirdState birdState){
        BirdController birdController = null;
        switch (birdState) {
            case SCENE1:
                birdController = new BirdController(new Bird(x, y), new AnimationDrawer(Utils.loadFromSprite("resources/bird.png", true, 64, 64, 0, 0)));
                /* TODO: */
                break;
            case SCENE2:
                birdController = new BirdController(new Bird(x, y), new AnimationDrawer(Utils.loadFromSprite("resources/bird.png", true, 64, 64, 0, 0)));
                /* TODO: */
                break;
        }
            return birdController;
    }
}
