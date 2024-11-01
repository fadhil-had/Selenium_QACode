package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import static constant.commonConstant.IMPLICIT_WAIT_IN_SECONDS;


public class SafariDriverUtil implements WebDriverSelection {
    private WebDriver driver;

    @Override
    public void spinUpDriver() {
        driver = new SafariDriver();
        driver.manage()
                .timeouts()
                .implicitlyWait(IMPLICIT_WAIT_IN_SECONDS);
    }

    @Override
    public void closeDriver() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
