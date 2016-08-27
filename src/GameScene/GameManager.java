package GameScene;

import java.util.Stack;

/**
 * Created by HungNguyen on 8/27/2016.
 */
public class GameManager {
    private Stack<Scene> stackScreen;
    private static GameManager ourInstance = new GameManager();

    public static GameManager getInstance() {
        return ourInstance;
    }

    private GameManager() {
        stackScreen = new Stack<>();
    }

    public Stack<Scene> getStackScreen() {
        return stackScreen;
    }
}
