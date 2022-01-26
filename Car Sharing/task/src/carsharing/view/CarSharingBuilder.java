package carsharing.view;

import carsharing.controller.CarController;
import carsharing.controller.CompanyController;
import carsharing.controller.CustomerController;
import carsharing.repository.BaseRepository;
import carsharing.repository.CarRepository;
import carsharing.repository.CompanyRepository;
import carsharing.repository.CustomerRepository;
import carsharing.service.CarDaoImpl;
import carsharing.service.CompanyDaoImpl;
import carsharing.service.CustomerDaoImpl;

public class CarSharingBuilder {

    private CompanyController companyController;
    private CarController carController;
    private CustomerController customerController;
    private final String databaseFilename;

    private CarSharingBuilder(String databaseFilename) {
        this.databaseFilename = databaseFilename != null ? databaseFilename : "carSharing";
    }

    public static CarSharingBuilder init(String databaseFilename) {
        return new CarSharingBuilder(databaseFilename);
    }

    public CarSharingBuilder withDatabase() {
        BaseRepository.createDatabaseTable(databaseFilename);
        return this;
    }

    public CarSharingBuilder withCompanyController() {
        this.companyController = new CompanyController(new CompanyDaoImpl(CompanyRepository.init(databaseFilename)));
        return this;
    }

    public CarSharingBuilder withCarController() {
        this.carController = new CarController(new CarDaoImpl(CarRepository.init(databaseFilename)));
        return this;
    }

    public CarSharingBuilder withCustomerController() {
        this.customerController = new CustomerController(new CustomerDaoImpl(CustomerRepository.init(databaseFilename)));
        return this;
    }

    public CarSharing build() {
        return new CarSharing(companyController, carController, customerController);
    }
}