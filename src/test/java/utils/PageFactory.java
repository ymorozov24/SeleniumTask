package utils;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactory {
    private final WebDriver driver;

    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private CheckoutOverviewPage overviewPage;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public ProductsPage productsPage() {
        if (productsPage == null) {
            productsPage = new ProductsPage(driver);
        }
        return productsPage;
    }

    public CartPage cartPage() {
        if (cartPage == null) {
            cartPage = new CartPage(driver);
        }
        return cartPage;
    }

    public CheckoutPage checkoutPage() {
        if (checkoutPage == null) {
            checkoutPage = new CheckoutPage(driver);
        }
        return checkoutPage;
    }

    public CheckoutOverviewPage overviewPage() {
        if (overviewPage == null) {
            overviewPage = new CheckoutOverviewPage(driver);
        }
        return overviewPage;
    }
}