package Controller.Enemy;

import Controller.ControllerManager;
import Model.Enemy;
import View.ImageDrawer;

/**
 * Created by giaqu on 8/14/2016.
 */
public class EnemyManager extends ControllerManager {

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
        count1++;
        count2++;
        count3++;
        count4++;
        int enX1 = 0;
        int enX2 = 500;
        int enX3 = 600;
        int enX4 = 1000;
        int enY = 625 ;
        if(count1 == B){
            count1 = 0;
            for (int i = 0; i < 1; i++) {
                EnemyController enemyController = EnemyController.create(enX, enY);
                this.add(enemyController);
            }
        }
        if(count2 == C){
            count2 = 0;
            for (int j = 0; j < 1; j++) {
                EnemyController enemyController = EnemyController.create(enX, enY);
                this.add(enemyController);
            }
        }
        if(count3 == D){
            count3= 0;
            for (int i = 0; i < 1; i++) {
                EnemyController enemyController = EnemyController.create(enX, enY);
                this.add(enemyController);
            }
        }
        if(count4 == E){
            count4 = 0;
            for (int j = 0; j < 1; j++) {
                EnemyController enemyController = EnemyController.create(enX, enY);
                this.add(enemyController);
            }
        }
    }

    public final static EnemyManager instance = new EnemyManager();

}


