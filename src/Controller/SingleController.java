package Controller;

import Model.GameObject;
import Model.GameVector;
import View.GameDrawer;

import java.awt.*;

/**
 * Created by giaqu on 8/14/2016.
 */
public class SingleController implements BaseController{

    protected GameObject gameObject;
    protected GameDrawer gameDrawer;
    protected GameVector gameVector;

    public SingleController(GameObject gameObject, GameDrawer gameDrawer) {
        this.gameObject = gameObject;
        this.gameDrawer = gameDrawer;
        this.gameVector = new GameVector();

    }

    public GameObject getGameObject() {
        return gameObject;
    }

    public GameVector getGameVector() {
        return gameVector;
    }

    @Override
    public void draw(Graphics g) {
        gameDrawer.draw(g, gameObject);
    }

    @Override
    public void run() {
        gameObject.move(this.gameVector);
    }
}

