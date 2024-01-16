package tests.targetMarketLoginPageTests;

import tests.Hooks;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;




public class LoginPageTest_01 extends Hooks {
    @Parameters("browser")
    @Test
    void testLoginWithStandardUser() {
        homePage = new InarHomePage();
        loginPage = homePage.clickTargetMarketLink();
        targetMarketHomePage = loginPage.loginWithStandardUser();
        softAssert.assertEquals( targetMarketHomePage.getWelcomeText(), "Welcome to the Target Market, standard_user!");
        softAssert.assertAll();

    }


}
