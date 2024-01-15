package Tests.ShoppingCartPageTests;

import Tests.BaseTests.Hooks;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.InarHomePage.InarHomePage;
import utils.BrowserUtils;

public class ShoppingCartTest_02 extends Hooks {

    @Test
    public void testSelectedItemsOnShoppingCart(){
        homePage = new InarHomePage();
        loginPage = homePage.clickTargetMarketLink();
        targetMarketHomePage = loginPage.loginWithStandardUser();

        targetMarketHomePage.clickOnFurnitureTab();
        targetMarketHomePage.clickOnAddButton("Plastic Table");
        BrowserUtils.scrollUpWithPageUp();
        targetMarketHomePage.clickOnSkincareTab();
        targetMarketHomePage.clickOnAddButton("Tree Oil 30ml");
        shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(shoppingCartPage.isItemOnCart("Plastic Table"));
        sa.assertTrue(shoppingCartPage.isItemOnCart("Tree Oil 30ml"));
        sa.assertAll();

    }
}
