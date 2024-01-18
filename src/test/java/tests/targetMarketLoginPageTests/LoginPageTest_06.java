package tests.targetMarketLoginPageTests;

import tests.Hooks;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;

public class LoginPageTest_06 extends Hooks {

	@DataProvider(name = "loginCredentialsProvider")
	public Object[][] provideLoginCredentials() {
		return new Object[][] { { "standard_user", "secret_password", true },
				{ "locked_out_user", "secret_password", false }, { "problem_user", "secret_password", true },
				{ "performance_glitch_user", "secret_password", true } };
	}

	@Test(dataProvider = "loginCredentialsProvider")
	public void testLoginWithDifferentUsers(String username, String password, boolean shouldLoginSucceed) {
		homePage = new InarHomePage();
		loginPage = homePage.clickTargetMarketLink();
		loginPage.loginWithAnyUser(username, password);
		boolean isLoginSuccess = loginPage.isLoginSuccessful();
		if (shouldLoginSucceed) {
			softAssert.assertTrue(isLoginSuccess, "Expected successful login for user: " + username);
		}
		else {
			softAssert.assertFalse(isLoginSuccess, "Expected failed login for user: " + username);
		}
	}

}
