package Controller;

import Controller.Enemy.EnemyController;
import Model.GameObject;
import View.GameDrawer;

/**
 * Created by Viet on 8/19/2016.
 */
public class StarController extends SingleController implements Colliable {

    private static final int SPEED = 10;

    public StarController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dx = -SPEED;
        CollisionPool.instance.add(this);
    }

    @Override
    public void run() {
        super.run();
        if(gameObject.getX() < 0) {
            gameObject.destroy();
        }
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof EnemyController) {
//            Star star = (Star)gameObject;
            this.getGameObject().destroy();
        }
    }
}