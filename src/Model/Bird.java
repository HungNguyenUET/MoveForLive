package Model;

/**
 * Created by Viet on 8/24/2016.
 */
public class Bird extends GameObject  {
    private static final int WIDTH = 64;
    private static final int HEIGHT = 64;
    public Bird(int x, int y ) {
        super(x, y, WIDTH, HEIGHT, 0, 0);
    }
}
