package carsharing.client;

import carsharing.command.CustomerClientOption;
import carsharing.controller.CarController;
import carsharing.controller.CompanyController;
import carsharing.controller.CustomerController;
import carsharing.model.Customer;
import carsharing.util.CarSharingUtil;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static carsharing.util.CarSharingConstants.BACK_OPTION;

public class CustomerClient extends Client {

    private final CustomerController customerController;

    public CustomerClient(
            CompanyController companyController,
            CustomerController customerController,
            CarController carController
    ) {
        super(companyController, carController);
        this.customerController = customerController;
    }

    @Override
    public void process() throws IOException {

        List<Customer> customers = customerController.findAll();

        CustomerClientOption customerClientOption = new CustomerClientOption(customerController, carController, companyController);

        if (customers.isEmpty()) {
            CarSharingUtil.println("CUSTOMER_LIST_EMPTY_INFO");
        } else {
            while (isLoggedIn()) {

                CarSharingUtil.printOptions("CUSTOMER_LIST_LABEL", customers);
                System.out.printf("%s. %s%n", 0, BACK_OPTION);

                int customerIndex = new Scanner(System.in).nextInt() - 1;

                if (customerIndex == -1) {
                    System.out.println();
                } else {

                    while (isLoggedIn()) {
                        System.out.println();
                        CarSharingUtil.printCustomerOptions();

                        int selection = new Scanner(System.in).nextInt();

                        int customerId = customers.get(customerIndex).getId();
                        switch (selection) {
                            case 1:
                                customerClientOption.rentACar(customerId);
                                break;
                            case 2:
                                customerController.returnRentedCar(customerId);
                                break;
                            case 3:
                                customerClientOption.showMyRentedCar(customerId);
                                break;
                            case 0:
                                logout();
                                break;
                        }
                    }
                }
            }
        }
    }
}
