package Controller.Weapon;

import Controller.ControllerManager;

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
        int enX = rand.nextInt(1000);
        int enY = rand.nextInt(150);
        if(count == A){
            count = 0;
            for(int i = 0; i < 1; i++){
                int random = rand.nextInt(3);
                if (random == 1) {
                    WeaponController weaponController = WeaponController.create(enX, enY, WeaponStateShot.FOLLOWED1, WeaponStateScene.SCENE1);
                    this.add(weaponController);
                }else if (random == 2){
                    WeaponController weaponController = WeaponController.create(enX, enY, WeaponStateShot.FOLLOWED2, WeaponStateScene.SCENE1);
                    this.add(weaponController);
                }else {
                    WeaponController weaponController = WeaponController.create(enX, enY, WeaponStateShot.STRAIGHT, WeaponStateScene.SCENE1);
                    this.add(weaponController);
                }
            }
        }
    }

    public static final WeaponManager instance = new WeaponManager();
}
