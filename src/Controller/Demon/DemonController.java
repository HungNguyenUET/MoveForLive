package Controller.Demon;

import Controller.Colliable;
import Controller.CollisionPool;
import Controller.ControllerManager;
import Controller.SingleController;
import Model.GameObject;
import View.GameDrawer;

/**
 * Created by Viet on 8/26/2016.
 */
public class DemonController extends SingleController implements Colliable {

    public DemonController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.instance.add(this);

    }

    @Override
    public void onCollide(Colliable colliable) {

    }
}
