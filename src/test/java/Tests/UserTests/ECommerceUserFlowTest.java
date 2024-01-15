package Tests.UserTests;

import Tests.BaseTests.Hooks2;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InarHomePage.InarHomePage;

public class ECommerceUserFlowTest extends Hooks2 {

    @Test(priority = 1)
    public void loginTest(){
        homePage = new InarHomePage();
        loginPage = homePage.clickTargetMarketLink();
        targetMarketHomePage = loginPage.loginWithStandardUser();
        Assert.assertTrue(loginPage.isLoginSuccessful() , "User should be successfully logged in.");
    }

    @Test(priority = 2, dependsOnMethods = "loginTest")
    public void addToCartTest(){
        targetMarketHomePage.clickOnSmartPhonesTab();
        targetMarketHomePage.clickOnAddButton("iPhone X");
        shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
        Assert.assertTrue(shoppingCartPage.isItemOnCart("iPhone X"), "Product should be successfully added to the cart.");
    }

    @Test(priority = 3, dependsOnMethods = "addToCartTest")
    public void placeOrderTest(){
        checkOutPage = shoppingCartPage.clickOnCheckoutButton();
        checkOutPage.enterAllInformation("John", "Doe", "123 Main St",
                "4111111111111111", "0102030405");
        targetMarketHomePage = checkOutPage.clickOnPlaceOrder();
        Assert.assertTrue(targetMarketHomePage.isOrderConfirmationBoxDisplayed() , "Order should be successfully placed and confirmed.");
    }
}
