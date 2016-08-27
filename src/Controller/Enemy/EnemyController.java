package Controller.Enemy;

import Controller.Colliable;
import Controller.CollisionPool;
import Controller.SingleController;
import GameScene.GameManager;
import Model.Enemy;
import View.GameDrawer;
import View.ImageDrawer;

/**
 * Created by giaqu on 8/14/2016.
 */
public class EnemyController extends SingleController implements Colliable {

    public EnemyController(Enemy gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        switch (GameManager.getInstance().getStackScreen().peek().getStt()) {
            case 1:
                if (this.getGameObject().getY() == 0 || this.getGameObject().getY() == 500 )
                    this.gameVector.dy += 3;
                if (this.getGameObject().getY() == 600 || this.getGameObject().getY() == 1000)
                    this.gameVector.dy += 3;
                break;
//            case 2:
//                if (this.getGameObject().getY() == 0 || this.getGameObject().getX() == 300)
//                    this.gameVector.dy += 3;
//                break;
        }
        CollisionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {
        switch (GameManager.getInstance().getStackScreen().peek().getStt()) {
            case 1:
                if (gameObject.getX() >= 500) {
                    gameObject.destroy();
                }

                if (gameObject.getX() < 50) {
                    gameObject.destroy();
                }

                if (gameObject.getX() <= 1000 && gameObject.getX() > 600) {
                    gameObject.destroy();
                }
                if (gameObject.getX() <= 600 && gameObject.getX() > 500) {
                    gameObject.destroy();
                }
                break;
//            case 2:
//                if (gameObject.getY() == 250) {
//                    gameObject.destroy();
//                }
//
//                if (gameObject.getY() == 600) {
//                    gameObject.destroy();
//                }
        }
    }
    public static EnemyController create(int x, int y){
        EnemyController enemyController = null;
        switch (GameManager.getInstance().getStackScreen().peek().getStt()) {
            case 1:
                enemyController = new EnemyController(new Enemy(x, y), new ImageDrawer("resources/star.png"));
                /* TODO: */
                break;
//            case 2:
//                enemyController = new EnemyController(new Enemy(x, y), new ImageDrawer("resources/star.png"));
//                /* TODO: */
//                break;

        }
        return enemyController;
    }
}
