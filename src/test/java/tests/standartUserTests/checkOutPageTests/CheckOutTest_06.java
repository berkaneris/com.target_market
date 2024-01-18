package tests.standartUserTests.checkOutPageTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;
import tests.Hooks;
import utils.BrowserUtils;

import java.util.List;

public class CheckOutTest_06 extends Hooks {
    @DataProvider(name = "ProductProviderFromDifferentTabs")
    public Object[][] provideLoginCredentials() {
        return new Object[][] {
                { "Groceries", "Elbow Macaroni - 400 gm", "Gulab Powder 50 Gram"},
                { "Womens Dresses", "Ladies Multicolored Dress", "Malai Maxi Dress"},
                { "Womens Shoes", "Sneaker shoes", "Women Strip Heel"},
                { "Smartphones", "iPhone 9", "Huawei P30"},
                { "Skincare", "Skin Beauty Serum.", "Freckle Treatment Cream- 15gm"}};
    }

    @Test(dataProvider = "ProductProviderFromDifferentTabs")
    public void testCheckOutCartItemsInformation(String tabName , String itemName1 , String itemName2){
        homePage = new InarHomePage();
        loginPage = homePage.clickTargetMarketLink();
        targetMarketHomePage = loginPage.loginWithStandardUser();
        targetMarketHomePage.clickOnTab(tabName);
        targetMarketHomePage.clickOnAddButton(itemName1);
        targetMarketHomePage.clickOnAddButton(itemName2);
        shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
        shoppingCartPage.clickPlusButtonForItem(itemName2);
        List<List<String>> itemsInformationOnShoppingCartPage = shoppingCartPage.getItemsNamesAndValuesOnCart();
        checkOutPage = shoppingCartPage.clickOnCheckoutButton();
        List<List<String>> itemsInformationOnCheckOutPage = checkOutPage.getItemsInformationList();
        softAssert.assertEquals(itemsInformationOnCheckOutPage , itemsInformationOnShoppingCartPage);
        softAssert.assertAll();
    }
}
