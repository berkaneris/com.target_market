package tests.standartUserTests.shoppingCartPageTests;

import tests.Hooks;
import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;
import utils.BrowserUtils;

public class ShoppingCartTest_02 extends Hooks {

	@Test
	public void testSelectedItemsOnShoppingCart() {
		homePage = new InarHomePage();
		loginPage = homePage.clickTargetMarketLink();
		targetMarketHomePage = loginPage.loginWithStandardUser();

		targetMarketHomePage.clickOnFurnitureTab();
		targetMarketHomePage.clickOnAddButton("Plastic Table");
		BrowserUtils.scrollUpWithPageUp();
		targetMarketHomePage.clickOnSkincareTab();
		targetMarketHomePage.clickOnAddButton("Tree Oil 30ml");
		shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
		softAssert.assertTrue(shoppingCartPage.isItemOnCart("Plastic Table"));
		softAssert.assertTrue(shoppingCartPage.isItemOnCart("Tree Oil 30ml"));
		softAssert.assertAll();

	}

}
