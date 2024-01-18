package tests.standartUserTests.targetMarketHomePageTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;
import tests.Hooks;
import utils.BrowserUtils;

public class LogoutTest_02 extends Hooks {

    @Test
    public void testLogoutProcessFromCheckOutPage(){
        homePage = new InarHomePage();
        loginPage = homePage.clickTargetMarketLink();
        targetMarketHomePage = loginPage.loginWithStandardUser();
        targetMarketHomePage.clickOnTab("Skincare");
        targetMarketHomePage.clickOnAddButton("Tree Oil 30ml");
        BrowserUtils.scrollUpWithPageUp();
        targetMarketHomePage.clickOnTab("Womens Shoes");
        targetMarketHomePage.clickOnAddButton("Sneaker shoes");
        shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
        checkOutPage = shoppingCartPage.clickOnCheckoutButton();
        loginPage = checkOutPage.clickOnLogoutButton();
        Assert.assertTrue(loginPage.isLoginPageTextDisplayed());
    }
}
