// ProductsPage.java
package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaiterUtils;

import java.util.List;

public class ProductsPage {
    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By cartIcon = By.className("shopping_cart_link");

    private By getAddToCartButtonByItemName(String name) {
        return By.xpath("//div[@class='inventory_item'][.//div[text()='" + name + "']]//button[contains(text(),'Add to cart')]");
    }

    @Step("Add items to cart: {itemNames}")
    public void addItems(List<String> itemNames) {
        for (String name : itemNames) {
            WaiterUtils.waitForElementClickable(driver, getAddToCartButtonByItemName(name)).click();
        }
    }

    @Step("Go to cart")
    public void goToCart() {
        WaiterUtils.waitForElementClickable(driver, cartIcon).click();
    }
}
