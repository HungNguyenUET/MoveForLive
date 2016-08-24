import Controller.CollisionPool;
import Controller.EnemyManager;
import Controller.PlayerController;
import Controller.WeaponManager;
import Model.GameSetting;
import Utils.Utils;
import gamescence.GameScence;
import gamescence.GameScenceListener;
import gamescence.MenuGameScence;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

/**
 * Created by giaqu on 8/14/2016.
 */
public class GameWindow extends Frame implements Runnable, GameScenceListener{

    BufferedImage bufferedImage;
    Graphics bufferedImageGraphics;
    Thread thread;
    GameScence currentGameScence;
    GameSetting gameSetting;

    public GameWindow(){
        configUI();
        changeGameScence(new MenuGameScence());
        this.bufferedImage = new BufferedImage(gameSetting.getScreenWidth(),gameSetting.getScreenHeight(), BufferedImage.TYPE_INT_ARGB);
        this.bufferedImageGraphics = bufferedImage.getGraphics();
        thread = new Thread(this);
        thread.start();
    }
    private void configUI() {
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("Window Opened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Window Closing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        gameSetting = GameSetting.getInstance();
        this.setVisible(true);
        this.setLocation(0, 0);
        this.setSize(gameSetting.getScreenWidth(), gameSetting.getScreenHeight());
    }

    @Override
    public void update(Graphics g) {
        this.currentGameScence.draw(bufferedImageGraphics);
        g.drawImage(bufferedImage, 0, 0, null);
    }

    @Override
    public void run() {
        while (true){
            try {
                this.currentGameScence.run();
                Thread.sleep(gameSetting.getThreadDelay());
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void changeGameScence(GameScence gameScence) {
        currentGameScence = gameScence;
        currentGameScence.setGameSceneListener(this);
        this.addKeyListener(gameScence.getKeyListener());
    }
}
