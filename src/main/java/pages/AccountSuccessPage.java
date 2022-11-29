package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Browser;

public class AccountSuccessPage extends BasePage {

    @FindBy(id = "content")
    private static WebElement registeredAccountConfirmation;


    static {
        PageFactory.initElements(Browser.driver, AccountSuccessPage.class);
    }

    public static void verifyRegistration() {
        waitOfVisibilityOfElement(registeredAccountConfirmation);
        Assert.assertTrue(registeredAccountConfirmation.getText().contains("Your Account Has Been Created!"), "Your Account Has Been Created!");
    }
}
