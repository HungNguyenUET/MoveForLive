package Controller.Weapon;

import Controller.ControllerManager;
import GameScene.GameManager;

import java.util.Random;

/**
 * Created by giaqu on 8/14/2016.
 */
public class WeaponManager extends ControllerManager {

    private Random rand = new Random();
    private static int count = 0;
    private static final int A = 60;

    private WeaponManager() {
        super();
    }

    @Override
    public void run() {
        super.run();
        switch (GameManager.getInstance().getStackScreen().peek().getStt()){
            case 1:
                count++;
                int enX1 = rand.nextInt(1000);
                int enY1 = rand.nextInt(150);
                if(count == A){
                    count = 0;
                    for(int i = 0; i < 1; i++){
                        int random = rand.nextInt(3);
                        if (random == 1) {
                            WeaponController weaponController = WeaponController.create(enX1, enY1, WeaponStateShot.FOLLOWED1);
                            this.add(weaponController);
                        }else if (random == 2){
                            WeaponController weaponController = WeaponController.create(enX1, enY1, WeaponStateShot.FOLLOWED2);
                            this.add(weaponController);
                        }else {
                            WeaponController weaponController = WeaponController.create(enX1, enY1, WeaponStateShot.STRAIGHT);
                            this.add(weaponController);
                        }
                    }
                }
                break;
            case 2:
                count++;
                int enY2 = rand.nextInt(600);
                int enX2L = 0;
                int enX2R = 1000;
                if(count == A){
                    count = 0;
                    for(int i = 0; i < 1; i++){
                        int random = rand.nextInt(3);
                        if (random == 1) {
                            WeaponController weaponController = WeaponController.create(enX2L, enY2, WeaponStateShot.FOLLOWED1);
                            WeaponController weaponController2 = WeaponController.create(enX2R, enY2, WeaponStateShot.FOLLOWED1);
                            this.add(weaponController);
                        }else if (random == 2){
                            WeaponController weaponController = WeaponController.create(enX2L, enY2, WeaponStateShot.FOLLOWED2);
                            WeaponController weaponController2 = WeaponController.create(enX2R, enY2, WeaponStateShot.FOLLOWED2);
                            this.add(weaponController);
                        }else {
                            WeaponController weaponController = WeaponController.create(enX2L, enY2, WeaponStateShot.STRAIGHT);
                            WeaponController weaponController2 = WeaponController.create(enX2R, enY2, WeaponStateShot.STRAIGHT);
                            this.add(weaponController);
                        }
                    }
                }
                break;
        }
    }

    public static final WeaponManager instance = new WeaponManager();
}
