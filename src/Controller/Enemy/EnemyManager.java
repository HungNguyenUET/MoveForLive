package Controller.Enemy;

import Controller.ControllerManager;
import GameScene.GameManager;

import java.util.Random;

/**
 * Created by giaqu on 8/14/2016.
 */
public class EnemyManager extends ControllerManager {
    private Random rand = new Random();
    private static int count1 = 0;
    private static int count2 = 0;
    private static int count3 = 0;
    private static int count4 = 0;
    private static final int B = 300;
    private static final int C = 250;
    private static final int D = 450;
    private static final int E = 400;

    private EnemyManager(){

        super();
    }

    @Override
    public void run() {
        super.run();
        switch (GameManager.getInstance().getStackScreen().peek().getStt()) {
            case 1:
                count1++;
                count2++;
                count3++;
                count4++;
                int enX11L = 0;
                int enX11R = 500;
                int enX12L = 600;
                int enX12R = 1000;
                int enY = 500;
                if (count1 == B) {
                    count1 = 0;
                    for (int i = 0; i < 1; i++) {
                        EnemyController enemyController = EnemyController.create(enX11L, enY);
                        this.add(enemyController);
                    }
                }
                if (count2 == C) {
                    count2 = 0;
                    for (int j = 0; j < 1; j++) {
                        EnemyController enemyController = EnemyController.create(enX11R, enY);
                        this.add(enemyController);
                    }
                }
                if (count3 == D) {
                    count3 = 0;
                    for (int i = 0; i < 1; i++) {
                        EnemyController enemyController = EnemyController.create(enX12L, enY);
                        this.add(enemyController);
                    }
                }
                if (count4 == E) {
                    count4 = 0;
                    for (int j = 0; j < 1; j++) {
                        EnemyController enemyController = EnemyController.create(enX12R, enY);
                        this.add(enemyController);
                    }
                }
            case 2:
                count1++;
                count2++;
                int enY21 = 0;
                int enY22 = 300;
                int enX2 = rand.nextInt(1000);
                if (count1 == B) {
                    count1 = 0;
                    for (int i = 0; i < 1; i++) {
                        EnemyController enemyController = EnemyController.create(enX2, enY21);
                        this.add(enemyController);
                    }
                }
                if (count2 == C) {
                    count2 = 0;
                    for (int j = 0; j < 1; j++) {
                        EnemyController enemyController = EnemyController.create(enX2, enY22);
                        this.add(enemyController);
                    }
                }
        }
    }

    public final static EnemyManager instance = new EnemyManager();

}


