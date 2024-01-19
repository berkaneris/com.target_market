package tests.standartUserTests.checkOutPageTests;

import tests.Hooks;
import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;
import utils.BrowserUtils;

public class CheckOutTest_02 extends Hooks {

	@Test
	public void testFailedCheckoutProcess() {
		homePage = new InarHomePage();
		loginPage = homePage.clickTargetMarketLink();
		targetMarketHomePage = loginPage.loginWithStandardUser();
		BrowserUtils.scrollDownWithPageDown();
		targetMarketHomePage.clickOnLaptopsTab();
		BrowserUtils.scrollDownWithPageDown();
		targetMarketHomePage.clickOnAddButton("MacBook Pro");
		softAssert.assertTrue(targetMarketHomePage.isAddedToCartButtonDisplayed("MacBook Pro"));
		shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
		checkOutPage = shoppingCartPage.clickOnCheckoutButton();
		checkOutPage.enterAllInformation("Bilal", "", "daddyhome", "1234567890123456", "1234567890");
		checkOutPage.clickOnPlaceOrder();
		softAssert.assertEquals(checkOutPage.getAlertMessageText(2), "Last name is required",
				"The alert message for the last name should be displayed.");
		softAssert.assertAll();
	}

}
