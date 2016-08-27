package GameScene;

import Controller.GameInput;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Created by HungNguyen on 8/27/2016.
 */
public interface Scene {
    void draw(Graphics g);
    void run();
    KeyListener getKeyListener();
    MouseListener getMouseListenr();
    void setGameInput(GameInput gameInput);
}
