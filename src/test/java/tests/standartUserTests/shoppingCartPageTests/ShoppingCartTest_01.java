package tests.standartUserTests.shoppingCartPageTests;

import tests.Hooks;
import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;

public class ShoppingCartTest_01 extends Hooks {

	@Test
	public void testEmptyShoppingCart() {
		homePage = new InarHomePage();
		loginPage = homePage.clickTargetMarketLink();
		targetMarketHomePage = loginPage.loginWithStandardUser();

		shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
		softAssert.assertTrue(shoppingCartPage.isEmptyTextDisplayed());
		softAssert.assertAll();
	}

}
