package carsharing.controller;

import carsharing.model.Company;
import carsharing.service.CompanyDao;

import java.util.List;
import java.util.Scanner;

import static carsharing.util.CarSharingConstants.COMPANY_CREATION_SUCCEED_MSG;
import static carsharing.util.CarSharingConstants.COMPANY_NAME_INPUT_COMMAND;

public class CompanyController {

    private final CompanyDao companyDao;

    public CompanyController(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    public List<Company> findAll() {
        return companyDao.findAll();
    }

    public void save(String name) {
        companyDao.update(name);
    }

    public Company findCompanyById(int companyId) {
        return companyDao.findById(companyId);
    }

    public void createCompany() {
        System.out.println(COMPANY_NAME_INPUT_COMMAND);
        String name = new Scanner(System.in).nextLine();
        this.save(name);
        System.out.println(COMPANY_CREATION_SUCCEED_MSG);
    }
}
