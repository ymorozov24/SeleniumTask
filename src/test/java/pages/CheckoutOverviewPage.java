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

    private By totalLabel = By.className("summary_total_label");
    private By finishButton = By.id("finish");
    private By confirmationText = By.className("complete-header");

    public String getTotalPrice() {
        return WaiterUtils.waitForElementVisible(driver, totalLabel).getText();
    }

    @Step("Finish checkout")
    public void finishCheckout() {
        WaiterUtils.waitForElementClickable(driver, finishButton).click();
    }

    public String getConfirmation() {
        return WaiterUtils.waitForElementVisible(driver, confirmationText).getText();
    }
}
