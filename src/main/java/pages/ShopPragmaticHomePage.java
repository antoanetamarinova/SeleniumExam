package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;
import utils.Wait;

public class ShopPragmaticHomePage extends BasePage {

    @FindBy(xpath = "//i[@class = 'fa fa-user']")
    private static WebElement myAccountButton;

    @FindBy(xpath = "//a[@href = 'https://shop.pragmatic.bg/index.php?route=account/register']")
    private static WebElement registerOption;


    private static String shopPragmaticHomePageUrl = "http://shop.pragmatic.bg";

    static {PageFactory.initElements(Browser.driver, ShopPragmaticHomePage.class);}

    public static void goTo() {Browser.driver.get(shopPragmaticHomePageUrl);}

    public static void clickOnMyAccountButton() {myAccountButton.click();}

    public static void clickOnRegisterOption() {
        waitOfVisibilityOfElement(registerOption);
        registerOption.click();}
}
