package Controller.Gift;

import Controller.ControllerManager;

import java.util.Random;

/**
 * Created by Minh on 8/24/2016.
 */
public class GiftManager extends ControllerManager{
    private Random rand = new Random();
    private static int count = 0;
    private static final int GIFT_PERIOD = 100;

    private GiftManager() {
        super();
    }

    @Override
    public void run() {
        super.run();
        count++;
        int enX = rand.nextInt(1000);
        int enY = rand.nextInt(150);
        if(count == GIFT_PERIOD){
            count = 0;
            for(int i = 0; i < 1; i++){
                GiftController giftController = GiftController.create(enX, enY, GiftState.SCENE1);
                this.add(giftController);
            }
        }
    }

    public static final GiftManager instance = new GiftManager();
}
