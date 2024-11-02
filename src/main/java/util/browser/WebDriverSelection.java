package util.browser;

import org.openqa.selenium.WebDriver;

public interface WebDriverSelection {
    void selectDriver();

    void closeDriver();

    WebDriver getDriver();
}
