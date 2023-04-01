package carsharing.menu;

import carsharing.command.CustomerCommand;
import carsharing.controller.ControllerFactory;
import carsharing.model.Customer;
import carsharing.util.CarSharingUtil;

import java.io.IOException;
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
    public boolean process(MenuItem item) throws IOException {

        int customerId = customers.get(customerIndex).getId();

        if (!new CustomerCommand(factory, customerId).execute(item)) {
            menuItem = MenuItem.UNKNOWN;
            return false;
        }

        return true;
    }

    @Override
    public void process() throws IOException {

        if (customers.isEmpty()) {
            CarSharingUtil.println("CUSTOMER_LIST_EMPTY_INFO");
            System.out.println();
        } else {
            while (true) {
                this.customerIndex = new ListView<>(customers).choice("CUSTOMER_LIST_LABEL") - 1;

                if (customerIndex == -1) {
                    System.out.println();
                    return;
                }

                super.process();
            }
        }
    }
}
