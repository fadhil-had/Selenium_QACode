package pages;

import constant.commonConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import staticvariables.StaticVariables;

public class BasePage extends commonConstant {
    public BasePage(WebDriver driver) {
        super(driver);
    }

    By clickHomePageItem = By.className("card-up");
    By clickElementsItems = By.xpath("//*[contains(@class,\"collapse show\")]/ul/li");
    By title = By.className("text-center");

    public void openBaseMenu(String menu){
        int index = arrayListToInt(StaticVariables.HOME_MENU_ITEMS, menu);
        javaExecutorScrollIntoView(clickHomePageItem);
        clickByIndex(clickHomePageItem,index);
    }

    public void clickElementMenu(String menu){
        int index = arrayListToInt(StaticVariables.ELEMENTS_MENU, menu);
        javaExecutorScrollIntoView(clickElementsItems);
        clickByIndex(clickElementsItems,index);
    }

    public String getTitle(){return getText(title);}
}
