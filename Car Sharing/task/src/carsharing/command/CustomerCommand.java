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

import java.util.List;
import java.util.stream.Collectors;

public class CustomerCommand implements Command {

    private final CustomerController customerController;
    private final CarController carController;
    private final CompanyController companyController;

    private Customer customer;

    public CustomerCommand(ControllerFactory factory) {
        this.customerController = factory.getCustomerController();
        this.carController = factory.getCarController();
        this.companyController = factory.getCompanyController();
    }

    public CustomerCommand(ControllerFactory factory, int customerId) {
        this(factory);
        this.customer = customerController.findById(customerId).orElseThrow();
    }

    @Override
    public boolean execute(MenuItem item) {
        switch (item) {
            case RENT_A_CAR:
                rentACar();
                break;
            case RETURN_A_RENTED_CAR:
                returnRentedCar();
                break;
            case MY_RENTED_CAR:
                showMyRentedCar();
                break;
            case BACK:
                return false;
        }

        return true;
    }

    protected void rentACar() {
        List<Company> companies = companyController.findAll();
        if (companies.isEmpty()) {
            CarSharingUtil.println("COMPANY_LIST_EMPTY_INFO");
        } else if (customer.getRentedCarId() > 0) {
            CarSharingUtil.println("CUSTOMER_CAR_ALREADY_RENT_INFO");
        } else {
            int companyIndex = new ListView<>(companies).choice("COMPANY_CHOICE_COMMAND");
            if (companyIndex != -1) {
                rentCar(customer.getId(), companies.get(companyIndex).getName(), getAvailableCars(companies.get(companyIndex).getId()));
            }
        }
    }

    protected void showMyRentedCar() {

        final int rentedCarId = customer.getRentedCarId();

        if (rentedCarId == 0) {
            CarSharingUtil.println("CUSTOMER_CAR_NOT_RENT_INFO");
        } else {
            carController.findById(rentedCarId).ifPresent(car -> {
                String companyName = companyController.findCompanyById(car.getCompanyId()).orElseThrow().getName();
                CarSharingUtil.printf("CUSTOMER_RENTED_CAR_INFO", car.getName(), companyName);
                System.out.println();
            });
        }
    }

    protected void returnRentedCar() {

        if (customer.getRentedCarId() == 0) {
            CarSharingUtil.println("CUSTOMER_CAR_NOT_RENT_INFO");
        } else {
            this.customerController.updateWhenReturn(customer.getId());
            CarSharingUtil.println("CUSTOMER_RENT_CAR_RETURN_SUCCEED_MSG");
        }
    }

    private void rentCar(int customerId, String companyName, List<Car> cars) {
        if (cars.isEmpty()) {
            CarSharingUtil.printf("CAR_IN_COMPANY_NO_AVAILABLE_INFO", companyName);
            System.out.println();
        } else {
            int carIndex = new ListView<>(cars).choice("CUSTOMER_CAR_CHOICE_COMMAND");
            if (carIndex != -1) {
                this.customerController.updateWhenRent(customerId, cars.get(carIndex).getId());
                CarSharingUtil.printf("CUSTOMER_RENT_CAR_NAME_INFO", cars.get(carIndex).getName());
                System.out.println();
            }
        }
    }

    private List<Car> getAvailableCars(int companyId) {
        return carController.findCarByCompanyId(companyId)
                .stream()
                .filter(this::isAvailable)
                .collect(Collectors.toList());
    }

    private boolean isAvailable(Car car) {
        return customerController.findAll()
                .stream()
                .map(Customer::getRentedCarId)
                .distinct()
                .allMatch(integer -> car.getId() != integer);
    }
}
