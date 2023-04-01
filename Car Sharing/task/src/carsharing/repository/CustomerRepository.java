package carsharing.repository;

import carsharing.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository extends BaseRepository<Customer> {

    private CustomerRepository(String databaseFilename) {
        super(databaseFilename);
    }

    public static CustomerRepository init(String databaseFilename) {
        return new CustomerRepository(databaseFilename);
    }

    public void save(String name) {

        try (Connection connection = getConnection()) {

            connection.setAutoCommit(true);

            PreparedStatement statement = connection.prepareStatement(getPropertyFromKey("INSERT_INTO_CUSTOMER_QUERY"));
            statement.setString(1, name);

            statement.executeUpdate();

            statement.close();

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    @Override
    public List<Customer> findAll() {

        List<Customer> customers = new ArrayList<>();

        try (Connection connection = getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getPropertyFromKey("FIND_ALL_CUSTOMER_QUERY"));

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

    @Override
    public Customer findById(int id) {

        Customer customer = null;

        try (Connection connection = getConnection()) {

            connection.setAutoCommit(true);
            PreparedStatement preparedStatement = connection.prepareStatement(getPropertyFromKey("FIND_CUSTOMER_BY_ID_QUERY"));
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

        try (Connection connection = getConnection()) {
            connection.setAutoCommit(true);
            PreparedStatement statement = connection.prepareStatement(getPropertyFromKey("UPDATE_CUSTOMER_WHEN_RENT_CAR_RETURN_QUERY"));
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void updateWhenRent(int customerId, int rentedCarId) {

        try (Connection connection = getConnection()) {

            connection.setAutoCommit(true);
            PreparedStatement statement = connection.prepareStatement(getPropertyFromKey("UPDATE_CUSTOMER_WHEN_CAR_RENT_QUERY"));
            statement.setInt(1, rentedCarId);
            statement.setInt(2, customerId);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

}
