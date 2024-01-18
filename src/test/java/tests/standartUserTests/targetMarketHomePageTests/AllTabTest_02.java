package tests.standartUserTests.targetMarketHomePageTests;

import tests.Hooks;
import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;
import java.util.Collections;
import java.util.List;

public class AllTabTest_02 extends Hooks {

	@Test
	public void testAllTabsSortByAToZ() {

		homePage = new InarHomePage();
		loginPage = homePage.clickTargetMarketLink();
		targetMarketHomePage = loginPage.loginWithStandardUser();
		targetMarketHomePage.clickOnSmartPhonesTab();
		List<String> nameOfItems1 = targetMarketHomePage.getItemNameList();
		targetMarketHomePage.sortBy("A-Z");
		List<String> nameOfItems2 = targetMarketHomePage.getItemNameList();
		softAssert.assertNotEquals(nameOfItems2, nameOfItems1);
		Collections.sort(nameOfItems1);
		softAssert.assertEquals(nameOfItems2, nameOfItems1);
		softAssert.assertAll();
	}

}
