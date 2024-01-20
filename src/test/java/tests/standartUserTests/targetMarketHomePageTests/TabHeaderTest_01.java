package tests.standartUserTests.targetMarketHomePageTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;
import tests.Hooks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TabHeaderTest_01 extends Hooks {

	List<String> tabNamesList = new ArrayList<>(Arrays.asList("All", "Smartphones", "Laptops", "Skincare", "Groceries",
			"Home Decoration", "Furniture", "Tops", "Womens Dresses", "Womens Shoes"));

	@Test
	public void testTabHeaderName() {
		homePage = new InarHomePage();
		loginPage = homePage.clickTargetMarketLink();
		targetMarketHomePage = loginPage.loginWithStandardUser();

		for (String tabName : tabNamesList) {
			targetMarketHomePage.clickOnTab(tabName);
			Assert.assertEquals(targetMarketHomePage.getTabNameHeader(), tabName,
					"The tab header name should be same with the tab name after click process");
		}

	}

}
