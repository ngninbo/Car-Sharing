package carsharing;

import carsharing.view.CarSharingBuilder;

public class Main {

    public static void main(String[] args) {

        new CarSharingBuilder()
                .init(args[1])
                .withDatabase()
                .withCompanyController()
                .withCarController()
                .withCustomerController()
                .build()
                .start();
    }
}