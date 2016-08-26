package Controller.Demon;

import Controller.ControllerManager;
import Model.Demon;
import View.ImageDrawer;

/**
 * Created by Viet on 8/26/2016.
 */
public class DemonManager extends ControllerManager {

    private static int count = 0;

    public DemonManager() {
        super();
    }

    @Override
    public void run() {
        super.run();
        count++;
        int enX = 50;
        int enY = 50;
        if(count == 10) {
            count = 0;
            DemonController demonController = new DemonController(
                    new Demon(enX, enY),
                    new ImageDrawer("resources/demon2.png")
            );
            this.add(demonController);
        }
    }
    public final static DemonManager instance = new DemonManager();
}
