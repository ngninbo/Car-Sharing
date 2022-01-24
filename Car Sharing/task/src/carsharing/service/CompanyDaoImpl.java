package carsharing.service;

import carsharing.model.Company;
import carsharing.repository.CompanyRepository;

import java.util.List;

public class CompanyDaoImpl implements CompanyDao {

    private final CompanyRepository companyRepository;

    public CompanyDaoImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findById(int companyId) {
        return companyRepository.findById(companyId);
    }

    @Override
    public void update(String name) {
        companyRepository.save(name);
    }
}
