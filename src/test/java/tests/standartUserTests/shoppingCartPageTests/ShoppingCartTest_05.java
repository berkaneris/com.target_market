package tests.standartUserTests.shoppingCartPageTests;

import tests.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;
import utils.BrowserUtils;

public class ShoppingCartTest_05 extends Hooks {

	@Test
	public void testShoppingCartAfterCheckOut() {
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
		targetMarketHomePage.closeTheTabPopUpAfterPurchase();
		targetMarketHomePage.clickOnShoppingButton();
		// verify that after a purchace process completed your cart is empty
		boolean isCartEmptyAfterPurchaseProcess = true;
		boolean isShoppingCartEmpty = shoppingCartPage.isEmptyTextDisplayed();
		Assert.assertEquals(isShoppingCartEmpty, isCartEmptyAfterPurchaseProcess);
	}

}
