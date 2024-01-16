package tests.standartUserTests.shoppingCartPageTests;

import tests.Hooks;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;

public class ShoppingCartTest_04 extends Hooks {

    @DataProvider(name = "DifferentProductsProvider")
    public Object[][] provideLoginCredentials() {
        return new Object[][] {
                {"All", "perfume Oil", "cereals muesli fruit nuts" , "$13" , "$46" },
                {"Laptops", "Infinix INBOOK", "Microsoft Surface Laptop 4" , "$1099" , "$1499"},
                {"Home Decoration", "Handcraft Chinese style", "Key Holder" , "$60" , "$30" }
        };
    }

    @Test(dataProvider = "DifferentProductsProvider")
    public void testShoppingCartWithDifferentProducts(String tabName, String itemName1, String itemName2 , String priceItem1 , String priceItem2) {
        homePage = new InarHomePage();
        loginPage = homePage.clickTargetMarketLink();
        targetMarketHomePage = loginPage.loginWithStandardUser();
        targetMarketHomePage.clickOnTab(tabName);
        targetMarketHomePage.clickOnAddButton(itemName1);
        targetMarketHomePage.clickOnAddButton(itemName2);
        shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
        softAssert.assertTrue(shoppingCartPage.isItemOnCart(itemName1));
        softAssert.assertTrue(shoppingCartPage.isItemOnCart(itemName2));
        softAssert.assertEquals(shoppingCartPage.getItemPrice(itemName1) , priceItem1);
        softAssert.assertEquals(shoppingCartPage.getItemPrice(itemName2) , priceItem2);
        softAssert.assertAll();
    }
}
