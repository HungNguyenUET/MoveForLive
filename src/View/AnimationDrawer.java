package View;

import Model.GameObject;
import Model.GameSetting;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Viet on 8/24/2016.
 */
public class AnimationDrawer implements GameDrawer {
    private Vector<Image> imageVector;
    private int imageIndex;
    private int timeCounter;

    public AnimationDrawer(Vector<Image> imageVector) {
        this.imageVector = imageVector;
        this.imageIndex = 0;
        this.timeCounter = 0;
    }

    public boolean animationReachEnd() {
        return imageIndex == imageVector.size() - 1;
    }

    @Override
    public void draw(Graphics g, GameObject gameObject) {
        Image image = imageVector.get(imageIndex);
        /*Draw the image*/
        g.drawImage(image, gameObject.getX(), gameObject.getY(),
                gameObject.getWidth(), gameObject.getHeight(),
                null);
        /*Change the next image */
        timeCounter++;
        if (GameSetting.getInstance().toMiliseconds(timeCounter) >= 80) {
            timeCounter = 0;
            imageIndex++;
            if (imageIndex >= imageVector.size()) {
                imageIndex = 0;
            }
        }
    }
}
