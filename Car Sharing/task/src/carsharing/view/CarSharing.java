package carsharing.view;

import carsharing.controller.CarController;
import carsharing.controller.CompanyController;
import carsharing.controller.CustomerController;
import carsharing.model.Car;
import carsharing.model.Company;
import carsharing.model.Customer;
import carsharing.repository.BaseRepository;
import carsharing.repository.CarRepository;
import carsharing.repository.CompanyRepository;
import carsharing.repository.CustomerRepository;
import carsharing.service.CarDaoImpl;
import carsharing.service.CompanyDaoImpl;
import carsharing.service.CustomerDaoImpl;
import carsharing.util.CarSharingUtil;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static carsharing.util.CarSharingConstants.*;

public class CarSharing {

    private CompanyController companyController;
    private CarController carController;
    private CustomerController customerController;
    private boolean goBack = false;
    private boolean exit = false;
    boolean exitCustomerMenu = false;
    private final String databaseFilename;


    private CarSharing(String databaseFilename) {
        this.databaseFilename = databaseFilename != null ? databaseFilename : "carSharing";
    }

    public static CarSharing init(String databaseFilename) {
        return new CarSharing(databaseFilename);
    }

    public CarSharing createDatabaseTable() {
        BaseRepository.createDatabaseTable(databaseFilename);
        return this;
    }

    public CarSharing build() {

        companyController = new CompanyController(new CompanyDaoImpl(CompanyRepository.init(databaseFilename)));

        carController = new CarController(new CarDaoImpl(CarRepository.init(databaseFilename)));

        customerController = new CustomerController(new CustomerDaoImpl(CustomerRepository.init(databaseFilename)));
        return this;
    }

    public void start() {


        do {
            CarSharingUtil.displayMainMenu();
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    logInAsManager();
                    break;
                case 2:
                    logInAsCustomer();
                    break;
                case 3:
                    customerController.createCustomer();
                    break;
                case 0:
                    exit = true;
            }
        } while (!exit);
    }

    private void logInAsManager() {

        do {
            System.out.println();
            CarSharingUtil.printOptions(managerMenuOptions);

            int action = new Scanner(System.in).nextInt();

            switch (action) {
                case 1:
                    manageCompany();
                    break;
                case 2:
                    companyController.createCompany();
                    break;
                case 0:
                    navBack();
            }
        } while (!goBack);
    }

    private void logInAsCustomer() {

        boolean goToMainMenu = false;

        List<Customer> customers = customerController.findAll();

        if (customers.isEmpty()) {
            System.out.println(CUSTOMER_LIST_EMPTY_INFO);
        } else {
            while (!goToMainMenu) {

                CarSharingUtil.printOptions(CUSTOMER_LIST_LABEL, customers, true);

                int customerIndex = new Scanner(System.in).nextInt() - 1;

                if (customerIndex == -1) {
                    goToMainMenu = true;
                    System.out.println();
                } else {

                    while (!goToMainMenu) {
                        System.out.println();
                        CarSharingUtil.printOptions(customerMenuOptions);

                        int selection = new Scanner(System.in).nextInt();

                        switch (selection) {
                            case 1:
                                exitCustomerMenu = rentACar(customers.get(customerIndex).getId());
                                break;
                            case 2:
                                customerController.returnRentedCar(customers.get(customerIndex).getId());
                                break;
                            case 3:
                                showMyRentedCar(customers.get(customerIndex).getId());
                                break;
                            case 0:
                                goToMainMenu = true;
                                System.out.println();
                                break;
                        }
                    }
                }
            }
        }

    }

    private void showMyRentedCar(int customerId) {
        Customer customer = customerController.findById(customerId);

        final int rentedCarId = customer.getRentedCarId();

        if (rentedCarId == 0) {
            System.out.println(CUSTOMER_CAR_NOT_RENT_INFO);
        } else {
            System.out.println(CUSTOMER_RENT_CAR_INFO);
            Car car = carController.findById(rentedCarId);
            System.out.println(car.getName());
            System.out.println(COMPANY_LABEL);
            System.out.println(companyController.findCompanyById(car.getCompanyId()).getName());
        }
    }

    private boolean rentACar(int customerId) {
        boolean goBack = false;
        List<Company> companies = companyController.findAll();
        Customer customer = customerController.findById(customerId);
        if (companies.isEmpty()) {
            System.out.println(COMPANY_LIST_EMPTY_INFO);
        } else if (customer.getRentedCarId() > 0) {
            System.out.println(CUSTOMER_CAR_ALREADY_RENT_INFO);
        } else {
            CarSharingUtil.printOptions(COMPANY_CHOICE_COMMAND, companies, true);

            int companyIndex = new Scanner(System.in).nextInt() - 1;
            if (companyIndex == -1) {
                return true;
            } else {

                List<Car> cars = carController.findCarByCompanyId(companies.get(companyIndex).getId());
                List<Car> availableCars = getAvailableCars(cars);

                goBack = customerController.rentCar(
                        customerId,
                        companies.get(companyIndex).getName(),
                        availableCars);
            }
        }
        return goBack;
    }


    private void manageCompany() {
        List<Company> companies = companyController.findAll();

        if (companies.isEmpty()) {
            System.out.println(COMPANY_LIST_EMPTY_INFO);
        } else {

            boolean goToManagerMenu = false;

            while (!goToManagerMenu) {
                CarSharingUtil.printOptions(COMPANY_CHOICE_COMMAND, companies, true);
                int companyIndex = new Scanner(System.in).nextInt() - 1;

                if (companyIndex == -1) {
                    goToManagerMenu = true;
                } else {
                    System.out.printf(COMPANY_NAME_LABEL, companies.get(companyIndex).getName());

                    while (!goToManagerMenu) {
                        CarSharingUtil.printOptions(carMenuOptions);
                        int choice = new Scanner(System.in).nextInt();
                        goToManagerMenu = carController.handleInput(companies.get(companyIndex).getId(), choice);
                    }
                }
            }
        }
    }


    private List<Car> getAvailableCars(List<Car> cars) {
        List<Customer> customers = customerController.findAll();
        List<Integer> list = customers.stream()
                .map(Customer::getRentedCarId)
                .distinct()
                .collect(Collectors.toList());

        return cars
                .stream()
                .filter(car -> !list.contains(car.getId()))
                .collect(Collectors.toList());
    }

    private void navBack() {
        goBack = true;
        System.out.println();
    }
}
