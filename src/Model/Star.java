package Model;

/**
 * Created by Viet on 8/19/2016.
 */
public class Star extends GameObject {
    public static final int WIDTH = 60;
    public static final int HEIGHT = 60;

    public Star(int x, int y, int width, int height) {
        super(x, y, width, height, 0, 0);
    }
    public Star(int x, int y){
        super(x, y, WIDTH, HEIGHT, 0, 0);
    }
}
