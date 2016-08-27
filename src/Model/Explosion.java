package Model;

/**
 * Created by giaqu on 8/27/2016.
 */
public class Explosion extends GameObject {
    public static final int WIDTH = 80;
    public static final int HEIGHT = 80;
    public Explosion(int x, int y) {
        super(x, y, WIDTH, HEIGHT, 0, 0);
    }
}
