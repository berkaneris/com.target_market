package tests.targetMarketLoginPageTests;

import tests.Hooks;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;

public class LoginPageTest_02 extends Hooks {

	@Parameters("browser")
	@Test
	void testLoginWithProblemUser() {
		homePage = new InarHomePage();
		loginPage = homePage.clickTargetMarketLink();
		targetMarketHomePage = loginPage.loginWithProblemUser();
		softAssert.assertEquals(targetMarketHomePage.getWelcomeText(), "Welcome to the Target Market, problem_user!");

	}

}
