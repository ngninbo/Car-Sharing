package carsharing.command;

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

import static carsharing.util.CarSharingConstants.BACK_OPTION;

public class CustomerClientOption {

    private final CustomerController customerController;
    private final CarController carController;
    private final CompanyController companyController;

    public CustomerClientOption(CustomerController customerController,
                                CarController carController,
                                CompanyController companyController) {
        this.customerController = customerController;
        this.carController = carController;
        this.companyController = companyController;
    }

    public void rentACar(int customerId) throws IOException {
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

    public void showMyRentedCar(int customerId) throws IOException {
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
