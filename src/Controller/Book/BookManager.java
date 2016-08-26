//package Controller.Book;
//
//import Controller.ControllerManager;
//import Controller.Gift.GiftController;
//import Controller.Gift.GiftManager;
//import Model.Gift;
//import View.ImageDrawer;
//
//import java.util.Random;
//
///**
// * Created by Linh on 8/27/2016.
// */
//public class BookManager extends ControllerManager {
//    private Random rand = new Random();
//    private static int count = 0;
//    private static final int GIFT_PERIOD = 100;
//
//    private BookManager() {
//        super();
//    }
//
//    @Override
//    public void run() {
//        super.run();
//        count++;
//        int enX = rand.nextInt(1000);
//        int enY = rand.nextInt(150);
//        if(count == GIFT_PERIOD){
//            count = 0;
//            for(int i = 0; i < 1; i++){
//                GiftController giftController = new GiftController(
//                        new Gift(enX, enY),
//                        new ImageDrawer("resources/heart.png")
//                );
//                this.add(giftController);
//            }
//        }
//    }
//
//    public static final GiftManager instance = new GiftManager();
//} {
//}
