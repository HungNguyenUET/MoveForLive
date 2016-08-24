package Controller.Gift;

import Controller.ControllerManager;
import Controller.WeaponController;
import Controller.WeaponManager;
import Model.Gift;
import Model.Weapon;
import View.ImageDrawer;

import java.util.Random;

/**
 * Created by Minh on 8/24/2016.
 */
public class GiftManager extends ControllerManager{
    private Random rand = new Random();
    private static int count = 0;
    private static final int GIFT_PERIOD = 50;

    private GiftManager() {
        super();
    }

    @Override
    public void run() {
        super.run();
        count++;
        int enX = rand.nextInt(1000);
        int enY = rand.nextInt(100);
        if(count == GIFT_PERIOD){
            count = 0;
            for(int i = 0; i < 1; i++){
                GiftController giftController = new GiftController(
                        new Gift(enX, enY),
                        new ImageDrawer("resources/dauan.png")
                );
                this.add(giftController);
            }
        }
    }

    public static final GiftManager instance = new GiftManager();
}
