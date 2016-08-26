package GameScene;

import Controller.PlayButtonController;
import Utils.Utils;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Viet on 8/18/2016.
 */
public class MenuGameScene implements GameScene, MouseListener  {
    private GameSceneListener gameSceneListener;
    private Image background;
//    private JButton button = new JButton(new ImageIcon("resources/button.png"));
//    private JPanel panel = new JPanel();

    public MenuGameScene() {
        background = Utils.loadImage("resources/backg2.png");
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (gameSceneListener != null)
//                    gameSceneListener.changeGameScene(new PlayGameScene());
//            }
//        });
//        panel.add(button);
        reset();
    }

    private void reset(){
//        new MenuGameScene();
    }

    @Override
    public void draw(Graphics g) {
        
        g.drawImage(background, 0, 0, null);
        PlayButtonController.instance.draw(g);

    }

    @Override
    public KeyListener getKeyListener() {
        return null;
    }


    @Override
    public MouseListener getMouseListener() {
        return this;
    }

    @Override
    public void setGameSceneListener(GameSceneListener gameSceneListener) {
        this.gameSceneListener = gameSceneListener;
    }

    @Override
    public void run() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getX() <= 630 && e.getX() >= 500 && e.getY() >= 450 && e.getY() <= 580) {
            if (gameSceneListener != null) {
                gameSceneListener.changeGameScene(new PlayGameScene(), true);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
