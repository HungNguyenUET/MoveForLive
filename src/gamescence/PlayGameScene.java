package gamescence;

import Controller.*;
import Controller.Gift.GiftManager;
import Utils.Utils;

import java.awt.*;
import java.awt.event.KeyListener;

/**
 * Created by Viet on 8/18/2016.
 */
public class PlayGameScene implements GameScence {
    private Image backgroud;
    private GameScenceListener gameScenceListener;

    public PlayGameScene() {
        backgroud =  Utils.loadImage("resources/2dbackground.jpg");

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(backgroud, 0, 0, null);
        //PlayerController.instance.draw(g);
        //PlayerController2.instance.draw(g);
        PlayerControllerManager.instance.draw(g);
        WeaponManager.instance.draw(g);
        EnemyManager.instance.draw(g);
        BirdManager.instance.draw(g);
        GiftManager.instance.draw(g);
        g.drawString("POINT: " + PlayerController.instance.getGameObject().getPoint(), 400, 50);
        g.drawString("HP: " + PlayerController.instance.getGameObject().getHp(), 50, 50);
        g.drawString("POINT: " + PlayerController2.instance.getGameObject().getPoint(), 900, 50);
        g.drawString("HP: " + PlayerController2.instance.getGameObject().getHp(), 600, 50);

    }

    @Override
    public KeyListener getKeyListener() {
        return PlayerControllerManager.instance.getKeyListener();
    }

    @Override
    public void setGameSceneListener(GameScenceListener gameSceneListener) {
        this.gameScenceListener = gameSceneListener;
    }


    @Override
    public void run() {
        //PlayerController.instance.run();
        //PlayerController2.instance.run();
        PlayerControllerManager.instance.run();
        WeaponManager.instance.run();
        EnemyManager.instance.run();
        CollisionPool.instance.run();
        BirdManager.instance.run();
        GiftManager.instance.run();
    }
}
