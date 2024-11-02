package util.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static constant.commonConstant.IMPLICIT_WAIT_IN_SECONDS;


public class FirefoxDriverUtil implements WebDriverSelection {
    private WebDriver driver;

    @Override
    public void selectDriver() {
        driver = new FirefoxDriver();
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
