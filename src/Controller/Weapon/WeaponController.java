package Controller.Weapon;

import Controller.Colliable;
import Controller.CollisionPool;
import Controller.PlayerScene1.PlayerController11;
import Controller.PlayerScene1.PlayerController12;
import Controller.PlayerScene2.PlayerController21;
import Controller.PlayerScene2.PlayerController22;
import Controller.SingleController;
import GameScene.GameManager;
import Model.Weapon;
import View.GameDrawer;
import View.ImageDrawer;

/**
 * Created by giaqu on 8/14/2016.
 */
public class WeaponController extends SingleController implements Colliable {

    public static final int SPEED = 5;
    public static final int FOLLOW_SPEED = 2;

    public WeaponController(Weapon gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        //this.gameVector.dy += SPEED;
        CollisionPool.instance.add(this);
    }

    @Override
    public void run() {
        super.run();
        switch (GameManager.getInstance().getStackScreen().peek().getStt()) {
            case 1:
                if (gameObject.getY() > 600 && gameObject.getX() <= 500) {
                    gameObject.destroy();
                    if (PlayerController11.instance.gameObject.getHp() == 0) {
                        PlayerController11.instance.getGameObject().setPoint(PlayerController11.instance.gameObject.getPoint());
                    } else
                        PlayerController11.instance.getGameObject().setPoint(PlayerController11.instance.gameObject.getPoint() + 1);
                }

                if (gameObject.getY() > 600 && gameObject.getX() <= 1000 && gameObject.getX() > 600) {
                    gameObject.destroy();
                    if (PlayerController12.instance.gameObject.getHp() == 0) {
                        PlayerController12.instance.getGameObject().setPoint(PlayerController12.instance.gameObject.getPoint());
                    } else
                        PlayerController12.instance.getGameObject().setPoint(PlayerController12.instance.gameObject.getPoint() + 1);

                }
                break;
            case 2:
                if (gameObject.getX() < 1000 && gameObject.getY() < 300) {
                    gameObject.destroy();
                    if (PlayerController21.instance.gameObject.getHp() == 0) {
                        PlayerController21.instance.getGameObject().setPoint(PlayerController21.instance.gameObject.getPoint());
                    } else
                        PlayerController21.instance.getGameObject().setPoint(PlayerController21.instance.gameObject.getPoint() + 1);
                }
                if (gameObject.getX() < 50 && gameObject.getY() < 300) {
                    gameObject.destroy();
                    if (PlayerController21.instance.gameObject.getHp() == 0) {
                        PlayerController21.instance.getGameObject().setPoint(PlayerController21.instance.gameObject.getPoint());
                    } else
                        PlayerController21.instance.getGameObject().setPoint(PlayerController21.instance.gameObject.getPoint() + 1);
                }

                if (gameObject.getX() < 1000 && gameObject.getY() > 300 && gameObject.getY() < 600) {
                    gameObject.destroy();
                    if (PlayerController22.instance.gameObject.getHp() == 0) {
                        PlayerController22.instance.getGameObject().setPoint(PlayerController22.instance.gameObject.getPoint());
                    } else
                        PlayerController22.instance.getGameObject().setPoint(PlayerController22.instance.gameObject.getPoint() + 1);

                }
                break;
        }
    }

    public static WeaponController create(int x, int y, WeaponStateShot weaponStateShot){
        WeaponController weaponController = null;
        switch (GameManager.getInstance().getStackScreen().peek().getStt()) {
            case 2:
                switch (weaponStateShot) {
                    case STRAIGHT:

                            weaponController = new WeaponController(new Weapon(x, y), new ImageDrawer("resources/sword_left.png"));
                            weaponController.gameVector.dx = +SPEED;


                            weaponController = new WeaponController(new Weapon(x, y), new ImageDrawer("resources/sword_left.png"));
                            weaponController.gameVector.dx = -SPEED;

                        break;
                    case FOLLOWED1:
                        weaponController = new WeaponController(new Weapon(x, y), new ImageDrawer("resources/follow_sword_left.png"));
                        int dx1 = PlayerController21.instance.getGameObject().getX() - weaponController.gameObject.getX();
                        int dy1 = PlayerController21.instance.getGameObject().getY() - weaponController.gameObject.getY();
                        if (dx1 > 0) {
                            double ratio = Math.sqrt(dx1 * dx1 + dy1 * dy1) / FOLLOW_SPEED;
                            weaponController.getGameVector().dy = (int) (dy1 / ratio);
                            weaponController.getGameVector().dx = (int) (dx1 / ratio);
                            WeaponManager.instance.add(weaponController);
                        }
                        break;
                    case FOLLOWED2:
                        weaponController = new WeaponController(new Weapon(x, y), new ImageDrawer("resources/follow_sword_right.png"));
                        int dx2 = PlayerController22.instance.getGameObject().getX() - weaponController.gameObject.getX();
                        int dy2 = PlayerController22.instance.getGameObject().getY() - weaponController.gameObject.getY();
                        if (dx2 > 0) {
                            double ratio = Math.sqrt(dx2 * dx2 + dy2 * dy2) / FOLLOW_SPEED;
                            weaponController.getGameVector().dy = (int) (dy2 / ratio);
                            weaponController.getGameVector().dx = (int) (dx2 / ratio);
                            WeaponManager.instance.add(weaponController);
                        }
                        /* TODO: */
                        break;
                }
            case 1:
                switch (weaponStateShot) {
                    case STRAIGHT:
                        weaponController = new WeaponController(new Weapon(x, y), new ImageDrawer("resources/sword.png"));
                        weaponController.gameVector.dy = SPEED;
                        /* TODO: */
                        break;
                    case FOLLOWED1:
                        weaponController = new WeaponController(new Weapon(x, y), new ImageDrawer("resources/follow_sword.png"));
                        int dx1 = PlayerController11.instance.getGameObject().getX() - weaponController.gameObject.getX();
                        int dy1 = PlayerController11.instance.getGameObject().getY() - weaponController.gameObject.getY();
                        if (dy1 > 0) {
                            double ratio = Math.sqrt(dx1 * dx1 + dy1 * dy1) / FOLLOW_SPEED;
                            weaponController.getGameVector().dy = (int) (dy1 / ratio);
                            weaponController.getGameVector().dx = (int) (dx1 / ratio);
                            WeaponManager.instance.add(weaponController);
                        }
                        break;
                    case FOLLOWED2:
                        weaponController = new WeaponController(new Weapon(x, y), new ImageDrawer("resources/follow_sword.png"));
                        int dx2 = PlayerController12.instance.getGameObject().getX() - weaponController.gameObject.getX();
                        int dy2 = PlayerController12.instance.getGameObject().getY() - weaponController.gameObject.getY();
                        if (dy2 > 0) {
                            double ratio = Math.sqrt(dx2 * dx2 + dy2 * dy2) / FOLLOW_SPEED;
                            weaponController.getGameVector().dy = (int) (dy2 / ratio);
                            weaponController.getGameVector().dx = (int) (dx2 / ratio);
                            WeaponManager.instance.add(weaponController);
                        }
                        break;
                }

        }
        return weaponController;
    }
    @Override
    public void onCollide(Colliable colliable) {

    }
}

