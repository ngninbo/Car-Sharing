package carsharing.service;

import carsharing.model.Company;

import java.util.List;

public interface CompanyDao {

    List<Company> findAll();
    Company findById(int id);
    void update(String name);
}
