package Model;

/**
 * Created by Viet on 8/26/2016.
 */
public class Demon extends GameObject {
    public static final int WIDTH = 100;
    public static final int HEIGHT = 100;
    public Demon(int x, int y) {
        super(x, y, WIDTH, HEIGHT, 0, 10);
    }
}
