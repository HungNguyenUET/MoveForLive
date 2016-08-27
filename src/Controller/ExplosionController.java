package Controller;

import Model.GameObject;
import View.AnimationDrawer;
import View.GameDrawer;

import java.awt.*;

/**
 * Created by giaqu on 8/27/2016.
 */
public class ExplosionController extends SingleController {
    public ExplosionController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        if (gameDrawer instanceof AnimationDrawer) {
            if (((AnimationDrawer) gameDrawer).animationReachEnd()) {
                gameObject.destroy();
            }
        }
    }
}
