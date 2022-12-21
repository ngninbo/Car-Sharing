package carsharing.controller;

import carsharing.model.Company;
import carsharing.service.CompanyDao;

import java.util.List;

public class CompanyController {

    private final CompanyDao companyDao;

    public CompanyController(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    public List<Company> findAll() {
        return companyDao.findAll();
    }

    public void save(String name) {
        companyDao.save(name);
    }

    public Company findCompanyById(int companyId) {
        return companyDao.findById(companyId);
    }
}
