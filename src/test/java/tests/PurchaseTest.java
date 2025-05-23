package tests;

import base.BaseTest;
import config.CredentialsManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PurchaseTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(PurchaseTest.class);

    @Test
    public void testPurchaseFlow() {

        logger.info("Login");
        pages.loginPage().open();
        pages.loginPage().login(CredentialsManager.getUsername(), CredentialsManager.getPassword());

        logger.info("Add items");
        //We can also use DataProvider here for test data
        pages.productsPage().addItems(List.of("Sauce Labs Backpack", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie"));
        pages.productsPage().goToCart();

        logger.info("Remove items");
        pages.cartPage().removeItems(List.of("Sauce Labs Onesie"));

        logger.info("Proceed with checkout");
        pages.cartPage().proceedToCheckout();
        pages.checkoutPage().fillCheckoutForm("John", "Doe", "12345");

        String total = pages.overviewPage().getTotalPrice();
        logger.info("Total price: " + total);

        logger.info("Complete purchase");
        pages.overviewPage().finishCheckout();
        String confirmation = pages.overviewPage().getConfirmation();
        Assert.assertEquals(confirmation, "Thank you for your order!");
    }
}
