//package Controller.Book;
//
//import Controller.Colliable;
//import Controller.CollisionPool;
//import Controller.PlayerScene1.PlayerController21;
//import Controller.SingleController;
//import Model.Book;
//import Model.Gift;
//import View.GameDrawer;
//
//import java.util.Random;
//
///**
// * Created by Linh on 8/27/2016.
// */
//public class BookController extends SingleController implements Colliable {
//    private static final int SPEED_Y = 10;
//    private static final int SPEED_X = 5;
//    private Random rand = new Random();
//
//    public BookController(Book gameObject, GameDrawer gameDrawer) {
//        super(gameObject, gameDrawer);
//        this.gameVector.dy = SPEED_Y;
//        int random = rand.nextInt(2);
//        CollisionPool.instance.add(this);
//    }
//
//    @Override
//    public void run() {
//        super.run();
//        if(gameObject.getY() > 600) {
//            gameObject.destroy();
//        }
//    }
//
//    @Override
//    public void onCollide(Colliable colliable) {
//        if (colliable instanceof PlayerController21) {
//            this.getGameObject().destroy();
//        }
//    }
//}
