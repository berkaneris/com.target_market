package Tests.TargetMarketLoginPageTests;

import Tests.BaseTests.Hooks;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.InarHomePage.InarHomePage;

import static org.testng.Assert.assertEquals;

public class LoginPageTest_03 extends Hooks {

    @Parameters("chrome")
    @Test
    void testLoginWithLockedOutUser() {
        homePage = new InarHomePage();
        loginPage = homePage.clickTargetMarketLink();
        loginPage.loginWithLockedOutUser();
        assertEquals("Your account is locked.", loginPage.getLockedOutUserError().getText());

    }
}
