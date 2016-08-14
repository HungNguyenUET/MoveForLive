package Model;

/**
 * Created by giaqu on 8/14/2016.
 */
public class Enemy extends GameObject{
    public static final int WIDTH = 32;
    public static final int HEIGHT = 32;

    public Enemy(int x, int y, int width, int height) {
        super(x, y, width, height, 0, 0);
    }

    public Enemy(int x, int y){
        super(x, y, WIDTH, HEIGHT, 0, 0);
    }

}
