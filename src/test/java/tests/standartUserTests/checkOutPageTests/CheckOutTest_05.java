package tests.standartUserTests.checkOutPageTests;

import tests.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;
import utils.BrowserUtils;

public class CheckOutTest_05 extends Hooks {

	@Test
	public void testSuccessfulCheckOutProcess() {
		homePage = new InarHomePage();
		loginPage = homePage.clickTargetMarketLink();
		targetMarketHomePage = loginPage.loginWithStandardUser();
		BrowserUtils.wait(4);
		BrowserUtils.scrollDownWithPageDown();
		targetMarketHomePage.clickOnLaptopsTab();
		BrowserUtils.scrollDownWithPageDown();
		targetMarketHomePage.clickOnAddButton("MacBook Pro");
		shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
		shoppingCartPage.clickOnCheckoutButton();
		checkOutPage = targetMarketHomePage.clickOnShoppingButton().clickOnCheckoutButton();
		checkOutPage.enterAllInformation("bilal", "topal", "hullcity", "1234567891234567", "4567891230");
		BrowserUtils.scrollDownWithPageDown();
		checkOutPage.clickOnPlaceOrder();
		String expectedMessageAfterPurchase = "Thanks!\n" + "Hello, bilal topal!\n" + "Your order has been received.\n"
				+ "Total Price: $1749.00\n" + "Total Product Count: 1";
		String actualMessageAfterPurcase = targetMarketHomePage.messageAfterOrderProcessCompleted();
		Assert.assertEquals(actualMessageAfterPurcase, expectedMessageAfterPurchase,
				"Message appear after ordering product should be as " + expectedMessageAfterPurchase);

	}

}
