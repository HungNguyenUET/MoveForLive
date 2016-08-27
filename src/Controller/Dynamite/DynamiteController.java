package Controller.Dynamite;

import Controller.Colliable;
import Controller.CollisionPool;
import Controller.Enemy.EnemyManager;
import Controller.ExplosionController;
import Controller.PlayerScene1.PlayerController11;
import Controller.PlayerScene1.PlayerController12;
import Controller.PlayerScene2.PlayerController21;
import Controller.PlayerScene2.PlayerController22;
import Controller.SingleController;
import Model.Dynamite;
import Model.Explosion;
import Model.GameObject;
import Model.GameSetting;
import Utils.Utils;
import View.AnimationDrawer;
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
            ExplosionController explosionController = new ExplosionController(
                    new Explosion(this.gameObject.getX(),this.gameObject.getY()),
                    new AnimationDrawer( Utils.loadImages(
                            "resources/fire_1.png",
                            "resources/fire_2.png",
                            "resources/fire_3.png",
                            "resources/fire_4.png",
                            "resources/fire_5.png",
                            "resources/fire_6.png",
                            "resources/fire_7.png",
                            "resources/fire_8.png"))
            );
            EnemyManager.instance.add(explosionController);
            int dynamiteCenterX = this.gameObject.getX() + this.gameObject.getWidth() / 2;
            int dynamiteCenterY = this.gameObject.getY() + this.gameObject.getHeight() / 2;
            int playerCenterX = PlayerController11.instance.gameObject.getX() + PlayerController11.instance.gameObject.getWidth() / 2;
            int playerCenterY = PlayerController11.instance.gameObject.getY() + PlayerController11.instance.gameObject.getHeight() / 2;
            double R = Math.sqrt((dynamiteCenterX - playerCenterX) * (dynamiteCenterX - playerCenterX) + (dynamiteCenterY - playerCenterY) * (dynamiteCenterY - playerCenterY));
            if(R <= DYNAMITE_RADIUS) {
                if(PlayerController11.instance.gameObject.getHp() <= 0){
                    PlayerController11.instance.getGameObject().setPoint(PlayerController11.instance.gameObject.getPoint());
                } else
                    PlayerController11.instance.gameObject.setHp(PlayerController11.instance.gameObject.getHp() - 1);
            }
        }
    }

    @Override
    public void onCollide(Colliable c) {
        if (c instanceof PlayerController11) {
            Utils.playSound("resources/explosion.wav", false);
            if(PlayerController11.instance.gameObject.getHp() <= 0){
                PlayerController11.instance.getGameObject().setPoint(PlayerController11.instance.gameObject.getPoint());
            } else
                PlayerController11.instance.getGameObject().setPoint(PlayerController11.instance.gameObject.getPoint() - 1);
        }
        if (c instanceof PlayerController12) {
            Utils.playSound("resources/explosion.wav", false);
            if(PlayerController12.instance.gameObject.getHp() <= 0){
                PlayerController12.instance.getGameObject().setPoint(PlayerController12.instance.gameObject.getPoint());
            } else
                PlayerController12.instance.gameObject.setHp(PlayerController12.instance.gameObject.getHp() - 1);
        }
        if (c instanceof PlayerController21) {
            Utils.playSound("resources/explosion.wav", false);
            if(PlayerController21.instance.gameObject.getHp() <= 0){
                PlayerController21.instance.getGameObject().setPoint(PlayerController21.instance.gameObject.getPoint());
            } else
                PlayerController21.instance.gameObject.setHp(PlayerController21.instance.gameObject.getHp() - 1);
        }
        if (c instanceof PlayerController22) {
            Utils.playSound("resources/explosion.wav", false);
            if(PlayerController22.instance.gameObject.getHp() <= 0){
                PlayerController22.instance.getGameObject().setPoint(PlayerController22.instance.gameObject.getPoint());
            } else
                PlayerController22.instance.gameObject.setHp(PlayerController22.instance.gameObject.getHp() - 1);
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
