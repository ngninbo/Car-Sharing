package carsharing.service;

import carsharing.model.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> findAll();
    void save(String name);

    Customer findById(int id);

    void updateWhenReturn(int id);
    void updateWhenRent(int id, int rentedCarId);
}
