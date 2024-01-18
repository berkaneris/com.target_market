package tests.targetMarketLoginPageTests;

import tests.Hooks;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;

public class LoginPageTest_03 extends Hooks {

	@Parameters("browser")
	@Test
	void testLoginWithLockedOutUser() {
		homePage = new InarHomePage();
		loginPage = homePage.clickTargetMarketLink();
		loginPage.loginWithLockedOutUser();
		softAssert.assertEquals(loginPage.getLockedOutUserError().getText(), "Your account is locked.");
		softAssert.assertAll();

	}

}
