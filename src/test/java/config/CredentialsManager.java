package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CredentialsManager {
    private static final String PROPERTIES_FILE = "src/test/resources/credentials.properties";
    private static Properties props = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE)) {
            props.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Could not load credentials file", e);
        }
    }

    public static String getUsername() {
        return props.getProperty("username");
    }

    public static String getPassword() {
        return props.getProperty("password");
    }
}
