package Controller.Enemy;

import Controller.Colliable;
import Controller.CollisionPool;
import Controller.SingleController;
import Model.Enemy;
import View.GameDrawer;

/**
 * Created by giaqu on 8/14/2016.
 */
public class EnemyController extends SingleController implements Colliable {

    public EnemyController(Enemy gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        if(this.getGameObject().getX() == 0 || this.getGameObject().getX() == 500)
            this.gameVector.dx += 3;
        CollisionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (gameObject.getX() >= 450) {
            gameObject.destroy();
        }

        if ( gameObject.getX() <= 1000 && gameObject.getX() > 500) {
            gameObject.destroy();
        }

    }
}
