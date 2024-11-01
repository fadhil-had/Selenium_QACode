package test;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import util.WebDriverFactory;

import static constant.commonConstant.*;
import static util.WebDriverFactory.getDriver;
import static util.WebDriverFactory.setDriver;
import util.WebDriverSelection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private final WebDriverSelection driverService = new WebDriverFactory().getDriverService();
    public WebDriverWait wait;
    private final static Logger logger = LogManager.getLogger();

    @BeforeSuite
    public void oneTimeSetup() {
        logger.debug("Test execution browser: {}", BROWSER_NAME);
    }

    @BeforeMethod
    public void openBrowser() {
        driverService.selectDriver();
        setDriver(driverService.getDriver());
        getDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_IN_SECONDS);
        getDriver().manage().window().maximize();
        getDriver().get("https://demoblaze.com/");

    }

    @AfterMethod
    public void after() {
        driverService.closeDriver();
    }
}