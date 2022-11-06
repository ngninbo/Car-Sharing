package carsharing.service;

import carsharing.model.Customer;

public interface CustomerDao extends CarSharingDao<Customer> {

    void updateWhenReturn(int id);
    void updateWhenRent(int id, int rentedCarId);
}
