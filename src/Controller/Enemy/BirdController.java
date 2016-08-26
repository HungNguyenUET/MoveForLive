package Controller.Enemy;

import Controller.Colliable;
import Controller.CollisionPool;
import Controller.SingleController;
import Model.GameObject;
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
        this.gameVector.dy += SPEED;
        CollisionPool.instance.add(this);

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

    }
}
