package carsharing.menu;

import carsharing.command.ManagerClientOption;
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
    protected int display() {
        return choice();
    }

    @Override
    protected boolean process(MenuItem item) throws IOException {

        ManagerClientOption managerClientOption = new ManagerClientOption(factory);

        switch (item) {
            case COMPANY_LIST:
                managerClientOption.manage();
                break;
            case CREATE_A_COMPANY:
                managerClientOption.createCompany();
                break;
            case BACK:
                menuItem = MenuItem.UNKNOWN;
                System.out.println();
                return false;
        }

        return true;
    }
}
