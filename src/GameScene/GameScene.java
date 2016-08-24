package GameScene;

import java.awt.*;
import java.awt.event.KeyListener;

/**
 * Created by Viet on 8/18/2016.
 */
public interface GameScene extends Runnable {
    void draw(Graphics g);
    KeyListener getKeyListener();
    void setGameSceneListener(GameSceneListener gameSceneListener);

}
