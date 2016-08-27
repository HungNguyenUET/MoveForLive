package Model;

/**
 * Created by HungNguyen on 8/27/2016.
 */
public class GameVector {
    public int dx;
    public int dy;

    public GameVector(){
        this(0, 0);
    }

    public GameVector(int dx, int dy){
        this.dx = dx;
        this.dy = dy;
    }
}
