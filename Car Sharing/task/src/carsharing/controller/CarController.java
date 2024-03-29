package carsharing.controller;

import carsharing.model.Car;
import carsharing.service.CarDao;
import java.util.List;
import java.util.Optional;

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

    public Optional<Car> findById(int rentedCarId) {
        return carDao.findById(rentedCarId);
    }

}
