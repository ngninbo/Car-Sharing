package carsharing.service;

import carsharing.model.Company;
import carsharing.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

/**
 * Data Access Object concrete class.
 * This class implements the CompanyDao interface
 * @see carsharing.service.CompanyDao
 * @author Beauclair Dongmo Ngnintedem
 */
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
    public Optional<Company> findById(int companyId) {
        return companyRepository.findById(companyId);
    }

    @Override
    public void save(String name) {
        companyRepository.save(name);
    }
}
