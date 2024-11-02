package test;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import pages.BasePage;
import pages.elements.TextBoxPage;
import util.browser.WebDriverFactory;
import constant.commonConstant;

import static constant.commonConstant.*;
import util.browser.WebDriverSelection;

import java.sql.Timestamp;

public class Main {
    private final WebDriverSelection driverService = new WebDriverFactory().getDriverService();
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public commonConstant common;
    public BasePage basePage;
    public TextBoxPage textBoxPage;
    public Faker faker;

    long epoch = System.currentTimeMillis();

    @BeforeSuite
    public void oneTimeSetup() {
        logger.info("Test execution browser: {}", BROWSER_NAME);
    }

    @BeforeMethod
    public void openBrowser() {
        driverService.selectDriver();
        driver = driverService.getDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_IN_SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);

        faker = new Faker();
        basePage = new BasePage(driver);
        textBoxPage = new TextBoxPage(driver);
    }

    @AfterMethod
    public void after() {
        //driverService.closeDriver();
    }
}