package carsharing;

import carsharing.view.CarSharingBuilder;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        CarSharingBuilder.init(args[1])
                .withDatabase()
                .withControllerFactory()
                .build()
                .start();
    }
}