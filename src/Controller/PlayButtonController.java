package Controller;

import Model.GameObject;
import Model.PlayButton;
import View.GameDrawer;
import View.ImageDrawer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Viet on 8/28/2016.
 */
public class PlayButtonController extends SingleController implements MouseListener{
    public PlayButtonController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
    }


    public static final PlayButtonController instance = new PlayButtonController(
            new PlayButton(630, 500),
            new ImageDrawer("resources/playbutton.png")
    );

    @Override
    public void mouseClicked(MouseEvent e) {

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
