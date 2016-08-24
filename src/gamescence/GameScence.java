package gamescence;

import java.awt.*;
import java.awt.event.KeyListener;

/**
 * Created by Viet on 8/18/2016.
 */
public interface GameScence extends Runnable {
    void draw(Graphics g);
    KeyListener getKeyListener();
    void setGameSceneListener(GameScenceListener gameSceneListener);

}
