package Tests.TargetMarketLoginPageTests;

import Tests.BaseTests.Hooks;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.InarHomePage.InarHomePage;

import static org.testng.Assert.assertEquals;

public class LoginPageTest_04 extends Hooks {

    @Parameters("chrome")
    @Test
    void testLoginWithPerformanceGlitchUser() {
        homePage = new InarHomePage();
        loginPage = homePage.clickTargetMarketLink();
        targetMarketHomePage = loginPage.loginWithPerformanceGlitchUser();
        assertEquals("Welcome to the Target Market, performance_glitch_user!", targetMarketHomePage.getWelcomeText());
    }
}
