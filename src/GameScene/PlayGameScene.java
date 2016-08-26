package GameScene;

import Controller.CollisionPool;
import Controller.Dynamite.DynamiteManager;
import Controller.Enemy.BirdManager;
import Controller.Enemy.EnemyManager;
import Controller.Gift.GiftManager;
import Controller.Player.PlayerController;
import Controller.Player.PlayerController2;
import Controller.Player.PlayerControllerManager;
import Controller.Weapon.WeaponManager;
import Utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Created by Viet on 8/18/2016.
 */
public class PlayGameScene implements GameScene, KeyListener {
    private Image backgroud;
    private Image gameOver;
    public static GameSceneListener gameScenceListener;

    public PlayGameScene() {
        backgroud =  Utils.loadImage("resources/background.png");
        gameOver = Utils.loadImage("resources/gameover.png");
        Utils.playSound("resources/nhacnen.wav",true);
        reset();
    }



    private void reset(){
//        new PlayGameScene();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(backgroud, 0, 0, null);
        PlayerControllerManager.instance.draw(g);
        WeaponManager.instance.draw(g);
        EnemyManager.instance.draw(g);
        BirdManager.instance.draw(g);
        GiftManager.instance.draw(g);
        DynamiteManager.getInst().draw(g);
//        DemonManager.instance.draw(g);
        g.drawString("POINT: " + PlayerController.instance.getGameObject().getPoint(), 400, 50);
        g.drawString("HP: " + PlayerController.instance.getGameObject().getHp(), 50, 50);
        g.drawString("POINT: " + PlayerController2.instance.getGameObject().getPoint(), 1000, 50);
        g.drawString("HP: " + PlayerController2.instance.getGameObject().getHp(), 700, 50);
        if(PlayerController2.instance.gameObject.getHp() <= 0){
            g.drawImage(gameOver, 650, 150, null);
        }else if(PlayerController.instance.gameObject.getHp() <= 0){
            g.drawImage(gameOver, 150, 150, null);
        }
    }

    @Override
    public KeyListener getKeyListener() {
        return PlayerControllerManager.instance.getKeyListener();
    }

    @Override
    public MouseListener getMouseListener() {
        return null;
    }

    @Override
    public void setGameSceneListener(GameSceneListener gameSceneListener) {
        this.gameScenceListener = gameSceneListener;
    }


    @Override
    public void run() {
        PlayerControllerManager.instance.run();
        WeaponManager.instance.run();
        EnemyManager.instance.run();
        CollisionPool.instance.run();
        BirdManager.instance.run();
        GiftManager.instance.run();
        DynamiteManager.getInst().run();
//        DemonManager.instance.run();
    }

    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_P) {
            gameScenceListener.changeGameScene(new PauseGameScene(), true);
            System.out.println("a");
        }
    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
