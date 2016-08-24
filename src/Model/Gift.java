package Model;

/**
 * Created by Minh on 8/24/2016.
 */
public class Gift extends GameObject {
    public static final int WIDTH = 60;
    public static final int HEIGHT = 60;

    public Gift(int x, int y, int width, int height) {
        super(x, y, width, height, 0, 0);
    }
    public Gift(int x, int y){
        super(x, y, WIDTH, HEIGHT, 0, 0);
    }
}
