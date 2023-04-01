package carsharing.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    private static final PropertiesLoader INSTANCE = new PropertiesLoader();

    private PropertiesLoader() {
    }

    public static PropertiesLoader getInstance() {
        return INSTANCE;
    }

    public Properties messages() {
        return loadProperties("messages.properties");
    }

    public Properties queries() {
        return loadProperties("query.properties");
    }

    protected static Properties loadProperties(String resourceFileName) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties configuration = new Properties();

        try (InputStream inputStream = loader.getResourceAsStream(resourceFileName)) {
            configuration.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return configuration;
    }
}
