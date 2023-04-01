package carsharing.controller;

import carsharing.model.Customer;
import carsharing.service.CustomerDao;
import java.util.List;
import java.util.Optional;

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

    public Optional<Customer> findById(int id) {
        return customerDao.findById(id);
    }

    public void updateWhenReturn(int id) {
        customerDao.updateWhenReturn(id);
    }

    public void updateWhenRent(int id, int rentedCarId) {
        customerDao.updateWhenRent(id, rentedCarId);
    }
}
