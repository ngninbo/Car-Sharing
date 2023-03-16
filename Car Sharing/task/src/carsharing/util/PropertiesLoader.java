package carsharing.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class PropertiesLoader {

    private static final PropertiesLoader INSTANCE = new PropertiesLoader();

    private PropertiesLoader() {
    }

    public static PropertiesLoader getInstance() {
        return INSTANCE;
    }

    public Properties messages() throws IOException {
        return loadProperties("messages.properties");
    }

    public Properties queries() throws IOException {
        return loadProperties("query.properties");
    }

    protected static Properties loadProperties(String resourceFileName) throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties configuration = new Properties();
        InputStream inputStream = loader
                .getResourceAsStream(resourceFileName);
        configuration.load(inputStream);
        Objects.requireNonNull(inputStream).close();
        return configuration;
    }
}
