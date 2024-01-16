package tests.standartUserTests.targetMarketHomePageTests;

import tests.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;
import utils.BrowserUtils;

import java.util.Collections;
import java.util.List;

public class SortByTest_04 extends Hooks {

	@Test
	public void testSortByHighestPrice() {
		homePage = new InarHomePage();
		loginPage = homePage.clickTargetMarketLink();
		targetMarketHomePage = loginPage.loginWithStandardUser();
		BrowserUtils.wait(4);
		BrowserUtils.scrollDownWithPageDown();
		targetMarketHomePage.clickOnLaptopsTab();
		targetMarketHomePage.sortBy("Lowest Price");
		List<Integer> pricesOfProducts = targetMarketHomePage.getPriceList();
		BrowserUtils.wait(1);
		targetMarketHomePage.sortBy("Highest Price");
		List<Integer> pricesOfProducts2 = targetMarketHomePage.getPriceList();
		Collections.reverse(pricesOfProducts);
		Assert.assertEquals(pricesOfProducts, pricesOfProducts2);
	}

}
