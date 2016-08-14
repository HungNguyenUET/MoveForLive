import Controller.CollisionPool;
import Controller.EnemyManager;
import Controller.PlayerController;
import Controller.WeaponManager;
import Utils.Utils;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

/**
 * Created by giaqu on 8/14/2016.
 */
public class GameWindow extends Frame implements Runnable{

    Image backGround;
    BufferedImage bufferedImage;
    Graphics bufferedImageGraphics;
    Thread thread;

    public GameWindow(){
        System.out.println("GameWindow Constructor");
        this.setVisible(true);
        this.setLocation(0, 0);
        this.setSize(600, 800);

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

        backGround = Utils.loadImage("resources/background.png");
        this.addKeyListener(PlayerController.playerController);
        this.bufferedImage = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        this.bufferedImageGraphics = bufferedImage.getGraphics();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void update(Graphics g) {
        bufferedImageGraphics.drawImage(backGround, 0, 0, null);
        PlayerController.playerController.draw(bufferedImageGraphics);
        WeaponManager.instance.draw(bufferedImageGraphics);
        EnemyManager.instance.draw(bufferedImageGraphics);
        bufferedImageGraphics.drawString("POINT: " + PlayerController.playerController.getGameObject().getPoint(), 500, 50);
        bufferedImageGraphics.drawString("HP: " + PlayerController.playerController.getGameObject().getHp(), 50, 50);
        g.drawImage(bufferedImage, 0, 0, null);
    }

    @Override
    public void run() {
        while (true){
            try {
                PlayerController.playerController.run();
                WeaponManager.instance.run();
                EnemyManager.instance.run();
                CollisionPool.instance.run();
                Thread.sleep(17);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
