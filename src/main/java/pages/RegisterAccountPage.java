package pages;

import base.BasePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class RegisterAccountPage extends BasePage {

    @FindBy(id = "input-firstname")
    private static WebElement inputFirstNameField;

    @FindBy(id = "input-lastname")
    private static WebElement inputLastNameField;


    @FindBy(id = "input-email")
    private  static WebElement inputEmailField;

    private static String randomEmailAddress;
    private static String prefix = RandomStringUtils.randomAlphabetic(8);
    private static String domainPrefix = RandomStringUtils.randomAlphabetic(5);
    private static String mainDomain = RandomStringUtils.randomAlphabetic(3);

    @FindBy(id = "input-telephone")
    private static WebElement inputTelephoneField;

    @FindBy(id = "input-password")
    private static WebElement inputPasswordField;

    @FindBy(id = "input-confirm")
    private static WebElement inputConfirmPasswordField;

    @FindBy(xpath = "//div[@class = 'pull-right']//input[1]")
    private static WebElement checkPrivacyPolicy;

    @FindBy(className = "btn-primary")
    private static WebElement continueButton;


    static {
        PageFactory.initElements(Browser.driver, RegisterAccountPage.class);}


    public static void typeOnInputFirstNameField(String firstname) {
        waitOfVisibilityOfElement(inputFirstNameField);
        inputFirstNameField.sendKeys(firstname);
    }

    public static void typeOnInputLastNameField(String lastname) {inputLastNameField.sendKeys(lastname);}

    public static void typeOnInputEmailField(){
        randomEmailAddress = prefix + "@" + domainPrefix + "." + mainDomain;
        inputEmailField.sendKeys(randomEmailAddress);
    }

    public static String typeOnInputTelephoneField(String telephoneNumber) {
        inputTelephoneField.sendKeys(telephoneNumber);
        return telephoneNumber;
    }

    public static void  typeOnInputPasswordFieldAndConfirmPassword(String password) {
        inputPasswordField.sendKeys(password);
        inputConfirmPasswordField.sendKeys(password);
    }

    public static void clickInCheckPrivacyPolicy () {checkPrivacyPolicy.click();}

    public static void clickOnContinueButton () {
        if (checkPrivacyPolicy.isSelected())
        continueButton.click();}











}
