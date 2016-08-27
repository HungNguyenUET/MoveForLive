package Controller.Book;

import Controller.ControllerManager;
import Controller.Gift.GiftController;
import Controller.Gift.GiftManager;
import Model.Gift;
import View.ImageDrawer;
import java.util.Random;

/**
 * Created by Linh on 8/27/2016.
 */
public class BookManager extends ControllerManager {
    private Random rand = new Random();
    private static int count = 0;
    private static final int BOOK_PERIOD = 100;

    private BookManager() {
        super();
    }

    @Override
    public void run() {
        super.run();
        count++;
        int enX = rand.nextInt(1000);
        int enY = rand.nextInt(150);
        if (count == BOOK_PERIOD) {
            count = 0;
            for (int i = 0; i < 1; i++) {
                BookController bookController = BookController.create(500, 100);
                this.add(bookController);
            }
        }
    }
    public static final BookManager instance = new BookManager();
}
