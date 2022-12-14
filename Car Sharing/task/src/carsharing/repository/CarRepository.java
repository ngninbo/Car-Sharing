package carsharing.repository;

import carsharing.model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarRepository extends BaseRepository<Car> {

    private CarRepository(String databaseFilename) {
        super(databaseFilename);
    }

    public static CarRepository init(String databaseFilename) {
        return new CarRepository(databaseFilename);
    }

    public boolean save(String name, int companyId) {

        boolean querySucceed = false;
        try (Connection connection = DriverManager.getConnection(getDbUrl())) {
            connection.setAutoCommit(true);
            PreparedStatement statement = connection.prepareStatement(fromPropertyKey("INSERT_INTO_CAR_QUERY"));
            statement.setString(1, name);
            statement.setInt(2, companyId);
            querySucceed = statement.executeUpdate() > 0;
            statement.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return querySucceed;
    }

    public List<Car> findCarByCompanyId(int companyId) {

        List<Car> cars = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(getDbUrl())) {

            PreparedStatement statement = connection.prepareStatement(fromPropertyKey("FIND_ALL_CAR_BY_COMPANY_ID_QUERY"));
            statement.setInt(1, companyId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Car car = new Car(resultSet.getInt("id"), resultSet.getString("name"));
                cars.add(car);
            }
            statement.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return cars;
    }

    @Override
    public Car findById(int id) {

        Car car = null;

        try (Connection connection = DriverManager.getConnection(getDbUrl())) {

            PreparedStatement statement = connection.prepareStatement(fromPropertyKey("FIND_CAR_BY_ID_QUERY"));
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                car = new Car(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("company_id"));
            }

            statement.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return car;
    }

    @Override
    public List<Car> findAll() {
        return null;
    }
}
