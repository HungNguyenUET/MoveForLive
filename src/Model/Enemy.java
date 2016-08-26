package Model;

/**
 * Created by giaqu on 8/14/2016.
 */
public class Enemy extends GameObject{
    public static final int WIDTH = 40;
    public static final int HEIGHT = 40;

    public Enemy(int x, int y, int width, int height) {
        super(x, y, width, height, 0, 0);
    }

    public Enemy(int x, int y){
        super(x, y, WIDTH, HEIGHT, 0, 0);
    }

}
