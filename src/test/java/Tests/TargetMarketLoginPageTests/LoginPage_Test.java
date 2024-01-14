package Tests.TargetMarketLoginPageTests;

import Tests.Hooks.Hooks;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.InarHomePage.InarHomePage;
import pages.TargetMarketLoginPage.LoginPage;
import pages.TargetMarketHomePage.TargetMarketHomePage;

import static org.testng.Assert.assertEquals;

public class LoginPage_Test extends Hooks {


    @Parameters("chrome")
    @Test
    void testLoginWithStandardUser() {
        InarHomePage homePage = new InarHomePage();
        LoginPage loginPage = homePage.clickTargetMarketLink();
        TargetMarketHomePage targetMarketHomePage = loginPage.loginWithStandardUser();
        assertEquals("Welcome to the Target Market, standard_user!", targetMarketHomePage.getWelcomeText());

    }
    @Parameters("chrome")
    @Test
    void testLoginWithProblemUser() {
        InarHomePage homePage = new InarHomePage();
        LoginPage loginPage = homePage.clickTargetMarketLink();
        TargetMarketHomePage targetMarketHomePage = loginPage.loginWithProblemUser();
        assertEquals("Welcome to the Target Market, problem_user!", targetMarketHomePage.getWelcomeText());

    }
    @Parameters("chrome")
    @Test
    void testLoginWithLockedOutUser() {
        InarHomePage homePage = new InarHomePage();
        LoginPage loginPage = homePage.clickTargetMarketLink();
        loginPage.loginWithLockedOutUser();
        assertEquals("Your account is locked.", loginPage.getLockedOutUserError().getText());

    }
    @Parameters("chrome")
    @Test
    void testLoginWithPerformanceGlitchUser() {
        InarHomePage homePage = new InarHomePage();
        LoginPage loginPage = homePage.clickTargetMarketLink();
        TargetMarketHomePage targetMarketHomePage = loginPage.loginWithPerformanceGlitchUser();
        assertEquals("Welcome to the Target Market, performance_glitch_user!", targetMarketHomePage.getWelcomeText());

    }

}
