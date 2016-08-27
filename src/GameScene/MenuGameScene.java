package GameScene;

import Controller.GameInput;
import Utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by HungNguyen on 8/27/2016.
 */
public class MenuGameScene implements Scene, KeyListener, MouseListener{
    private Image background;
    private Image buttonPlay;
    private GameInput gameInput;

    public MenuGameScene(){
        background = Utils.loadImage("resources/backg2.png");
        buttonPlay = Utils.loadImage("resources/playbutton.png");
        gameInput = new GameInput();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background, 0, 0, null);
        g.drawImage(buttonPlay, 500, 450, null);
    }

    @Override
    public void run() {

    }

    @Override
    public KeyListener getKeyListener() {
        return this;
    }

    @Override
    public MouseListener getMouseListenr() {
        return this;
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getX() <= 630 && e.getX() >= 500 && e.getY() >= 450 && e.getY() <= 580) {
            GameManager.getInstance().getStackScreen().push(new PlayGameScene());
            System.out.println("Play Screen");
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
