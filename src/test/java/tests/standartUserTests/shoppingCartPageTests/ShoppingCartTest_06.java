package tests.standartUserTests.shoppingCartPageTests;

import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;
import tests.Hooks;
import utils.BrowserUtils;

import java.util.stream.IntStream;

public class ShoppingCartTest_06 extends Hooks {

	@Test
	public void testShoppingCartTotalPrice() {
		homePage = new InarHomePage();
		loginPage = homePage.clickTargetMarketLink();
		targetMarketHomePage = loginPage.loginWithStandardUser();
		targetMarketHomePage.clickOnTab("Furniture");
		targetMarketHomePage.clickOnAddButton("Sofa for Coffe Cafe");
		double item1Price = targetMarketHomePage.getItemPriceValue("Sofa for Coffe Cafe");
		BrowserUtils.scrollUpWithPageUp();
		targetMarketHomePage.clickOnAllTab();
		targetMarketHomePage.clickOnAddButton("Brown Perfume");
		double item2price = targetMarketHomePage.getItemPriceValue("Brown Perfume");
		IntStream.range(0, 4).forEach(i -> BrowserUtils.scrollUpWithPageUp());
		targetMarketHomePage.clickOnSmartPhonesTab();
		targetMarketHomePage.clickOnAddButton("Samsung Universe 9");
		double item3price = targetMarketHomePage.getItemPriceValue("Samsung Universe 9");
		shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
		shoppingCartPage.clickPlusButtonForItem("Brown Perfume");
		shoppingCartPage.clickPlusButtonForItem("Samsung Universe 9");
		double expectedTotalPrice = (item1Price * shoppingCartPage.getItemQuantityValueOnCart("Sofa for Coffe Cafe"))
				+ (item2price * shoppingCartPage.getItemQuantityValueOnCart("Brown Perfume"))
				+ (item3price * shoppingCartPage.getItemQuantityValueOnCart("Samsung Universe 9"));

		double actualTotalPrice = shoppingCartPage.getTotalPrice();
		softAssert.assertEquals(actualTotalPrice, expectedTotalPrice,
				"The calculated total price should be same with total price on shopping cart");
		softAssert.assertAll();
	}

}
