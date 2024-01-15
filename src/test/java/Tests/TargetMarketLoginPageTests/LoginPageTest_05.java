package Tests.TargetMarketLoginPageTests;

import Tests.BaseTests.Hooks;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.InarHomePage.InarHomePage;

public class LoginPageTest_05 extends Hooks {


    @Test
    public void testLoginProcessWithInvalidUser(){
        homePage = new InarHomePage();
        loginPage = homePage.clickTargetMarketLink();
        loginPage.loginWithAnyUser("Inar" , "Academy");
        SoftAssert sa = new SoftAssert();
        sa.assertFalse(loginPage.isLoginSuccessful());
        sa.assertTrue(loginPage.isUserNameErrorAlertDisplayed());
        sa.assertTrue(loginPage.isPasswordErrorAlertDisplayed());
        sa.assertAll();
    }
}
