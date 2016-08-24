package Controller;

import Model.GameObject;

/**
 * Created by giaqu on 8/14/2016.
 */
public interface Colliable {
    GameObject getGameObject();
    void onCollide(Colliable colliable);
}
