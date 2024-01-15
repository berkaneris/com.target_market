package Tests.TargetMarketLoginPageTests;

import Tests.BaseTests.Hooks;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.InarHomePage.InarHomePage;


import static org.testng.Assert.assertEquals;

public class LoginPageTest_01 extends Hooks {
    @Parameters("chrome")
    @Test
    void testLoginWithStandardUser() {
        homePage = new InarHomePage();
        loginPage = homePage.clickTargetMarketLink();
        targetMarketHomePage = loginPage.loginWithStandardUser();
        assertEquals("Welcome to the Target Market, standard_user!", targetMarketHomePage.getWelcomeText());

    }


}
