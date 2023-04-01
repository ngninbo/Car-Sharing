package carsharing;

import carsharing.view.CarSharingBuilder;

public class Main {

    public static void main(String[] args) {

        CarSharingBuilder.init(args[1])
                .withControllerFactory()
                .withDatabase()
                .build()
                .start();
    }
}