package tests.standartUserTests.targetMarketHomePageTests;

import tests.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;
import utils.BrowserUtils;

import java.util.Collections;
import java.util.List;

public class SortByTest_02 extends Hooks {

	@Test
	public void testSortByZToA() {
		homePage = new InarHomePage();
		loginPage = homePage.clickTargetMarketLink();
		targetMarketHomePage = loginPage.loginWithStandardUser();
		BrowserUtils.wait(4);
		BrowserUtils.scrollDownWithPageDown();
		targetMarketHomePage.clickOnLaptopsTab();
		targetMarketHomePage.sortBy("A-Z");
		List<String> namesOfProducts = targetMarketHomePage.getItemNameList();
		BrowserUtils.wait(1);
		targetMarketHomePage.sortBy("Z-A");
		List<String> namesOfProducts2 = targetMarketHomePage.getItemNameList();
		Collections.reverse(namesOfProducts);
		Assert.assertEquals(namesOfProducts, namesOfProducts2);
	}

}
