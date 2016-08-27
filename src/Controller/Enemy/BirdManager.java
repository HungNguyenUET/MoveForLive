package Controller.Enemy;

import Controller.ControllerManager;
import GameScene.GameManager;

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
        switch (GameManager.getInstance().getStackScreen().peek().getStt()) {
            case 1:
                count++;
                int enX = rand.nextInt(1000);
                int enY = rand.nextInt(150);
                if (count == A) {
                    count = 0;
                    for (int i = 0; i < 1; i++) {
                        BirdController birdController = BirdController.create(enX, enY);
                        this.add(birdController);
                    }
                }
                break;
            case 2:
                count++;
                int enX2 = rand.nextInt(1000);
                int enY21 = 0;
                int enY22 = 300;
                if (count == A) {
                    count = 0;
                    for (int i = 0; i < 1; i++) {
                        BirdController birdController = BirdController.create(enX2, enY21);
                        this.add(birdController);
                    }
                }
                if (count == A) {
                    count = 0;
                    for (int j = 0; j < 1; j++) {
                        BirdController birdController = BirdController.create(enX2, enY22);
                        this.add(birdController);
                    }

                }
                break;
        }
    }
    public static final BirdManager instance = new BirdManager();
}
