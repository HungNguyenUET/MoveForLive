package Controller;

import Model.Weapon;
import View.GameDrawer;

/**
 * Created by giaqu on 8/14/2016.
 */
public class WeaponController extends SingleController implements Colliable {

    public static final int SPEED = 5;

    public WeaponController(Weapon gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy += SPEED;
        CollisionPool.instance.add(this);
    }

    @Override
    public void run() {
        super.run();
        if (gameObject.getY() > 800) {
            gameObject.destroy();
            PlayerController.playerController.getGameObject().setPoint(PlayerController.playerController.gameObject.getPoint() + 1);
        }

    }

    @Override
    public void onCollide(Colliable colliable) {

    }
}
