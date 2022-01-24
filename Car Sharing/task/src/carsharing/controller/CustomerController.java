package carsharing.controller;

import carsharing.model.Car;
import carsharing.model.Customer;
import carsharing.service.CustomerDao;
import carsharing.util.CarSharingUtil;

import java.util.List;
import java.util.Scanner;

import static carsharing.util.CarSharingConstants.*;

public class CustomerController {

    private final CustomerDao customerDao;

    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    public void update(String name) {
        customerDao.save(name);
    }

    public Customer findById(int id) {
        return customerDao.findById(id);
    }

    public void updateWhenReturn(int id) {
        customerDao.updateWhenReturn(id);
    }

    public void updateWhenRent(int id, int rentedCarId) {
        customerDao.updateWhenRent(id, rentedCarId);
    }


    public boolean rentCar(int customerId, String companyName, List<Car> cars) {
        if (cars.isEmpty()) {
            System.out.printf(CAR_IN_COMPANY_NO_AVAILABLE_INFO, companyName);
        } else {
            CarSharingUtil.printOptions(CUSTOMER_CAR_CHOICE_COMMAND, cars, true);
            int carIndex = new Scanner(System.in).nextInt() - 1;
            if (carIndex == -1) {
                return true;
            } else {
                this.updateWhenRent(customerId, cars.get(carIndex).getId());
                System.out.printf(CUSTOMER_RENT_CAR_NAME_INFO, cars.get(carIndex).getName());
            }
        }

        return false;
    }

    public void returnRentedCar(int id) {
        Customer customer = this.findById(id);

        if (customer.getRentedCarId() == 0) {
            System.out.println(CUSTOMER_CAR_NOT_RENT_INFO);
        } else {
            this.updateWhenReturn(customer.getId());
            System.out.println(CUSTOMER_RENT_CAR_RETURN_SUCCEED_MSG);
        }
    }

    public void createCustomer() {
        System.out.println(CUSTOMER_NAME_INPUT_COMMAND);
        String name = new Scanner(System.in).nextLine();
        this.update(name);
        System.out.println(CUSTOMER_CREATION_SUCCEED_MSG);
    }
}
