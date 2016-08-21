package Controller;

import Model.Enemy;
import View.ImageDrawer;

/**
 * Created by giaqu on 8/14/2016.
 */
public class EnemyManager extends ControllerManager{

    private static int count1 = 0;
    private static int count2 = 0;
    private static final int B = 300;
    private static final int C = 300;

    private EnemyManager(){

        super();
    }

    @Override
    public void run() {
        super.run();
        count1++;
        count2++;
        int enX1 = 0;
        int enX2 = 500;
        int enY = 550 ;
        if(count1 == B){
            count1 = 0;
            for (int i = 0; i < 1; i++) {

                EnemyController enemyController = new EnemyController(
                        new Enemy(enX1, enY),
                        new ImageDrawer("resources/star.png")
                );
                this.add(enemyController);
            }
        }
        if(count2 == C){
            count2 = 0;
            for (int j = 0; j < 1; j++) {

                EnemyController enemyController = new EnemyController(
                        new Enemy(enX2, enY),
                        new ImageDrawer("resources/star.png")
                );
                this.add(enemyController);

            }
        }

    }

    public final static EnemyManager instance = new EnemyManager();

}


