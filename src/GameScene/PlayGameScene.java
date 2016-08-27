package GameScene;

import Controller.CollisionPool;
import Controller.Dynamite.DynamiteManager;
import Controller.Enemy.BirdManager;
import Controller.Enemy.EnemyManager;
import Controller.GameInput;
import Controller.Gift.GiftManager;
import Controller.PlayerScene1.PlayerController11;
import Controller.PlayerScene1.PlayerController12;
import Controller.PlayerScene1.PlayerControllerManager1;
import Controller.Weapon.WeaponManager;
import Utils.Utils;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Created by HungNguyen on 8/27/2016.
 */
public class PlayGameScene implements Scene {
    private Image backgroud;
    private Image gameOver;
    GameInput gameInput;

    public PlayGameScene(){
        backgroud =  Utils.loadImage("resources/background.png");
        gameOver = Utils.loadImage("resources/gameover.png");
        gameInput = new GameInput();
        Utils.playSound("resources/nhacnen.wav",true);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(backgroud, 0, 0, null);
        PlayerControllerManager1.instance.draw(g);
        WeaponManager.instance.draw(g);
        EnemyManager.instance.draw(g);
        BirdManager.instance.draw(g);
        GiftManager.instance.draw(g);
        DynamiteManager.getInst().draw(g);
//        DemonManager.instance.draw(g);
        g.drawString("POINT: " + PlayerController11.instance.getGameObject().getPoint(), 400, 50);
        g.drawString("HP: " + PlayerController11.instance.getGameObject().getHp(), 50, 50);
        g.drawString("POINT: " + PlayerController12.instance.getGameObject().getPoint(), 1000, 50);
        g.drawString("HP: " + PlayerController12.instance.getGameObject().getHp(), 700, 50);
        if(PlayerController12.instance.gameObject.getHp() <= 0){
            g.drawImage(gameOver, 650, 150, null);
        }else if(PlayerController11.instance.gameObject.getHp() <= 0){
            g.drawImage(gameOver, 150, 150, null);
        }
    }

    @Override
    public void run() {
        PlayerControllerManager1.instance.run();
        WeaponManager.instance.run();
        EnemyManager.instance.run();
        CollisionPool.instance.run();
        BirdManager.instance.run();
        GiftManager.instance.run();
        DynamiteManager.getInst().run();
    }

    @Override
    public KeyListener getKeyListener() {
        return PlayerControllerManager1.instance.getKeyListener();
    }

    @Override
    public MouseListener getMouseListenr() {
        return null;
    }

    @Override
    public void setGameInput(GameInput gameInput) {

    }
}
