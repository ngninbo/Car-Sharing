package carsharing.controller;

import carsharing.model.Car;
import carsharing.service.CarDao;
import carsharing.util.CarSharingUtil;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CarController {

    private final CarDao carDao;

    public CarController(CarDao carDao) {
        this.carDao = carDao;
    }

    public boolean save(String name, int companyId) {
        return carDao.save(name, companyId);
    }

    public List<Car> findCarByCompanyId(int companyId) {
        return carDao.findCarByCompanyId(companyId);
    }

    public Car findById(int rentedCarId) {
        return carDao.findById(rentedCarId);
    }

    private void createCar(int companyId) throws IOException {
        CarSharingUtil.println("CAR_NAME_INPUT_COMMAND");
        String name = new Scanner(System.in).nextLine();
        boolean saveSucceed = this.save(name, companyId);
        if (saveSucceed) {
            CarSharingUtil.println("CAR_CREATION_SUCCEED_MSG");
            System.out.println();
        }
    }

    private void showCarList(int companyId) throws IOException {
        List<Car> cars = this.findCarByCompanyId(companyId);
        if (cars.isEmpty()) {
            CarSharingUtil.println("CAR_LIST_EMPTY_INFO");
        } else {
            CarSharingUtil.printOptions("CAR_LIST_OVERVIEW_LABEL", cars, false);
            System.out.println();
        }
    }

    public boolean handleInput(int companyId, int choice) throws IOException {
        boolean isTrue = false;
        switch (choice) {
            case 1:
                this.showCarList(companyId);
                break;
            case 2:
                this.createCar(companyId);
                break;
            case 0:
                isTrue =  true;
                break;
        }

        return isTrue;
    }
}
