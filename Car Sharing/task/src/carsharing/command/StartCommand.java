package carsharing.command;

import carsharing.controller.ControllerFactory;
import carsharing.menu.CustomerMenu;
import carsharing.menu.ManagerMenu;
import carsharing.util.CarSharingUtil;
import carsharing.util.MenuItem;

import java.io.IOException;

import static carsharing.util.CarSharingUtil.enter;

public class StartCommand implements Command {

    private final ControllerFactory controllerFactory;

    public StartCommand(ControllerFactory factory) {
        this.controllerFactory = factory;
    }

    @Override
    public boolean execute(MenuItem item) throws IOException {
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
                return false;
            default:
        }
        return true;
    }

    private void createCustomer() throws IOException {
        String name = enter("CUSTOMER_NAME_INPUT_COMMAND");
        this.controllerFactory.getCustomerController().update(name);
        CarSharingUtil.println("CUSTOMER_CREATION_SUCCEED_MSG");
        System.out.println();
    }
}
