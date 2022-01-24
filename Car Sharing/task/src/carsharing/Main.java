package carsharing;

import carsharing.view.CarSharing;

public class Main {

    public static void main(String[] args) {
        
        CarSharing.init(args[1])
                .createDatabaseTable()
                .build()
                .start();
    }
}