package Controller.Dynamite;

import Controller.Colliable;
import Controller.CollisionPool;
import Controller.Player.PlayerController;
import Controller.Player.PlayerController2;
import Controller.SingleController;
import Model.Dynamite;
import Model.GameObject;
import Model.GameSetting;
import Utils.Utils;
import View.GameDrawer;
import View.ImageDrawer;

/**
 * Created by Linh on 8/27/2016.
 */
public class DynamiteController extends SingleController implements Colliable {
    private static final int SPEED = 5;
    private static final int DYNAMITE_RADIUS = 200;
    public DynamiteController(Dynamite gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = SPEED;
        CollisionPool.instance.add(this);
    }

    @Override
    public void run() {
        super.run();
        if(!GameSetting.getInstance().inScreen(this.gameObject)){
            this.gameObject.destroy();
        }
        if(this.getGameObject().getY() == 550){
            gameObject.destroy();
//            Utils.loadImage("resources/Explosion.png");
            Utils.playSound("resources/explosion.wav", false);
            int dynamiteCenterX = this.gameObject.getX() + this.gameObject.getWidth() / 2;
            int dynamiteCenterY = this.gameObject.getY() + this.gameObject.getHeight() / 2;
            int playerCenterX = PlayerController.instance.gameObject.getX() + PlayerController.instance.gameObject.getWidth() / 2;
            int playerCenterY = PlayerController.instance.gameObject.getY() + PlayerController.instance.gameObject.getHeight() / 2;
            double R = Math.sqrt((dynamiteCenterX - playerCenterX) * (dynamiteCenterX - playerCenterX) + (dynamiteCenterY - playerCenterY) * (dynamiteCenterY - playerCenterY));
            if(R <= DYNAMITE_RADIUS) {
                PlayerController.instance.gameObject.setHp(PlayerController.instance.gameObject.getHp() - 1);
            }
        }
    }

    @Override
    public void onCollide(Colliable c) {
        if (c instanceof PlayerController) {
            Utils.playSound("resources/explosion.wav", false);
            PlayerController.instance.gameObject.setHp(PlayerController.instance.gameObject.getHp() - 1);
        }
        if (c instanceof PlayerController2) {
            Utils.playSound("resources/explosion.wav", false);
            PlayerController2.instance.gameObject.setHp(PlayerController.instance.gameObject.getHp() - 1);
        }
    }
    public static DynamiteController create(int x, int y){
        DynamiteController dynamiteController = null;
        dynamiteController = new DynamiteController(new Dynamite(x, y), new ImageDrawer("resources/dynamite.png"));
        return dynamiteController;
    }

    @Override
    public GameObject getGameObject() {
        return super.getGameObject();
    }
}
