package carsharing.menu;

import carsharing.command.ManagerCommand;
import carsharing.controller.ControllerFactory;
import carsharing.util.MenuItem;

import java.io.IOException;

public class ManagerMenu extends Menu {

    private final ControllerFactory factory;

    public ManagerMenu(ControllerFactory factory) {
        super(MenuItem.MANAGER_OPTIONS);
        this.factory = factory;
    }

    @Override
    public int display() {
        return choice();
    }

    @Override
    public boolean process(MenuItem item) throws IOException {
        return new ManagerCommand(factory).execute(item);
    }
}
