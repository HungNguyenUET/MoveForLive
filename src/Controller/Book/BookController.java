package Controller.Book;

import Controller.Colliable;
import Controller.CollisionPool;

import Controller.PlayerScene2.PlayerController21;
import Controller.PlayerScene2.PlayerController22;
import Controller.SingleController;
import Model.Book;
import Model.Gift;
import View.GameDrawer;
import View.ImageDrawer;

import java.util.Random;

/**
 * Created by Linh on 8/27/2016.
 */
public class BookController extends SingleController implements Colliable {
    private static final int SPEED_Y = 10;

    private Random rand = new Random();

    public BookController(Book gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = SPEED_Y;
        CollisionPool.instance.add(this);
    }

    @Override
    public void run() {
        super.run();
        if(gameObject.getY() > 600) {
            gameObject.destroy();
        }
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof PlayerController21 || colliable instanceof PlayerController22) {

            this.getGameObject().destroy();
        }
    }
    public static BookController create(int x, int y){
        BookController bookController = null;
        bookController = new BookController(new Book(x, y), new ImageDrawer("resources/book.png"));
        return bookController;
    }
}
