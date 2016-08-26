package Controller.Weapon;

import Controller.Colliable;
import Controller.CollisionPool;
import Controller.Player.PlayerController;
import Controller.Player.PlayerController2;
import Controller.SingleController;
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
        if (gameObject.getY() > 625 && gameObject.getX() <= 650) {
            gameObject.destroy();
            if(PlayerController.instance.gameObject.getHp() == 0){
                PlayerController.instance.getGameObject().setPoint(PlayerController.instance.gameObject.getPoint());
            } else
                PlayerController.instance.getGameObject().setPoint(PlayerController.instance.gameObject.getPoint() + 1);

        }

        if (gameObject.getY() > 625 && gameObject.getX() <= 1300 && gameObject.getX() > 700) {
            gameObject.destroy();
            if(PlayerController2.instance.gameObject.getHp() == 0){
                PlayerController2.instance.getGameObject().setPoint(PlayerController2.instance.gameObject.getPoint());
            } else
                PlayerController2.instance.getGameObject().setPoint(PlayerController2.instance.gameObject.getPoint() + 1);
        }

    }

    @Override
    public void onCollide(Colliable colliable) {

    }
}
