package carsharing.repository;

import carsharing.util.CarSharingConstants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static carsharing.util.CarSharingSqlStatement.*;

public abstract class BaseRepository {

    private static String dbUrl = null;

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public BaseRepository(String databaseFilename) {
        dbUrl = String.format(CarSharingConstants.FORMATTED_URL, DB_PATH, databaseFilename);
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public static void createDatabaseTable(String databaseFilename) {

        dbUrl = String.format(CarSharingConstants.FORMATTED_URL, DB_PATH, databaseFilename);

        try (Connection connection = DriverManager.getConnection(dbUrl)) {

            connection.setAutoCommit(false);

            Statement statement = connection.createStatement();
            statement.executeUpdate(TABLE_COMPANY_CREATION_WHEN_NOT_EXISTS_QUERY);

            statement = connection.createStatement();
            statement.executeUpdate(TABLE_CAR_CREATION_WHEN_NOT_EXITS_QUERY);

            statement = connection.createStatement();
            statement.executeUpdate(TABLE_CUSTOMER_CREATION_WHEN_NOT_EXISTS_QUERY);

            statement.close();
            connection.commit();

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }
}
