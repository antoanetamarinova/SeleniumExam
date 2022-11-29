package base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Wait;

public abstract class BasePage {

    protected static void click(WebElement element) {
        element.click();
    }

    public static void waitOfVisibilityOfElement(WebElement element) {
        Wait.wait.until(ExpectedConditions.visibilityOf(element));
    }
}
