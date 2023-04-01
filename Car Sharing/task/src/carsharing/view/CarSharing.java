package carsharing.view;

import carsharing.controller.ControllerFactory;
import carsharing.menu.StartMenu;

public class CarSharing {

    private final ControllerFactory controllerFactory;

    public CarSharing(ControllerFactory factory) {
        this.controllerFactory = factory;
    }

    public void start() {
        new StartMenu(controllerFactory).process();
    }
}
