package Tests.CheckOutPageTests;

import Tests.BaseTests.Hooks;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.InarHomePage.InarHomePage;

public class CheckOutTest_02 extends Hooks {

    @Test
    public void testFailedCheckoutProcess(){
        homePage = new InarHomePage();
        loginPage = homePage.clickTargetMarketLink();
        targetMarketHomePage = loginPage.loginWithStandardUser();
        targetMarketHomePage.clickOnLaptopsTab();
        targetMarketHomePage.clickOnAddButton("MacBook Pro");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(targetMarketHomePage.isAddedToCartButtonDisplayed("MacBook Pro"));
        shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
        checkOutPage = shoppingCartPage.clickOnCheckoutButton();
        checkOutPage.enterAllInformation("Bilal" , "" ,"daddyhome", "1234567890123456" , "1234567890");
        checkOutPage.clickOnPlaceOrder();
        sa.assertEquals(checkOutPage.getAlertMessageText(2) , "Last name is required" , "The alert message for the last name should be displayed.");
        sa.assertAll();
    }
}
