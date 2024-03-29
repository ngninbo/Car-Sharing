package carsharing.menu;

import carsharing.command.ManagerCommand;
import carsharing.controller.ControllerFactory;

public class ManagerMenu extends Menu {

    private final ControllerFactory factory;

    public ManagerMenu(ControllerFactory factory) {
        super(MenuItem.managerMenuItems());
        this.factory = factory;
    }

    @Override
    public int display() {
        return choice();
    }

    @Override
    public boolean process(MenuItem item) {
        return new ManagerCommand(factory).execute(item);
    }
}
