package Controller.Dynamite;

import Controller.ControllerManager;
import Controller.Enemy.BirdController;
import Controller.Weapon.WeaponController;
import Model.Dynamite;
import Model.GameSetting;
import View.ImageDrawer;

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
        count++;
        super.run();
        Random rand = new Random();
        if (count == 50) {
            count = 0;
            int x = rand.nextInt(GameSetting.getInstance().getScreenWidth()) + 1;
            DynamiteController dynamiteController = DynamiteController.create();
            this.add(dynamiteController);
        }
    }
}
