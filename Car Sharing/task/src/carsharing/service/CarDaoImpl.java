package carsharing.service;

import carsharing.model.Car;
import carsharing.repository.CarRepository;

import java.util.List;
import java.util.Optional;

/**
 * Data Access Object concrete class.
 * This class implements the CarDao interface
 * @see carsharing.service.CarDao
 * @author Beauclair Dongmo Ngnintedem
 */
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
    public Optional<Car> findById(int rentedCarId) {
        return carRepository.findById(rentedCarId);
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public void save(String name) {

    }
}
