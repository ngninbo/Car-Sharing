package carsharing.controller;

import carsharing.model.Company;
import carsharing.service.CompanyDao;
import carsharing.util.CarSharingUtil;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CompanyController {

    private final CompanyDao companyDao;

    public CompanyController(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    public List<Company> findAll() {
        return companyDao.findAll();
    }

    private void save(String name) {
        companyDao.save(name);
    }

    public Company findCompanyById(int companyId) {
        return companyDao.findById(companyId);
    }

    public void createCompany() throws IOException {
        CarSharingUtil.println("COMPANY_NAME_INPUT_COMMAND");
        String name = new Scanner(System.in).nextLine();
        this.save(name);
        CarSharingUtil.println("COMPANY_CREATION_SUCCEED_MSG");
    }
}
