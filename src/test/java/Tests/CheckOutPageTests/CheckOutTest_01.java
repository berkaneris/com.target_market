package Tests.CheckOutPageTests;

import Tests.BaseTests.Hooks;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.InarHomePage.InarHomePage;


public class CheckOutTest_01 extends Hooks {

    @Test
    public void testSuccessfulCheckoutProcess(){
        homePage = new InarHomePage();
        loginPage = homePage.clickTargetMarketLink();
        targetMarketHomePage = loginPage.loginWithStandardUser();
        targetMarketHomePage.clickOnSmartPhonesTab();
        targetMarketHomePage.clickOnAddButton("iPhone X");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(targetMarketHomePage.isAddedToCartButtonDisplayed("iPhone X"));
        shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
        checkOutPage = shoppingCartPage.clickOnCheckoutButton();
        checkOutPage.enterFirstName("Bilal");
        checkOutPage.enterLastName("topal");
        checkOutPage.enterAddress("daddyhome");
        checkOutPage.enterCardNumber("1234567890123456");
        checkOutPage.enterPhoneNumber("1234567890");
        checkOutPage.clickOnPlaceOrder();
        sa.assertTrue(targetMarketHomePage.isOrderReceivedMessageDisplayed());
        sa.assertAll();
    }
}
