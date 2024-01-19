package tests.ProblemUser;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.targetMarket.InarHomePage;
import pages.targetMarket.LoginPage;
import pages.targetMarket.TargetMarketHomePage;
import tests.Hooks;
import utils.BrowserUtils;

import java.util.List;

public class AfterLogOutCartTest extends Hooks {

    @Test
    public void cartAfterLogOut() {
        InarHomePage homePage = new InarHomePage();
        LoginPage loginPage = homePage.clickTargetMarketLink();
        TargetMarketHomePage targetMarketHomePage = loginPage.loginWithProblemUser();
        BrowserUtils.wait(4);
        BrowserUtils.scrollDownWithPageDown();
        //
        targetMarketHomePage.clickOnHomeDecorationTab();
        BrowserUtils.scrollDownWithPageDown();
        List<String> namesOfProductsInPage = targetMarketHomePage.getItemNameList2();
        BrowserUtils.wait(3);
        targetMarketHomePage.clickOnAddButton(namesOfProductsInPage.get(1));
        BrowserUtils.wait(5);
        BrowserUtils.scrollUpWithPageUp();
        BrowserUtils.scrollUpWithPageUp();
        //
        targetMarketHomePage.clickOnLogoutButton();
        BrowserUtils.wait(4);

        //
        loginPage.loginWithProblemUser();
        BrowserUtils.wait(4);

        //
        shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
        BrowserUtils.wait(4);
        boolean actual = shoppingCartPage.isItemOnCart(namesOfProductsInPage.get(1));
        boolean expected = true;
        Assert.assertEquals(actual, expected, "After logout re-enter account user should see cart as left here " + namesOfProductsInPage.get(1));


    }
}