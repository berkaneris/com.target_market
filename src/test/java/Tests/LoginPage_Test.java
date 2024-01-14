package Tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage.TargetMarketLoginPage;
import pages.TargetMarketHomePage;

import static org.testng.Assert.assertEquals;

public class LoginPage_Test extends Hooks {


    @Parameters("chrome")
    @Test
    void testLoginWithStandardUser() {
        HomePage homePage = new HomePage();
        homePage.clickTargetMarketLink();

        TargetMarketLoginPage loginPage = new TargetMarketLoginPage();
        loginPage.loginWithStandardUser();

        TargetMarketHomePage targetMarketHomePage=new TargetMarketHomePage();

        assertEquals("Welcome to the Target Market, standard_user!", targetMarketHomePage.getWelcomeText());

    }
    @Parameters("chrome")
    @Test
    void testLoginWithProblemUser() {
        HomePage homePage = new HomePage();
        homePage.clickTargetMarketLink();

        TargetMarketLoginPage loginPage = new TargetMarketLoginPage();
        loginPage.loginWithProblemUser();
        TargetMarketHomePage targetMarketHomePage=new TargetMarketHomePage();
        assertEquals("Welcome to the Target Market, problem_user!", targetMarketHomePage.getWelcomeText());

    }
    @Parameters("chrome")
    @Test
    void testLoginWithLockedOutUser() {
        HomePage homePage = new HomePage();
        homePage.clickTargetMarketLink();

        TargetMarketLoginPage loginPage = new TargetMarketLoginPage();
        loginPage.loginWithLockedOutUser();
        TargetMarketHomePage targetMarketHomePage=new TargetMarketHomePage();
        assertEquals("Your account is locked.", loginPage.getLockedOutUserError().getText());

    }
    @Parameters("chrome")
    @Test
    void testLoginWithPerformanceGlitchUser() {
        HomePage homePage = new HomePage();
        homePage.clickTargetMarketLink();
        TargetMarketHomePage targetMarketHomePage=new TargetMarketHomePage();
        TargetMarketLoginPage loginPage = new TargetMarketLoginPage();
        loginPage.loginWithPerformanceGlitchUser();

        assertEquals("Welcome to the Target Market, performance_glitch_user!", targetMarketHomePage.getWelcomeText());

    }

}
