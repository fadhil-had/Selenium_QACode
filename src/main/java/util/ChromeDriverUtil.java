package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static constant.commonConstant.IMPLICIT_WAIT_IN_SECONDS;


public class ChromeDriverUtil implements WebDriverSelection {
    private WebDriver driver;

    @Override
    public void spinUpDriver() {
        driver = new ChromeDriver();
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
