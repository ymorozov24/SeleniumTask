package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import config.UrlConfig;
import utils.WaiterUtils;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");

    @Step("Open Login Page")
    public void open() {
        driver.get(UrlConfig.getBaseUrl());
    }

    @Step("Enter username: {username}")
    public void enterUsername(String username) {
        WaiterUtils.waitForElementVisible(driver, usernameInput).sendKeys(username);
    }

    @Step("Enter password")
    public void enterPassword(String password) {
        WaiterUtils.waitForElementVisible(driver, passwordInput).sendKeys(password);
    }

    @Step("Click login button")
    public void clickLogin() {
        WaiterUtils.waitForElementClickable(driver, loginButton).click();
    }

    @Step("Perform login with username: {username} and password: {password}")
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
