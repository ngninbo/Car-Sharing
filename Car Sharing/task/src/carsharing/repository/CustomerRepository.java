package carsharing.repository;

import carsharing.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static carsharing.util.CarSharingSqlStatement.*;

public class CustomerRepository extends BaseRepository {

    private CustomerRepository(String databaseFilename) {
        super(databaseFilename);
    }

    public static CustomerRepository init(String databaseFilename) {
        return new CustomerRepository(databaseFilename);
    }

    public void save(String name) {

        try (Connection connection = DriverManager.getConnection(getDbUrl())) {

            connection.setAutoCommit(true);

            PreparedStatement statement = connection.prepareStatement(INSERT_INTO_CUSTOMER_QUERY);
            statement.setString(1, name);

            statement.executeUpdate();

            statement.close();

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public List<Customer> findAll() {

        List<Customer> customers = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(getDbUrl())) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL_CUSTOMER_QUERY);

            while (resultSet.next()) {
                Customer customer = new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("rented_car_id"));
                customers.add(customer);
            }

            statement.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return customers;
    }

    public Customer findBy(int id) {

        Customer customer = null;

        try (Connection connection = DriverManager.getConnection(getDbUrl())) {

            connection.setAutoCommit(true);
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CUSTOMER_BY_ID_QUERY);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customer = new Customer(resultSet.getInt("id"),
                        resultSet.getString("name"), resultSet.getInt("rented_car_id"));

            }
            preparedStatement.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return customer;
    }

    public void updateWhenReturn(int id) {

        try (Connection connection = DriverManager.getConnection(getDbUrl())) {
            connection.setAutoCommit(true);
            PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_WHEN_RENT_CAR_RETURN_QUERY);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void updateWhenRent(int customerId, int rentedCarId) {

        try (Connection connection = DriverManager.getConnection(getDbUrl())) {

            connection.setAutoCommit(true);
            PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_WHEN_CAR_RENT_QUERY);
            statement.setInt(1, rentedCarId);
            statement.setInt(2, customerId);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

}
