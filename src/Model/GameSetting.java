package Model;

/**
 * Created by Viet on 8/18/2016.
 */
public class GameSetting {
    private static final int WIDTH_DEFAULT = 1400;
    private static final int HEIGHT_DEFAULT = 700;
    private static final int THREAD_DELAY = 17;

    private int screenWidth;
    private int screenHeight;
    private int threadDelay;

    public GameSetting(int screenWidth, int screenHeight, int threadDelay) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.threadDelay = threadDelay;
    }

    public boolean inScreen(GameObject gameObject) {
        return gameObject.getY() < this.screenHeight;
    }

    public double toSeconds(int threadCount ) {

        return ((double)threadCount * threadDelay) / 1000;
    }

    public double toMiliseconds(int threadCount ) {
        return ((double)threadCount * threadDelay) ;
    }

    public static int getWidthDefault() {
        return WIDTH_DEFAULT;
    }

    public static int getHeightDefault() {
        return HEIGHT_DEFAULT;
    }

    public static int getThreadDefault() {
        return THREAD_DELAY;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public int getThreadDelay() {
        return threadDelay;
    }

    public void setThreadDelay(int threadDelay) {
        this.threadDelay = threadDelay;
    }
    private static GameSetting instance;
    public static GameSetting getInstance() {
        if (instance == null) {
            instance = new GameSetting(WIDTH_DEFAULT,HEIGHT_DEFAULT,THREAD_DELAY);
        }
        return instance;
    }
}
