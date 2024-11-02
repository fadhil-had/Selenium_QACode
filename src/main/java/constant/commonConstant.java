package constant;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

import static constant.Browser.CHROME;
import static util.PropertiesReader.getProperty;

public class commonConstant {
    private static final Logger logger = LoggerFactory.getLogger(commonConstant.class);
    public static final String BROWSER_NAME = getBrowserName();
    public static final String URL = getUrl();
    public static final Duration IMPLICIT_WAIT_IN_SECONDS = Duration.ofSeconds(60);
    public static final Duration EXPLICIT_WAIT_IN_SECONDS = Duration.ofSeconds(60);
    public static WebDriver driver;
    public static WebDriverWait wait;

    public commonConstant(WebDriver driver){
        commonConstant.driver = driver;
        commonConstant.wait = new WebDriverWait(driver, EXPLICIT_WAIT_IN_SECONDS);
    }

    public WebElement element(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> elements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void click(By locator){
        javaExecutorScrollIntoView(locator);
        element(locator).click();
    }

    public void clickByIndex(By locator, int index){
        elements(locator).get(index).click();
    }

    public void sendKey(By locator, String value){
        javaExecutorScrollIntoView(locator);
        element(locator).sendKeys(value);
    }

    public String getText(By locator){
        javaExecutorScrollIntoView(locator);
        return element(locator).getText();
    }
    public String getTexts(By locator, int i){
        return elements(locator).get(i).getText();
    }

    public int arrayListToInt(String[] items, String list) {
        return ArrayUtils.indexOf(items, list);
    }

    public void javaExecutorScrollIntoView(By locator) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", element(locator));
    }

    public static String getBrowserName(){
        String browserNameFromProperties = System.getProperty("browser");
        String browserName;

        if (browserNameFromProperties != null)
            browserName = browserNameFromProperties;
        else {
            logger.warn("There is no browser on properties use default");
            browserName = CHROME;
        }

        return browserName.toLowerCase();
    }

    public static String getUrl(){
        String urlFromProperties = System.getProperty("url");
        String url;

        if (urlFromProperties != null)
            url = urlFromProperties;
        else {
            logger.warn("There is no url on properties use default");
            url = getProperty("default");
        }

        return url.toLowerCase();
    }
}
