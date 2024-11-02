package util.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static constant.commonConstant.IMPLICIT_WAIT_IN_SECONDS;


public class EdgeDriverUtil implements WebDriverSelection {
    private WebDriver driver;

    @Override
    public void selectDriver() {
        driver = new EdgeDriver();
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
