package tests.standartUserTests.targetMarketHomePageTests;

import tests.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;
import utils.BrowserUtils;

import java.util.Collections;
import java.util.List;

public class SortByTest_03 extends Hooks {

	@Test
	public void testSortByLowestPrice() {
		homePage = new InarHomePage();
		loginPage = homePage.clickTargetMarketLink();
		targetMarketHomePage = loginPage.loginWithStandardUser();
		BrowserUtils.wait(4);
		BrowserUtils.scrollDownWithPageDown();
		targetMarketHomePage.clickOnLaptopsTab();
		targetMarketHomePage.sortBy("Lowest Price");
		List<Integer> priceOfProducts = targetMarketHomePage.getPriceList();
		List<Integer> priceOfProducts2 = targetMarketHomePage.getPriceList();
		Collections.sort(priceOfProducts);
		Assert.assertEquals(priceOfProducts, priceOfProducts2);

	}

}
