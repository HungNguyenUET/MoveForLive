package Controller;

import Model.Bullet;
import Model.GameObject;
import View.GameDrawer;

/**
 * Created by Viet on 8/24/2016.
 */
public class BulletController extends SingleController implements Colliable {
    private static final int SPEED = 20;

    public BulletController(Bullet gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = -SPEED;
        CollisionPool.instance.add(this);
    }

    @Override
    public void run() {
        super.run();
        if (gameObject.getY() < 0) {
            gameObject.destroy();
        }
    }

    @Override
    public void onCollide(Colliable colliable) {

    }
}
