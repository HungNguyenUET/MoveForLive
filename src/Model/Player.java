package Model;

/**
 * Created by giaqu on 8/14/2016.
 */
public class Player extends GameObject {

    public static final int WIDTH = 50;
    public static final int HEIGHT = 60 ;
    public static final int HP = 5;

    public static final int POINT = 0;

    public Player(int x, int y) {
        super(x, y, WIDTH, HEIGHT, POINT, HP);
    }
}

