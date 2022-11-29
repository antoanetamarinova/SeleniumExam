import org.testng.annotations.Test;
import pageObjectModelTest.base.BaseTest;
import pages.AccountSuccessPage;
import pages.RegisterAccountPage;
import pages.ShopPragmaticHomePage;

public class RegisterNewUserPOMtest extends BaseTest {

    @Test
    public void testRegisterNewUser() {
        ShopPragmaticHomePage.goTo();
        ShopPragmaticHomePage.clickOnMyAccountButton();
        ShopPragmaticHomePage.clickOnRegisterOption();
        RegisterAccountPage.typeOnInputFirstNameField("Antoaneta");
        RegisterAccountPage.typeOnInputLastNameField("Marinova");
        RegisterAccountPage.typeOnInputEmailField();
        RegisterAccountPage.typeOnInputTelephoneField("+359777");
        RegisterAccountPage.typeOnInputPasswordFieldAndConfirmPassword("pass555");
        RegisterAccountPage.clickInCheckPrivacyPolicy();
        RegisterAccountPage.clickOnContinueButton();
        AccountSuccessPage.verifyRegistration();

    }


}
