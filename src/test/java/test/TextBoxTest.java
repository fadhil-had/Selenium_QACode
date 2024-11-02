package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.elements.TextBoxPage;

public class TextBoxTest extends Main {
    @Test
    public void elementTextBox() throws InterruptedException {
        String name = faker.name().fullName();
        String domain = "@fakermail.com";
        String email = faker.name().username()+epoch+domain;
        String currentAddress = faker.address().fullAddress();
        String permanentAddress = faker.address().secondaryAddress();

        basePage.openBaseMenu("Elements");
        basePage.clickElementMenu("Text Box");
        Thread.sleep(5000);
        Assert.assertEquals(basePage.getTitle(), "Text Box");

        textBoxPage.fillForm(name, email, currentAddress, permanentAddress);
        Thread.sleep(5000);

        textBoxPage.assertResponses(name,email,currentAddress,permanentAddress);
    }
}