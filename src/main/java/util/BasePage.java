package util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constant.commonConstant.*;

public class BasePage {
    public static WebDriver driver;
    public static WebDriverWait wait;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, IMPLICIT_WAIT_IN_SECONDS);
    }

    public void clickElement(){
        WebElement Elemen = driver.findElement(By.xpath("//h5[normalize-space()='Elements']"));
        js.executeScript("arguments[0].scrollIntoView();", Elemen);

        Elemen.click();
    }
}
