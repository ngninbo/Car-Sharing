package carsharing.menu;

import carsharing.command.StartCommand;
import carsharing.controller.ControllerFactory;
import carsharing.util.MenuItem;

import java.io.IOException;

public class StartMenu extends Menu {

    private final ControllerFactory controllerFactory;

    public StartMenu(ControllerFactory controllerFactory) {
        super(MenuItem.MAIN_MENU_OPTIONS);
        this.controllerFactory = controllerFactory;
    }

    @Override
    public int display() {
        return choice();
    }

    @Override
    public boolean process(MenuItem item) throws IOException {

        if (!new StartCommand(controllerFactory).execute(item)) {
            menuItem = MenuItem.UNKNOWN;
            return false;
        }

        return true;
    }
}
