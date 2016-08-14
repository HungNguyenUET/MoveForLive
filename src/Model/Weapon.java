package Model;

/**
 * Created by giaqu on 8/14/2016.
 */
public class Weapon extends GameObject {

    public static final int DEFAULT_WIDTH = 20;
    public static final int DEFAULT_HEIGHT = 24;

    public Weapon(int x, int y, int width, int height) {
        super(x, y, width, height, 0, 0);
    }

    public Weapon(int x, int y){
        super(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT, 0, 0);
    }
}
