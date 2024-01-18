package tests.standartUserTests.targetMarketHomePageTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;
import tests.Hooks;
import utils.BrowserUtils;

public class LogoutTest_01 extends Hooks {

    @Test
    public void testLogoutProcessFromTargetMarketHomePage(){
        homePage = new InarHomePage();
        loginPage = homePage.clickTargetMarketLink();
        targetMarketHomePage = loginPage.loginWithStandardUser();
        loginPage = targetMarketHomePage.clickOnLogoutButton();
        Assert.assertTrue(loginPage.isLoginPageTextDisplayed());
    }
}
