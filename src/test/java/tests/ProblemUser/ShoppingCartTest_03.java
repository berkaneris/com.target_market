package tests.ProblemUser;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.targetMarket.InarHomePage;
import pages.targetMarket.LoginPage;
import pages.targetMarket.TargetMarketHomePage;
import tests.Hooks;
import utils.BrowserUtils;

import java.util.List;

public class ShoppingCartTest_03 extends Hooks {

	@Test
	public void cartGetEmptyAfterShoppingTest() {
		homePage = new InarHomePage();
		loginPage = homePage.clickTargetMarketLink();
		targetMarketHomePage = loginPage.loginWithProblemUser();
		BrowserUtils.wait(4);
		BrowserUtils.scrollDownWithPageDown();
		targetMarketHomePage.clickOnGroceriesTab();
		BrowserUtils.scrollDownWithPageDown();
		// BrowserUtils.scrollDownWithPageDown();
		List<String> namesOfProducts = targetMarketHomePage.getItemNameList2();
		double actualTotalPrice = 0;
		for (int i = 0; i < namesOfProducts.size(); i++) {
			if (i != 0 && i % 4 == 0) {
				BrowserUtils.scrollDownWithPageDown();
				BrowserUtils.wait(1);
			}
			BrowserUtils.wait(3);
			targetMarketHomePage.clickOnAddButton(namesOfProducts.get(i));
			actualTotalPrice += (int) Double
				.parseDouble(targetMarketHomePage.getItemPrice(namesOfProducts.get(i)).substring(1));
		}
		shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
		BrowserUtils.wait(2);
		double expectedTotalPrice = shoppingCartPage.getTotalPrice();
		Assert.assertNotEquals(expectedTotalPrice, actualTotalPrice,
				"Total Price of products should be not calculated");

	}

}
