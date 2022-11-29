package pageObjectModelTest.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Browser;
import utils.Wait;

public class BaseTest {

    @BeforeMethod
    public static void browserSetUp() {
        Browser.setup();
        Wait.setUpWait();
    }

    @AfterMethod
    public static void browserQuit() {
        Browser.tearDown();
    }
}
