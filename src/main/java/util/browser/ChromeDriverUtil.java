package util.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constant.commonConstant.IMPLICIT_WAIT_IN_SECONDS;


public class ChromeDriverUtil implements WebDriverSelection {
    private WebDriver driver;
    ChromeOptions options;

    @Override
    public void selectDriver() {
        //System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");

        options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", "D:\\Code\\Selenium\\Selenium_QACode");
        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("excludeSwitches",
                List.of("disable-popup-blocking"));

        driver = new ChromeDriver(options);
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
