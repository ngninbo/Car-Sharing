package carsharing.controller;

import carsharing.model.Car;
import carsharing.model.Customer;
import carsharing.service.CustomerDao;
import carsharing.util.CarSharingUtil;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static carsharing.util.CarSharingConstants.BACK_OPTION;

public class CustomerController {

    private final CustomerDao customerDao;

    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    private void update(String name) {
        customerDao.save(name);
    }

    public Customer findById(int id) {
        return customerDao.findById(id);
    }


    public void rentCar(int customerId, String companyName, List<Car> cars) throws IOException {
        if (cars.isEmpty()) {
            CarSharingUtil.printf("CAR_IN_COMPANY_NO_AVAILABLE_INFO", companyName);
        } else {
            CarSharingUtil.printOptions("CUSTOMER_CAR_CHOICE_COMMAND", cars);
            System.out.printf("%s. %s%n", 0, BACK_OPTION);
            int carIndex = new Scanner(System.in).nextInt() - 1;
            if (carIndex != -1) {
                this.updateWhenRent(customerId, cars.get(carIndex).getId());
                CarSharingUtil.printf("CUSTOMER_RENT_CAR_NAME_INFO", cars.get(carIndex).getName());
                System.out.println();
            }
        }
    }

    public void returnRentedCar(int id) throws IOException {
        Customer customer = this.findById(id);

        if (customer.getRentedCarId() == 0) {
            CarSharingUtil.println("CUSTOMER_CAR_NOT_RENT_INFO");
        } else {
            this.updateWhenReturn(customer.getId());
            CarSharingUtil.println("CUSTOMER_RENT_CAR_RETURN_SUCCEED_MSG");
        }
    }

    public void createCustomer() throws IOException {
        CarSharingUtil.println("CUSTOMER_NAME_INPUT_COMMAND");
        String name = new Scanner(System.in).nextLine();
        this.update(name);
        CarSharingUtil.println("CUSTOMER_CREATION_SUCCEED_MSG");
        System.out.println();
    }

    private void updateWhenReturn(int id) {
        customerDao.updateWhenReturn(id);
    }

    private void updateWhenRent(int id, int rentedCarId) {
        customerDao.updateWhenRent(id, rentedCarId);
    }
}
