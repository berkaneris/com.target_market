package tests.priorityBasedTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import pages.targetMarket.*;
import utils.DriverManager;

public class HooksPriority {

	protected InarHomePage homePage;

	protected LoginPage loginPage;

	protected CheckOutPage checkOutPage;

	protected ShoppingCartPage shoppingCartPage;

	protected TargetMarketHomePage targetMarketHomePage;

	protected SoftAssert softAssert = new SoftAssert();

	@Parameters("browser")
	@BeforeClass
	public static void SetUpTestEnvironment(@Optional("defaultBrowser") String browserType) {
		DriverManager.getDriver(browserType);
	}

	@AfterClass
	public static void tearDownTestEnvironment() {
		DriverManager.closeDriver();
	}

}
