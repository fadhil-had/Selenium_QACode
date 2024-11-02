package util.browser;

import org.openqa.selenium.WebDriver;

import java.security.InvalidParameterException;

import static constant.commonConstant.BROWSER_NAME;
import static constant.Browser.*;


public class WebDriverFactory{
    public WebDriverSelection getDriverService() {
        WebDriverSelection driver;

        switch (BROWSER_NAME) {
            case CHROME:
                driver = new ChromeDriverUtil();
                break;
            case FIREFOX:
                driver = new FirefoxDriverUtil();
                break;
            case EDGE:
                driver = new EdgeDriverUtil();
                break;
            case SAFARI:
                driver = new SafariDriverUtil();
                break;

            default:
                throw new InvalidParameterException("'" + BROWSER_NAME + "' browser is not implemented");
        }

        return driver;
    }
}
