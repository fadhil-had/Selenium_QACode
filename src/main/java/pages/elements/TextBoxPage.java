package pages.elements;

import constant.commonConstant;
import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import staticvariables.StaticVariables;

public class TextBoxPage extends commonConstant{
    By fullName = By.id("userName");
    By email = By.id("userEmail");
    By currentAddress = By.id("currentAddress");
    By permanentAddress = By.id("permanentAddress");
    By submit = By.id("submit");
    By assertion = By.className("mb-1");

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public void fillForm(String name, String mail, String curAddress, String perAddress){
        sendKey(fullName, name);
        sendKey(email, mail);
        sendKey(currentAddress, curAddress);
        sendKey(permanentAddress, perAddress);
        click(submit);
    }

    public String assertResponse(String response) {
        int i = ArrayUtils.indexOf(StaticVariables.TEXTBOX_RESPONSES, response);
        return getTexts(assertion, i);
    }

    public void assertResponses(String name, String mail, String curAddress, String perAddress) {
        Assert.assertEquals(assertResponse("Name"), "Name:"+name);
        Assert.assertEquals(assertResponse("Email"), "Email:"+mail);
        Assert.assertEquals(assertResponse("Current Address"), "Current Address :"+curAddress);
        Assert.assertEquals(assertResponse("Permanent Address"), "Permananet Address :"+perAddress);
    }
}
