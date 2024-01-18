package tests.standartUserTests.targetMarketHomePageTests;

import tests.Hooks;
import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;

public class AllTabTest_01 extends Hooks {

	@Test
	public void testAllTabsLink() {
		homePage = new InarHomePage();
		loginPage = homePage.clickTargetMarketLink();
		targetMarketHomePage = loginPage.loginWithStandardUser();
		targetMarketHomePage.clickOnAllTab();
		targetMarketHomePage.clickOnAddButton("iPhone X");
		softAssert.assertEquals(targetMarketHomePage.getAddedItemQuantity(), "1");
		softAssert.assertAll();
	}

}
