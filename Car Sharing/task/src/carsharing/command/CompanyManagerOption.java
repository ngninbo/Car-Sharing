package carsharing.command;

import carsharing.controller.CarController;
import carsharing.model.Car;
import carsharing.util.CarSharingUtil;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CompanyManagerOption {

    private final CarController controller;
    private boolean exit;

    public CompanyManagerOption(CarController controller) {
        this.controller = controller;
    }

    public void createCar(int companyId) throws IOException {
        CarSharingUtil.println("CAR_NAME_INPUT_COMMAND");
        String name = new Scanner(System.in).nextLine();
        boolean saveSucceed = this.controller.save(name, companyId);
        if (saveSucceed) {
            CarSharingUtil.println("CAR_CREATION_SUCCEED_MSG");
            System.out.println();
        }
    }

    public void showCarList(int companyId) throws IOException {
        List<Car> cars = this.controller.findCarByCompanyId(companyId);
        if (cars.isEmpty()) {
            CarSharingUtil.println("CAR_LIST_EMPTY_INFO");
        } else {
            CarSharingUtil.printOptions("CAR_LIST_OVERVIEW_LABEL", cars);
            System.out.println();
        }
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public boolean close() {
        return exit;
    }
}
