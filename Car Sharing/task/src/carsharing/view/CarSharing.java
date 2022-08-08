package carsharing.view;

import carsharing.controller.CarController;
import carsharing.controller.CompanyController;
import carsharing.controller.CustomerController;
import carsharing.model.Car;
import carsharing.model.Company;
import carsharing.model.Customer;
import carsharing.util.CarSharingUtil;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static carsharing.util.CarSharingConstants.*;

public class CarSharing {

    private final CompanyController companyController;
    private final CarController carController;
    private final CustomerController customerController;
    private boolean exit = false;

    public CarSharing(CompanyController companyController, CarController carController,
                      CustomerController customerController) {
        this.companyController = companyController;
        this.carController = carController;
        this.customerController = customerController;
    }

    public void start() throws IOException {

        do {
            CarSharingUtil.printOptions(List.of(
                    "Log in as a manager",
                    "Log in as a customer",
                    "Create a customer",
                    "Exit"));
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

    private void logInAsManager() throws IOException {

        boolean goBack = false;
        do {
            System.out.println();
            CarSharingUtil.printOptions(List.of(
                    "Company list",
                    "Create a company",
                    BACK_OPTION));

            int action = new Scanner(System.in).nextInt();

            switch (action) {
                case 1:
                    manageCompany();
                    break;
                case 2:
                    companyController.createCompany();
                    break;
                case 0:
                    goBack = CarSharingUtil.println();
            }
        } while (!goBack);
    }

    private void logInAsCustomer() throws IOException {

        boolean goToMainMenu = false;

        List<Customer> customers = customerController.findAll();

        if (customers.isEmpty()) {
            CarSharingUtil.println("CUSTOMER_LIST_EMPTY_INFO");
        } else {
            while (!goToMainMenu) {

                CarSharingUtil.printOptions("CUSTOMER_LIST_LABEL", customers);
                System.out.printf("%s. %s%n", 0, BACK_OPTION);

                int customerIndex = new Scanner(System.in).nextInt() - 1;

                if (customerIndex == -1) {
                    goToMainMenu = CarSharingUtil.println();
                } else {

                    while (!goToMainMenu) {
                        System.out.println();
                        CarSharingUtil.printOptions(List.of(
                                "Rent a car",
                                "Return a rented car",
                                "My rented car",
                                BACK_OPTION));

                        int selection = new Scanner(System.in).nextInt();

                        int customerId = customers.get(customerIndex).getId();
                        switch (selection) {
                            case 1:
                                rentACar(customerId);
                                break;
                            case 2:
                                customerController.returnRentedCar(customerId);
                                break;
                            case 3:
                                showMyRentedCar(customerId);
                                break;
                            case 0:
                                goToMainMenu = CarSharingUtil.println();
                                break;
                        }
                    }
                }
            }
        }

    }

    private void showMyRentedCar(int customerId) throws IOException {
        Customer customer = customerController.findById(customerId);

        final int rentedCarId = customer.getRentedCarId();

        if (rentedCarId == 0) {
            CarSharingUtil.println("CUSTOMER_CAR_NOT_RENT_INFO");
        } else {
            Car car = carController.findById(rentedCarId);
            String companyName = companyController.findCompanyById(car.getCompanyId()).getName();
            CarSharingUtil.printf("CUSTOMER_RENTED_CAR_INFO", car.getName(), companyName);
            System.out.println();
        }
    }

    private void rentACar(int customerId) throws IOException {
        List<Company> companies = companyController.findAll();
        Customer customer = customerController.findById(customerId);
        if (companies.isEmpty()) {
            CarSharingUtil.println("COMPANY_LIST_EMPTY_INFO");
        } else if (customer.getRentedCarId() > 0) {
            CarSharingUtil.println("CUSTOMER_CAR_ALREADY_RENT_INFO");
        } else {
            CarSharingUtil.printOptions("COMPANY_CHOICE_COMMAND", companies);
            System.out.printf("%s. %s%n", 0, BACK_OPTION);

            int companyIndex = new Scanner(System.in).nextInt() - 1;
            if (companyIndex != -1) {
                List<Car> cars = getAvailableCars(companies.get(companyIndex).getId());
                customerController.rentCar(customerId, companies.get(companyIndex).getName(), cars);
            }
        }
    }

    private void manageCompany() throws IOException {
        List<Company> companies = companyController.findAll();

        if (companies.isEmpty()) {
            CarSharingUtil.println("COMPANY_LIST_EMPTY_INFO");
        } else {

            boolean goToManagerMenu = false;

            while (!goToManagerMenu) {
                CarSharingUtil.printOptions("COMPANY_CHOICE_COMMAND", companies);
                System.out.printf("%s. %s%n", 0, BACK_OPTION);
                int companyIndex = new Scanner(System.in).nextInt() - 1;

                if (companyIndex == -1) {
                    goToManagerMenu = true;
                } else {
                    Company company = companies.get(companyIndex);
                    CarSharingUtil.printf("COMPANY_NAME_LABEL", company.getName());
                    System.out.println();

                    do {
                        CarSharingUtil.printOptions(List.of(
                                "Car list",
                                "Create a car",
                                BACK_OPTION));
                        int choice = new Scanner(System.in).nextInt();
                        goToManagerMenu = carController.handleInput(company.getId(), choice);
                    } while (!goToManagerMenu);
                }
            }
        }
    }

    private List<Car> getAvailableCars(int companyId) {

        List<Customer> customers = customerController.findAll();

        List<Integer> rentedCarIds = customers.stream()
                .map(Customer::getRentedCarId)
                .distinct()
                .collect(Collectors.toList());

        Predicate<Car> isAvailable = car -> rentedCarIds.stream().allMatch(integer -> car.getId() != integer);

        return carController.findCarByCompanyId(companyId)
                .stream()
                .filter(isAvailable)
                .collect(Collectors.toList());
    }
}
