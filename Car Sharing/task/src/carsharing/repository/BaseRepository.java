package carsharing.repository;

import carsharing.util.PropertiesLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public abstract class BaseRepository<T> {

    private static String dbUrl;
    private static Properties queryProperties;

    static {
        try {
            queryProperties = PropertiesLoader.getInstance().queries();
            Class.forName(getPropertyFromKey("JDBC_DRIVER"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<T> findAll() {
        return null;
    }

    protected Optional<T> findById(int id) {
        return Optional.empty();
    }

    public BaseRepository(String databaseFilename) {
        dbUrl = getPath(databaseFilename);
    }

    public static String getDbUrl() {
        return dbUrl;
    }

    protected static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(getDbUrl());
    }

    public static String getPropertyFromKey(String key) {
        return queryProperties.getProperty(key);
    }

    public static String getPath(String databaseFilename) {
        return String.format(
                getPropertyFromKey("FORMATTED_URL"),
                getPropertyFromKey("DB_PATH"),
                databaseFilename);
    }
}
