package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaiterUtils;

public class CheckoutOverviewPage {
    private WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By totalLabel = By.className("summary_total_label");
    private final By finishButton = By.id("finish");
    private final By confirmationText = By.className("complete-header");

    @Step("Finish checkout")
    public void finishCheckout() {
        WaiterUtils.waitForElementClickable(driver, finishButton).click();
    }

    @Step("Get Total Price")
    public String getTotalPrice() {
        return WaiterUtils.waitForElementVisible(driver, totalLabel).getText();
    }

    @Step("Get confirmation")
    public String getConfirmation() {
        return WaiterUtils.waitForElementVisible(driver, confirmationText).getText();
    }
}
