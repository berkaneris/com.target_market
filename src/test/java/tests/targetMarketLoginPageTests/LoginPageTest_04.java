package tests.targetMarketLoginPageTests;

import tests.Hooks;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;

public class LoginPageTest_04 extends Hooks {

	@Parameters("browser")
	@Test
	void testLoginWithPerformanceGlitchUser() {
		homePage = new InarHomePage();
		loginPage = homePage.clickTargetMarketLink();
		targetMarketHomePage = loginPage.loginWithPerformanceGlitchUser();
		softAssert.assertEquals(targetMarketHomePage.getWelcomeText(),
				"Welcome to the Target Market, performance_glitch_user!");
		softAssert.assertAll();
	}

}
