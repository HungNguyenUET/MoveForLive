package GameScene;

import Controller.CollisionPool;
import Controller.Dynamite.DynamiteManager;
import Controller.Enemy.BirdManager;
import Controller.Enemy.EnemyManager;
import Controller.GameInput;
import Controller.Gift.GiftManager;
import Controller.PlayerScene2.PlayerController21;
import Controller.PlayerScene2.PlayerController22;
import Controller.PlayerScene2.PlayerControllerManager2;
import Controller.Weapon.WeaponManager;
import Utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Created by giaqu on 8/27/2016.
 */
public class PlayGameScene2 implements Scene, KeyListener {
    private Image backgroud;
    private Image gameOver;

    public int getStt() {
        return stt;
    }

    private final int stt = 2;

    public PlayGameScene2() {
        backgroud =  Utils.loadImage("resources/background2.png");
        gameOver = Utils.loadImage("resources/gameover.png");
        Utils.playSound("resources/nhacnen.wav",true);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(backgroud, 0, 0, null);
        PlayerControllerManager2.instance.draw(g);
        WeaponManager.instance.draw(g);
        EnemyManager.instance.draw(g);
        BirdManager.instance.draw(g);
        GiftManager.instance.draw(g);
        DynamiteManager.getInst().draw(g);
//        DemonManager.instance.draw(g);
        g.drawString("POINT: " + PlayerController21.instance.getGameObject().getPoint(), 400, 50);
        g.drawString("HP: " + PlayerController21.instance.getGameObject().getHp(), 50, 50);
        g.drawString("POINT: " + PlayerController22.instance.getGameObject().getPoint(), 1000, 50);
        g.drawString("HP: " + PlayerController22.instance.getGameObject().getHp(), 700, 50);
        if(PlayerController22.instance.gameObject.getHp() <= 0){
            g.drawImage(gameOver, 650, 150, null);
        }
        if(PlayerController21.instance.gameObject.getHp() <= 0){
            g.drawImage(gameOver, 150, 150, null);
        }
    }

    @Override
    public void run() {
        PlayerControllerManager2.instance.run();
        WeaponManager.instance.run();
        EnemyManager.instance.run();
        CollisionPool.instance.run();
        BirdManager.instance.run();
        GiftManager.instance.run();
        DynamiteManager.getInst().run();
    }

    @Override
    public KeyListener getKeyListener() {
        return this;
    }

    @Override
    public MouseListener getMouseListenr() {
        return null;
    }

    @Override
    public void setGameInput(GameInput gameInput) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
