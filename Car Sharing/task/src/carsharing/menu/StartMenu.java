package carsharing.menu;

import carsharing.command.StartCommand;
import carsharing.controller.ControllerFactory;

public class StartMenu extends Menu {

    private final ControllerFactory controllerFactory;

    public StartMenu(ControllerFactory controllerFactory) {
        super(MenuItem.mainMenuItems());
        this.controllerFactory = controllerFactory;
    }

    @Override
    public int display() {
        return choice();
    }

    @Override
    public boolean process(MenuItem item) {

        if (!new StartCommand(controllerFactory).execute(item)) {
            menuItem = MenuItem.UNKNOWN;
            return false;
        }

        return true;
    }
}
