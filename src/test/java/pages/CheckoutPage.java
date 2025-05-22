package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaiterUtils;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");

    @Step("Enter first name: {fName}")
    public void enterFirstName(String fName) {
        WaiterUtils.waitForElementVisible(driver, firstName).sendKeys(fName);
    }

    @Step("Enter last name: {lName}")
    public void enterLastName(String lName) {
        WaiterUtils.waitForElementVisible(driver, lastName).sendKeys(lName);
    }

    @Step("Enter postal code: {zip}")
    public void enterPostalCode(String zip) {
        WaiterUtils.waitForElementVisible(driver, postalCode).sendKeys(zip);
    }

    @Step("Click Continue button")
    public void clickContinue() {
        WaiterUtils.waitForElementClickable(driver, continueButton).click();
    }

    @Step("Fill a checkout form")
    public void fillCheckoutForm(String fName, String lName, String zip) {
        enterFirstName(fName);
        enterLastName(lName);
        enterPostalCode(zip);
        clickContinue();
    }
}
