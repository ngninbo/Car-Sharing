package carsharing.view;

import carsharing.client.Client;
import carsharing.client.CustomerClient;
import carsharing.client.ManagerClient;
import carsharing.controller.CarController;
import carsharing.controller.CompanyController;
import carsharing.controller.CustomerController;
import carsharing.util.CarSharingUtil;

import java.io.IOException;
import java.util.Scanner;

public class CarSharing {

    private final CompanyController companyController;
    private final CarController carController;
    private final CustomerController customerController;
    private Client client;
    private boolean exit = false;

    public CarSharing(CompanyController companyController, CarController carController,
                      CustomerController customerController) {
        this.companyController = companyController;
        this.carController = carController;
        this.customerController = customerController;
    }

    public void start() throws IOException {

        do {
            CarSharingUtil.printMainOptions();
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    client = new ManagerClient(companyController, carController).run();
                    break;
                case 2:
                    client = new CustomerClient(companyController, customerController, carController).run();
                    break;
                case 3:
                    customerController.createCustomer();
                    break;
                case 0:
                    exit = client.exit();
            }
        } while (!exit);
    }
}
