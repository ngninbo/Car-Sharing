package carsharing.command;

import carsharing.controller.CarController;
import carsharing.controller.CompanyController;
import carsharing.controller.ControllerFactory;
import carsharing.controller.CustomerController;
import carsharing.menu.ListView;
import carsharing.model.Car;
import carsharing.model.Company;
import carsharing.model.Customer;
import carsharing.util.CarSharingUtil;
import carsharing.menu.MenuItem;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomerCommand implements Command {

    private final CustomerController customerController;
    private final CarController carController;
    private final CompanyController companyController;

    private int customerId;

    public CustomerCommand(ControllerFactory factory) {
        this.customerController = factory.getCustomerController();
        this.carController = factory.getCarController();
        this.companyController = factory.getCompanyController();
    }

    public CustomerCommand(ControllerFactory factory, int customerId) {
        this(factory);
        this.customerId = customerId;
    }

    @Override
    public boolean execute(MenuItem item) throws IOException {
        switch (item) {
            case RENT_A_CAR:
                rentACar(customerId);
                break;
            case RETURN_A_RENTED_CAR:
                returnRentedCar(customerId);
                break;
            case MY_RENTED_CAR:
                showMyRentedCar(customerId);
                break;
            case BACK:
                return false;

        }

        return true;
    }

    protected void rentACar(int customerId) throws IOException {
        List<Company> companies = companyController.findAll();
        Customer customer = customerController.findById(customerId);
        if (companies.isEmpty()) {
            CarSharingUtil.println("COMPANY_LIST_EMPTY_INFO");
        } else if (customer.getRentedCarId() > 0) {
            CarSharingUtil.println("CUSTOMER_CAR_ALREADY_RENT_INFO");
        } else {
            int companyIndex = new ListView<>(companies).choice("COMPANY_CHOICE_COMMAND") - 1;
            if (companyIndex != -1) {
                List<Car> cars = getAvailableCars(companies.get(companyIndex).getId());
                rentCar(customer.getId(), companies.get(companyIndex).getName(), cars);
            }
        }
    }

    protected void showMyRentedCar(int customerId) throws IOException {
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

    protected void returnRentedCar(int id) throws IOException {

        Customer customer = this.customerController.findById(id);
        if (customer.getRentedCarId() == 0) {
            CarSharingUtil.println("CUSTOMER_CAR_NOT_RENT_INFO");
        } else {
            this.customerController.updateWhenReturn(customer.getId());
            CarSharingUtil.println("CUSTOMER_RENT_CAR_RETURN_SUCCEED_MSG");
        }
    }

    private void rentCar(int customerId, String companyName, List<Car> cars) throws IOException {
        if (cars.isEmpty()) {
            CarSharingUtil.printf("CAR_IN_COMPANY_NO_AVAILABLE_INFO", companyName);
            System.out.println();
        } else {
            int carIndex = new ListView<>(cars).choice("CUSTOMER_CAR_CHOICE_COMMAND") - 1;
            if (carIndex != -1) {
                this.customerController.updateWhenRent(customerId, cars.get(carIndex).getId());
                CarSharingUtil.printf("CUSTOMER_RENT_CAR_NAME_INFO", cars.get(carIndex).getName());
                System.out.println();
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
