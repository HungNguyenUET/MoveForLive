package Controller.Demon;

import Controller.Colliable;
import Controller.CollisionPool;
import Controller.SingleController;
import Model.Demon;
import View.GameDrawer;

/**
 * Created by Viet on 8/26/2016.
 */
public class DemonController extends SingleController implements Colliable {

    public static final int SPEED = 5;

    public DemonController(Demon gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.instance.add(this);

    }

    @Override
    public void run() {
        super.run();
        if(this.getGameObject().getX() == 50) {
            this.gameVector.dx += SPEED;
        }
        if(this.getGameObject().getX() == 1250) {
            this.gameVector.dx -= SPEED;
        }
    }

    @Override
    public void onCollide(Colliable colliable) {

    }
}
