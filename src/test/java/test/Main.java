package test;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import util.browser.WebDriverFactory;

import static constant.commonConstant.*;
import static util.browser.WebDriverFactory.getDriver;
import static util.browser.WebDriverFactory.setDriver;
import util.browser.WebDriverSelection;
import util.BasePage;

public class Main extends BasePage {
    private final WebDriverSelection driverService = new WebDriverFactory().getDriverService();
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public Main(WebDriver driver) {
        super(driver);
    }

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
        getDriver().get(URL);
    }

    @AfterMethod
    public void after() {
        driverService.closeDriver();
    }
}