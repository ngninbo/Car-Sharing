package carsharing.service;

import carsharing.model.Car;

import java.util.List;

public interface CarDao extends CarSharingDao<Car> {

    boolean save(String name, int companyId);
    List<Car> findCarByCompanyId(int companyId);
}
