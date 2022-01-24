package carsharing;

import carsharing.view.CarSharing;

public class Main {

    public static void main(String[] args) {
        // write your code here
        CarSharing.init(args[1]).build().start();
    }
}