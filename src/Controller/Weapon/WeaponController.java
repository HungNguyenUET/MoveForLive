package Controller.Weapon;

import Controller.Colliable;
import Controller.CollisionPool;
import Controller.Player.PlayerController;
import Controller.Player.PlayerController2;
import Controller.SingleController;
import Model.Weapon;
import View.GameDrawer;
import View.ImageDrawer;

/**
 * Created by giaqu on 8/14/2016.
 */
public class WeaponController extends SingleController implements Colliable {

    public static final int SPEED = 4;
    public static final int FOLLOW_SPEED = 3;

    public WeaponController(Weapon gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        //this.gameVector.dy += SPEED;
        CollisionPool.instance.add(this);
    }

    @Override
    public void run() {
        super.run();
        if (gameObject.getY() > 600 && gameObject.getX() <= 500) {
            gameObject.destroy();
            if(PlayerController.instance.gameObject.getHp() == 0){
                PlayerController.instance.getGameObject().setPoint(PlayerController.instance.gameObject.getPoint());
            } else
                PlayerController.instance.getGameObject().setPoint(PlayerController.instance.gameObject.getPoint() + 1);
        }

        if (gameObject.getY() > 600 && gameObject.getX() <= 1000 && gameObject.getX() > 600) {
            gameObject.destroy();
            if(PlayerController2.instance.gameObject.getHp() == 0){
                PlayerController2.instance.getGameObject().setPoint(PlayerController2.instance.gameObject.getPoint());
            } else
                PlayerController2.instance.getGameObject().setPoint(PlayerController2.instance.gameObject.getPoint() + 1);;
        }

    }

    public static WeaponController create(int x, int y, WeaponBehavior weaponBehavior){
        WeaponController weaponController = null;
        switch (weaponBehavior){
            case STRAIGHT:
                weaponController = new WeaponController(new Weapon(x, y), new ImageDrawer("resources/sword.png"));
                weaponController.gameVector.dy = SPEED;
                break;
            case FOLLOWED1:
                weaponController = new WeaponController(new Weapon(x, y), new ImageDrawer("resources/follow_sword.png"));
                int dx1 = PlayerController.instance.getGameObject().getX() - weaponController.gameObject.getX();
                int dy1 = PlayerController.instance.getGameObject().getY() - weaponController.gameObject.getY();
                if (dy1 > 0) {
                    double ratio = Math.sqrt(dx1 * dx1 + dy1 * dy1) / FOLLOW_SPEED;
                    weaponController.getGameVector().dy = (int) (dy1 / ratio);
                    weaponController.getGameVector().dx = (int) (dx1 / ratio);
                    WeaponManager.instance.add(weaponController);
                }
                break;
            case FOLLOWED2:
                weaponController = new WeaponController(new Weapon(x, y), new ImageDrawer("resources/follow_sword.png"));
                int dx2 = PlayerController2.instance.getGameObject().getX() - weaponController.gameObject.getX();
                int dy2 = PlayerController2.instance.getGameObject().getY() - weaponController.gameObject.getY();
                if (dy2 > 0) {
                    double ratio = Math.sqrt(dx2 * dx2 + dy2 * dy2) / FOLLOW_SPEED;
                    weaponController.getGameVector().dy = (int) (dy2 / ratio);
                    weaponController.getGameVector().dx = (int) (dx2 / ratio);
                    WeaponManager.instance.add(weaponController);
                }
                break;
        }
        return weaponController;
    }
    @Override
    public void onCollide(Colliable colliable) {

    }
}
