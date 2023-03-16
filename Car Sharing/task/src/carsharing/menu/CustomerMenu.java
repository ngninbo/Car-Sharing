package carsharing.menu;

import carsharing.command.CustomerClientOption;
import carsharing.controller.ControllerFactory;
import carsharing.model.Customer;
import carsharing.util.CarSharingUtil;
import carsharing.util.MenuItem;

import java.io.IOException;
import java.util.List;

public class CustomerMenu extends Menu {

    private static final List<MenuItem> CUSTOMER_MENU_OPTIONS = MenuItem.CUSTOMER_MENU_OPTIONS;

    private int customerIndex;
    private final List<Customer> customers;
    private final ControllerFactory factory;

    public CustomerMenu(ControllerFactory factory) {
        super(CUSTOMER_MENU_OPTIONS);
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
        CustomerClientOption customerClientOption = new CustomerClientOption(factory);

        int customerId = customers.get(customerIndex).getId();

        switch (item) {
            case RENT_A_CAR:
                customerClientOption.rentACar(customerId);
                break;
            case RETURN_A_RENTED_CAR:
                customerClientOption.returnRentedCar(customerId);
                break;
            case MY_RENTED_CAR:
                customerClientOption.showMyRentedCar(customerId);
                break;
            case BACK:
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
