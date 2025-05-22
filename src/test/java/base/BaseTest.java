package base;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;
import utils.PageFactory;

public class BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    protected WebDriver driver;
    protected PageFactory pages;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
        pages = new PageFactory(driver);
        logger.info("TEST STARTED");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
        logger.info("TEST FINISHED");
    }
}
