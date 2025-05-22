package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaiterUtils;

import java.util.List;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By checkoutButton = By.id("checkout");

    private By getRemoveButtonByItemName(String name) {
        return By.xpath("//div[@class='cart_item'][.//div[text()='" + name + "']]//button[contains(text(),'Remove')]");
    }

    @Step("Remove items from the cart: {itemNames}")
    public void removeItems(List<String> itemNames) {
        for (String name : itemNames) {
            WaiterUtils.waitForElementClickable(driver, getRemoveButtonByItemName(name)).click();
        }
    }

    @Step("Proceed to checkout")
    public void proceedToCheckout() {
        WaiterUtils.waitForElementClickable(driver, checkoutButton).click();
    }
}
