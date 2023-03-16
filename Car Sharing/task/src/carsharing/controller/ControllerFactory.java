package carsharing.controller;

import carsharing.repository.RepositoryFactory;
import carsharing.service.CarDaoImpl;
import carsharing.service.CompanyDaoImpl;
import carsharing.service.CustomerDaoImpl;

public class ControllerFactory {

    private final RepositoryFactory repositoryFactory;

    public ControllerFactory(RepositoryFactory repositoryFactory) {
        this.repositoryFactory = repositoryFactory;
    }

    public CompanyController getCompanyController() {
        return new CompanyController(new CompanyDaoImpl(repositoryFactory.getCompanyRepository()));
    }

    public CarController getCarController() {
        return new CarController(new CarDaoImpl(repositoryFactory.getCarRepository()));
    }

    public CustomerController getCustomerController() {
        return new CustomerController(new CustomerDaoImpl(repositoryFactory.getCustomerRepository()));
    }
}
