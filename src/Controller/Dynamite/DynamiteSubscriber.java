package Controller.Dynamite;

import Model.GameObject;

/**
 * Created by Linh on 8/27/2016.
 */
public interface DynamiteSubscriber {
    public void onDynamiteExplode(int x, int y);
    public GameObject getGameObject();
}
