package Controller.Dynamite;

import Controller.Colliable;
import Controller.CollisionPool;
import Controller.PlayerScene1.PlayerController21;
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
            int playerCenterX = PlayerController21.instance.gameObject.getX() + PlayerController21.instance.gameObject.getWidth() / 2;
            int playerCenterY = PlayerController21.instance.gameObject.getY() + PlayerController21.instance.gameObject.getHeight() / 2;
            double R = Math.sqrt((dynamiteCenterX - playerCenterX) * (dynamiteCenterX - playerCenterX) + (dynamiteCenterY - playerCenterY) * (dynamiteCenterY - playerCenterY));
            if(R <= DYNAMITE_RADIUS) {
                PlayerController21.instance.gameObject.setHp(PlayerController21.instance.gameObject.getHp() - 1);
            }
        }
    }

    @Override
    public void onCollide(Colliable c) {
        if (c instanceof PlayerController21) {
            Utils.playSound("resources/explosion.wav", false);
            PlayerController21.instance.gameObject.setHp(PlayerController21.instance.gameObject.getHp() - 1);
        }
        if (c instanceof PlayerController12) {
            Utils.playSound("resources/explosion.wav", false);
            PlayerController12.instance.gameObject.setHp(PlayerController21.instance.gameObject.getHp() - 1);
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
    public static DynamiteController create(int x, int y, DynamiteState dynamiteState){
        DynamiteController dynamiteController = null;
        switch (dynamiteState) {
            case SCENE1:
                dynamiteController = new DynamiteController(new Dynamite(x, y), new ImageDrawer("resources/dynamite.png"));
                /* TODO: */
                break;
            case SCENE2:
                dynamiteController = new DynamiteController(new Dynamite(x, y), new ImageDrawer("resources/dynamite.png"));
                /* TODO: */
                break;
        }
        return dynamiteController;
    }
}
