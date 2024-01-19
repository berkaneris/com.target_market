package tests.ProblemUser;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.targetMarket.InarHomePage;
import tests.Hooks;
import utils.BrowserUtils;

public class ShoppingCartTest_02 extends Hooks {
    @Test
    public void testItemQuantityUpdateProcessOnShoppingCart() {
        homePage = new InarHomePage();
        loginPage = homePage.clickTargetMarketLink();
        targetMarketHomePage = loginPage.loginWithProblemUser();
        BrowserUtils.wait(4);
        BrowserUtils.scrollDownWithPageDown();
        targetMarketHomePage.clickOnFurnitureTab();
        BrowserUtils.wait(2);
        BrowserUtils.scrollDownWithPageDown();
        String item1 = "3 Tier Corner Shelves";
        targetMarketHomePage.clickOnAddButton(item1);
        BrowserUtils.wait(2);
        shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
        BrowserUtils.wait(5);
        int count = 1;
        for (int i = 0; i < 4; i++) {
            count++;
            BrowserUtils.wait(1);
            shoppingCartPage.clickPlusButtonForItem(item1);
        }
        int expectedCountOfSelectedItemInCart = count;
        int actualCountOfSelectedItemInCart = Integer.parseInt(shoppingCartPage.getItemQuantityOnCart(item1));
        Assert.assertEquals(actualCountOfSelectedItemInCart, expectedCountOfSelectedItemInCart, "The count of item of " + item1 + "should be " + count);

    }


}
