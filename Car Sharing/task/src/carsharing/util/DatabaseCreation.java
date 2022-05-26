package carsharing.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static carsharing.repository.BaseRepository.*;

public class DatabaseCreation {

    public static void createDatabaseTable(String databaseFilename) {

        try (Connection connection = DriverManager.getConnection(getPath(databaseFilename))) {

            connection.setAutoCommit(false);

            Statement statement = connection.createStatement();
            statement.executeUpdate(getQueryFromKey("TABLE_COMPANY_CREATION_WHEN_NOT_EXISTS_QUERY"));

            statement = connection.createStatement();
            statement.executeUpdate(getQueryFromKey("TABLE_CAR_CREATION_WHEN_NOT_EXITS_QUERY"));

            statement = connection.createStatement();
            statement.executeUpdate(getQueryFromKey("TABLE_CUSTOMER_CREATION_WHEN_NOT_EXISTS_QUERY"));

            statement.close();
            connection.commit();

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }
}
