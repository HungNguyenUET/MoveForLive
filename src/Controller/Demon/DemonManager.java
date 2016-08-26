package Controller.Demon;

import Controller.ControllerManager;
import Model.Demon;
import View.ImageDrawer;

/**
 * Created by Viet on 8/26/2016.
 */
public class DemonManager extends ControllerManager {
    public DemonManager() {
        super();
    }

    @Override
    public void run() {
        super.run();
        int enX = 600;
        int enY = 50;
        DemonController demonController = new DemonController(
                new Demon(enX, enY),
                new ImageDrawer("resources/demon2.png")
        );
        this.add(demonController);
    }
    public final static DemonManager instance = new DemonManager();
}
