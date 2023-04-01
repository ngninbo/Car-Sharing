package carsharing.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static carsharing.repository.BaseRepository.getPath;
import static carsharing.repository.BaseRepository.getPropertyFromKey;

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

    public void initDataBaseTable() {
        try (Connection connection = DriverManager.getConnection(getPath(filename))) {

            connection.setAutoCommit(false);

            Statement statement = connection.createStatement();
            statement.executeUpdate(getPropertyFromKey("TABLE_COMPANY_CREATION_WHEN_NOT_EXISTS_QUERY"));

            statement = connection.createStatement();
            statement.executeUpdate(getPropertyFromKey("TABLE_CAR_CREATION_WHEN_NOT_EXITS_QUERY"));

            statement = connection.createStatement();
            statement.executeUpdate(getPropertyFromKey("TABLE_CUSTOMER_CREATION_WHEN_NOT_EXISTS_QUERY"));

            statement.close();
            connection.commit();

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }
}
