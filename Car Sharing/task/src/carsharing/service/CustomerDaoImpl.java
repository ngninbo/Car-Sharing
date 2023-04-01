package carsharing.service;

import carsharing.model.Customer;
import carsharing.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

/**
 * Data Access Object concrete class.
 * This class implements the CustomerDao interface
 * @see carsharing.service.CustomerDao
 * @author Beauclair Dongmo Ngnintedem
 */
public class CustomerDaoImpl implements CustomerDao {

    private final CustomerRepository customerRepository;

    public CustomerDaoImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(String name) {
        customerRepository.save(name);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void updateWhenReturn(int id) {
        customerRepository.updateWhenReturn(id);
    }

    @Override
    public void updateWhenRent(int id, int rentedCarId) {
        customerRepository.updateWhenRent(id, rentedCarId);
    }
}
