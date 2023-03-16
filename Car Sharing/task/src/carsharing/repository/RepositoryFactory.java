package carsharing.repository;

public class RepositoryFactory {

    private final String filename;

    public RepositoryFactory(String filename) {
        this.filename = filename;
    }

    public CarRepository getCarRepository() {
        return CarRepository.init(filename);
    }

    public CompanyRepository getCompanyRepository() {
        return CompanyRepository.init(filename);
    }

    public CustomerRepository getCustomerRepository() {
        return CustomerRepository.init(filename);
    }
}
