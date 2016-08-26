package Controller.Weapon;

import Controller.ControllerManager;
import Model.Weapon;
import View.ImageDrawer;

import java.util.Random;

/**
 * Created by giaqu on 8/14/2016.
 */
public class WeaponManager extends ControllerManager {

    private Random rand = new Random();
    private static int count = 0;
    private static final int A = 50;

    private WeaponManager() {
        super();
    }

    @Override
    public void run() {
        super.run();
        count++;
        int enX = rand.nextInt(1300);
        int enY = rand.nextInt(100);
        if(count == A){
            count = 0;
            for(int i = 0; i < 1; i++){
                WeaponController weaponController = new WeaponController(
                    new Weapon(enX, enY),
                        new ImageDrawer("resources/sword.png")
                );
                this.add(weaponController);
            }
        }
    }

    public static final WeaponManager instance = new WeaponManager();
}
