package tests.ProblemUser;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.targetMarket.InarHomePage;
import tests.Hooks;
import utils.BrowserUtils;

public class CheckoutTest_01 extends Hooks {

	@Test
	public void testSuccessfulCheckoutProcess() {
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
		BrowserUtils.wait(7);
		shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
		BrowserUtils.wait(5);
		BrowserUtils.wait(2);
		checkOutPage = shoppingCartPage.clickOnCheckoutButton();
		BrowserUtils.wait(2);
		checkOutPage.enterAllInformation("joe", "merry", "hullClive", "1234567891234567", "1234567890");
		BrowserUtils.wait(1);
		checkOutPage.clickOnPlaceOrder();
		String expectedMessageAfterPurchase = "Thanks!\n" + "Hello, joe merry!\n" + "Your order has been received.\n"
				+ "Total Price: $700.00\n" + "Total Product Count: 1";
		String actualMessageAfterPurcase = targetMarketHomePage.messageAfterOrderProcessCompleted();
		Assert.assertEquals(actualMessageAfterPurcase, expectedMessageAfterPurchase,
				"Message appear after ordering product should be as " + expectedMessageAfterPurchase);
	}

}
