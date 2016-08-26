package Controller.Enemy;

import Controller.ControllerManager;
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
        int enX = rand.nextInt(1300);
        int enY = rand.nextInt(150);
        if (count == A) {
            count = 0;
            for (int i = 0; i < 1 ; i++) {
                BirdController birdController = new BirdController(
                        new Bird(enX, enY),
                        new AnimationDrawer(
                                Utils.loadFromSprite("resources/bird.png",true,64,64,0,0)
                        )
                );
                this.add(birdController);

            }
        }
    }
    public static final BirdManager instance = new BirdManager();
}