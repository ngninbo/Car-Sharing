package carsharing.repository;

import carsharing.util.PropertiesLoader;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public abstract class BaseRepository<T> {

    private final String dbUrl;
    private static Properties queryProperties;
    public abstract T findById(int id);
    public abstract List<T> findAll();

    static {
        try {
            queryProperties = PropertiesLoader.loadProperties("query.properties");
            Class.forName(fromString("JDBC_DRIVER"));
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public BaseRepository(String databaseFilename) {
        dbUrl = getPath(databaseFilename);
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public static String fromString(String key) {
        return queryProperties.getProperty(key);
    }

    public static String getPath(String databaseFilename) {
        return String.format(
                fromString("FORMATTED_URL"),
                fromString("DB_PATH"),
                databaseFilename);
    }
}
