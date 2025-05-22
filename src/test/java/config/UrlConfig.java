package config;

public class UrlConfig {
    private static final String BASE_URL = System.getProperty("base.url", "https://www.saucedemo.com/");

    public static String getBaseUrl() {
        return BASE_URL;
    }
}
