package carsharing.menu;

import carsharing.command.CustomerCommand;
import carsharing.controller.ControllerFactory;
import carsharing.model.Customer;
import carsharing.util.CarSharingUtil;

import java.util.List;

public class CustomerMenu extends Menu {

    private int customerIndex;
    private final List<Customer> customers;
    private final ControllerFactory factory;

    public CustomerMenu(ControllerFactory factory) {
        super(MenuItem.customerMenuItems());
        this.factory = factory;
        this.customers = factory.getCustomerController().findAll();
    }

    @Override
    public int display() {
        System.out.println();
        return choice();
    }

    @Override
    public boolean process(MenuItem item) {

        if (!new CustomerCommand(factory, customers.get(customerIndex).getId()).execute(item)) {
            menuItem = MenuItem.UNKNOWN;
            return false;
        }

        return true;
    }

    @Override
    public void process() {

        if (customers.isEmpty()) {
            CarSharingUtil.println("CUSTOMER_LIST_EMPTY_INFO");
            System.out.println();
        } else {
            chooseAndProcess();
        }
    }

    private void chooseAndProcess() {
        while (true) {
            this.customerIndex = new ListView<>(customers).choice("CUSTOMER_LIST_LABEL");

            if (customerIndex == -1) {
                System.out.println();
                return;
            }

            super.process();
        }
    }
}
