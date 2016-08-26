package Model;

/**
 * Created by Linh on 8/27/2016.
 */
public class Dynamite extends GameObject {
    public static final int WIDTH = 40;
    public static final int HEIGHT = 40;

    public Dynamite(int x, int y, int width, int height) {
        super(x, y, width, height, 0, 0);
    }
    public Dynamite(int x, int y){
        super(x, y, WIDTH, HEIGHT, 0, 0);
    }
}
