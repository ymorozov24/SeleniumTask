package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UrlConfig {
    private static final String DEFAULT_BASE_URL = "https://www.saucedemo.com/";
    private static final String CONFIG_FILE = "/application.properties";
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = UrlConfig.class.getResourceAsStream(CONFIG_FILE)) {
            if (input != null) {
                properties.load(input);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load application.properties", e);
        }
    }

    public static String getBaseUrl() {
        return System.getProperty("base.url", properties.getProperty("base.url", DEFAULT_BASE_URL));
    }
}
