package Tests.TargetMarketLoginPageTests;

import Tests.BaseTests.Hooks;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.InarHomePage.InarHomePage;

import static org.testng.Assert.assertEquals;

public class LoginPageTest_02 extends Hooks {

    @Parameters("chrome")
    @Test
    void testLoginWithProblemUser() {
        homePage = new InarHomePage();
        loginPage = homePage.clickTargetMarketLink();
        targetMarketHomePage = loginPage.loginWithProblemUser();
        assertEquals("Welcome to the Target Market, problem_user!", targetMarketHomePage.getWelcomeText());

    }
}
