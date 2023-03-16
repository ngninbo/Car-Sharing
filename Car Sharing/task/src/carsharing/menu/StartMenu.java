package carsharing.menu;

import carsharing.controller.ControllerFactory;
import carsharing.util.CarSharingUtil;
import carsharing.util.MenuItem;

import java.io.IOException;
import java.util.Scanner;

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

        switch (item) {
            case LOG_IN_AS_A_MANAGER:
                System.out.println();
                new ManagerMenu(controllerFactory).process();
                break;
            case LOG_IN_AS_A_CUSTOMER:
                new CustomerMenu(controllerFactory).process();
                break;
            case CREATE_A_CUSTOMER:
                createCustomer();
                break;
            case EXIT:
                menuItem = MenuItem.UNKNOWN;
                return false;
            default:
        }
        return true;
    }

    private void createCustomer() throws IOException {
        CarSharingUtil.println("CUSTOMER_NAME_INPUT_COMMAND");
        String name = new Scanner(System.in).nextLine();
        this.controllerFactory.getCustomerController().update(name);
        CarSharingUtil.println("CUSTOMER_CREATION_SUCCEED_MSG");
        System.out.println();
    }
}
