package tests.standartUserTests.shoppingCartPageTests;

import tests.Hooks;
import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;

public class ShoppingCartTest_03 extends Hooks {

	@Test
	public void testShoppingCartPrice() {
		homePage = new InarHomePage();
		loginPage = homePage.clickTargetMarketLink();
		targetMarketHomePage = loginPage.loginWithStandardUser();
		targetMarketHomePage.clickOnSmartPhonesTab();
		targetMarketHomePage.clickOnAddButton("Samsung Universe 9");
		targetMarketHomePage.clickOnAddButton("iPhone X");
		targetMarketHomePage.clickOnAddButton("iPhone 9");
		shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
		shoppingCartPage.clickPlusButtonForItem("iPhone 9");
		String itemPriceOnCart = shoppingCartPage.getItemPrice("Samsung Universe 9");
		softAssert.assertEquals(itemPriceOnCart, "$1249", "Wrong Price for Item!");
		itemPriceOnCart = shoppingCartPage.getItemPrice("iPhone X");
		softAssert.assertEquals(itemPriceOnCart, "$899", "Wrong Price for Item!");
		itemPriceOnCart = shoppingCartPage.getItemPrice("iPhone 9");
		softAssert.assertEquals(itemPriceOnCart, "$549", "Wrong Price for Item!");
		softAssert.assertAll();
	}

}
