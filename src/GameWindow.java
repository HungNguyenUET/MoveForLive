import GameScene.GameManager;
import GameScene.MenuGameScene;
import Model.GameSetting;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

/**
 * Created by HungNguyen on 8/27/2016.
 */
public class GameWindow extends Frame implements Runnable {
    Thread thread;
    BufferedImage bufferedImage;
    Graphics bufferedImageGraphics;
    GameSetting gameSetting;
    KeyListener keyListener;
    MouseListener mouseListener;

    public GameWindow(){
        //Setup window game
        configUI();
        GameManager.getInstance().getStackScreen().push(new MenuGameScene());
        this.bufferedImage = new BufferedImage(gameSetting.getScreenWidth(),
                gameSetting.getScreenHeight(), BufferedImage.TYPE_INT_ARGB);
        this.bufferedImageGraphics = bufferedImage.getGraphics();
        keyListener = GameManager.getInstance().getStackScreen().peek().getKeyListener();
        mouseListener = GameManager.getInstance().getStackScreen().peek().getMouseListenr();
        this.addKeyListener(keyListener);
        this.addMouseListener(mouseListener);
        thread = new Thread(this);
        thread.start();
    }

    private void configUI(){
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
        //super.update(g);
        GameManager.getInstance().getStackScreen().peek().draw(bufferedImageGraphics);
        g.drawImage(bufferedImage, 0, 0, null);
    }

    @Override
    public void run() {
        while (true){
            try {
                GameManager.getInstance().getStackScreen().peek().run();
                keyListener = GameManager.getInstance().getStackScreen().peek().getKeyListener();
                this.addKeyListener(keyListener);
                Thread.sleep(gameSetting.getThreadDelay());
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
