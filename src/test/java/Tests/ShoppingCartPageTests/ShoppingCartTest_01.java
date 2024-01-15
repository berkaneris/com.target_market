package Tests.ShoppingCartPageTests;

import Tests.BaseTests.Hooks;
import org.testng.annotations.Test;
import pages.InarHomePage.InarHomePage;

import static org.testng.Assert.assertTrue;

public class ShoppingCartTest_01 extends Hooks {

    @Test
    public void testEmptyShoppingCart() {
        homePage = new InarHomePage();
        loginPage = homePage.clickTargetMarketLink();
        targetMarketHomePage = loginPage.loginWithStandardUser();

        shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
        assertTrue(shoppingCartPage.isEmptyTextDisplayed());
    }
}
