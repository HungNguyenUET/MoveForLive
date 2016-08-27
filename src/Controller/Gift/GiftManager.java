package Controller.Gift;

import Controller.ControllerManager;
import GameScene.GameManager;

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
        switch (GameManager.getInstance().getStackScreen().peek().getStt()) {
            case 1:
                count++;
                int enX1 = rand.nextInt(1000);
                int enY1 = rand.nextInt(150);
                if (count == GIFT_PERIOD) {
                    count = 0;
                    for (int i = 0; i < 1; i++) {
                        GiftController giftController = GiftController.create(enX1, enY1);
                        this.add(giftController);
                    }
                }
                break;
            case 2:
                count++;
                int enX2L = 0;
                int enX2R = 1000;
                int enY2 = rand.nextInt(600);
                if (count == GIFT_PERIOD) {
                    count = 0;
                    for (int i = 0; i < 1; i++) {
                        GiftController giftController = GiftController.create(enX2L, enY2);
                        GiftController giftController2 = GiftController.create(enX2R, enY2);
                        this.add(giftController);
                    }
                }
                break;
        }
    }

    public static final GiftManager instance = new GiftManager();
}
