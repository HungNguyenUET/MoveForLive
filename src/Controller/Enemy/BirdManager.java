package Controller.Enemy;

import Controller.ControllerManager;
import Controller.Weapon.WeaponController;
import Model.Bird;
import Utils.Utils;
import View.AnimationDrawer;

import java.util.Random;

/**
 * Created by Viet on 8/24/2016.
 */
public class BirdManager extends ControllerManager {

    private Random rand = new Random();
    private static int count = 0;
    private static final int A = 20;

    public BirdManager() {
        super();
    }

    @Override
    public void run() {
        super.run();
        count++;
        int enX = rand.nextInt(1000);
        int enY = rand.nextInt(150);
        if (count == A) {
            count = 0;
            for (int i = 0; i < 1 ; i++) {
                BirdController birdController = BirdController.create(enX, enY);
                this.add(birdController);
            }
        }
    }
    public static final BirdManager instance = new BirdManager();
}
