package Controller.Dynamite;

import Controller.ControllerManager;
import GameScene.GameManager;
import Model.GameSetting;

import java.util.Random;

/**
 * Created by Linh on 8/27/2016.
 */
public class DynamiteManager extends ControllerManager {
    private int count;
    private DynamiteManager(){
        super();
    }
    private static DynamiteManager inst;
    public static DynamiteManager getInst(){
        if(inst == null){
            inst = new DynamiteManager();
        }
        return inst;
    }

    @Override
    public void run() {
        super.run();
        switch (GameManager.getInstance().getStackScreen().peek().getStt()) {
            case 1:
                count++;
                Random rand = new Random();
                if (count == 50) {
                    count = 0;
                    int x = rand.nextInt(GameSetting.getInstance().getScreenWidth()) + 1;
                    DynamiteController dynamiteController = DynamiteController.create(x, 0);
                    this.add(dynamiteController);
                }
                break;
            case 2:
                count++;
                Random rand1 = new Random();
                if (count == 50) {
                    count = 0;
                    int x = rand1.nextInt(GameSetting.getInstance().getScreenWidth()) + 1;
                    DynamiteController dynamiteController = DynamiteController.create(x, 0);
                    DynamiteController dynamiteController2 = DynamiteController.create(x, 300);
                    this.add(dynamiteController);
                }
                break;
        }
    }
}
