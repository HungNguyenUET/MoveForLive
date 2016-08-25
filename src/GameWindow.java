import GameScene.GameScene;
import GameScene.GameSceneListener;
import GameScene.MenuGameScene;
import Model.GameSetting;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Stack;

/**
 * Created by giaqu on 8/14/2016.
 */
public class GameWindow extends Frame implements Runnable, GameSceneListener {

    BufferedImage bufferedImage;
    Graphics bufferedImageGraphics;
    Thread thread;
    GameScene currentGameScene;
    GameSetting gameSetting;

    private Stack<GameScene> stack;

    public GameWindow(){
        //Setup window game
        configUI();
        stack = new Stack<GameScene>();
        //Mo man hinh Menu Game
        changeGameScene(new MenuGameScene(), false);
        this.bufferedImage = new BufferedImage(gameSetting.getScreenWidth(),
                gameSetting.getScreenHeight(), BufferedImage.TYPE_INT_ARGB);
        this.bufferedImageGraphics = bufferedImage.getGraphics();
        //Tao luong
        thread = new Thread(this);
        thread.start();

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    GameWindow.this.back();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

            private void back() {

            }
        });

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
        this.currentGameScene.draw(bufferedImageGraphics);
        g.drawImage(bufferedImage, 0, 0, null);
    }

    @Override
    public void run() {
        while (true){
            try {
                this.currentGameScene.run();
                Thread.sleep(gameSetting.getThreadDelay());
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    @Override
    public void changeGameScene(GameScene gameScene, boolean addToStack) {
        if(currentGameScene != null && addToStack) {
            this.removeKeyListener(currentGameScene.getKeyListener());
            this.stack.push(currentGameScene);
        }
        currentGameScene = gameScene;
        currentGameScene.setGameSceneListener(this);
        this.addKeyListener(currentGameScene.getKeyListener());
    }

    @Override
    public void back() {
        if(!stack.isEmpty()) {
            this.removeKeyListener(currentGameScene.getKeyListener());
            currentGameScene = stack.pop();
            currentGameScene.setGameSceneListener(this);
            this.addKeyListener(currentGameScene.getKeyListener());
        } else {
            //System.exit(0);
        }
    }
}


