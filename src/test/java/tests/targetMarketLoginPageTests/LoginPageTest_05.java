package tests.targetMarketLoginPageTests;

import tests.Hooks;
import org.testng.annotations.Test;

import pages.targetMarket.InarHomePage;

public class LoginPageTest_05 extends Hooks {


    @Test
    public void testLoginProcessWithInvalidUser(){
        homePage = new InarHomePage();
        loginPage = homePage.clickTargetMarketLink();
        loginPage.loginWithAnyUser("Inar" , "Academy");

        softAssert.assertFalse(loginPage.isLoginSuccessful());
        softAssert.assertTrue(loginPage.isUserNameErrorAlertDisplayed());
        softAssert.assertTrue(loginPage.isPasswordErrorAlertDisplayed());
        softAssert.assertAll();
    }
}
