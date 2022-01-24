package carsharing.service;

import carsharing.model.Car;

import java.util.List;

public interface CarDao {

    boolean save(String name, int companyId);
    List<Car> findCarByCompanyId(int companyId);
    Car findById(int rentedCarId);
}
