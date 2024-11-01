package util;

import org.openqa.selenium.WebDriver;

public interface WebDriverSelection {
    void spinUpDriver();

    void closeDriver();

    WebDriver getDriver();
}
