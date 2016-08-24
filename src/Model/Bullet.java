package Model;

/**
 * Created by Viet on 8/24/2016.
 */
public class Bullet extends GameObject {
    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;
    public Bullet(int x, int y) {
        super(x, y, WIDTH, HEIGHT, 0, 0);
    }
}
