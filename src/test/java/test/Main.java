package test;

import constant.commonConstant;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import util.WebDriverFactory;

import static constant.commonConstant.*;
import static util.WebDriverFactory.getDriver;
import static util.WebDriverFactory.setDriver;
import util.WebDriverSelection;

public class Main {
    private final WebDriverSelection driverService = new WebDriverFactory().getDriverService();
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    @BeforeSuite
    public void oneTimeSetup() {
        logger.info("Test execution browser: {}", BROWSER_NAME);
    }

    @BeforeMethod
    public void openBrowser() {
        driverService.selectDriver();
        setDriver(driverService.getDriver());
        getDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_IN_SECONDS);
        getDriver().manage().window().maximize();
        getDriver().get("https://demoqa.com/");
    }

    @AfterMethod
    public void after() {
        driverService.closeDriver();
    }
}