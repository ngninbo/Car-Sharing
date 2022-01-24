package carsharing.service;

import carsharing.model.Car;
import carsharing.repository.CarRepository;

import java.util.List;

public class CarDaoImpl implements CarDao {

    private final CarRepository carRepository;

    public CarDaoImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public boolean save(String name, int companyId) {
       return carRepository.save(name, companyId);
    }

    @Override
    public List<Car> findCarByCompanyId(int companyId) {
        return carRepository.findCarByCompanyId(companyId);
    }

    @Override
    public Car findById(int rentedCarId) {
        return carRepository.findById(rentedCarId);
    }

}
