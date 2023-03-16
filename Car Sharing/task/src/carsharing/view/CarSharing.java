package carsharing.view;

import carsharing.controller.ControllerFactory;
import carsharing.menu.StartMenu;

import java.io.IOException;

public class CarSharing {

    private final ControllerFactory controllerFactory;

    public CarSharing(ControllerFactory factory) {
        this.controllerFactory = factory;
    }

    public void start() throws IOException {
        new StartMenu(controllerFactory).process();
    }
}
