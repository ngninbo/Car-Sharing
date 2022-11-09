package carsharing.repository;

import carsharing.model.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyRepository extends BaseRepository<Company> {

    private CompanyRepository(String databaseFilename) {
        super(databaseFilename);
    }

    public static CompanyRepository init(String databaseFilename) {
        return new CompanyRepository(databaseFilename);
    }

    @Override
    public List<Company> findAll() {

        List<Company> companies = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(getDbUrl())) {

            connection.setAutoCommit(true);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(fromString("FIND_ALL_COMPANIES_QUERY"));

            while (resultSet.next()) {
                Company company = new Company(resultSet.getInt("id"), resultSet.getString("name"));
                companies.add(company);
            }

            statement.close();

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        return companies;
    }


    public void save(String name) {

        try (Connection connection = DriverManager.getConnection(getDbUrl())) {

            connection.setAutoCommit(true);

            PreparedStatement statement = connection.prepareStatement(fromString("INSERT_INTO_COMPANY_NAME_VALUES_QUERY"));
            statement.setString(1, name);

            statement.executeUpdate();

            statement.close();

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    @Override
    public Company findById(int id) {

        Company company = null;

        try (Connection connection = DriverManager.getConnection(getDbUrl())) {

            connection.setAutoCommit(true);

            PreparedStatement statement = connection.prepareStatement(fromString("FIND_COMPANY_BY_ID_QUERY"));
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                company = new Company(resultSet.getInt("id"), resultSet.getString("name"));
            }

            statement.close();

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        return company;
    }
}
