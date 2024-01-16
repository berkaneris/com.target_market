package tests.priorityBasedTests;

import org.testng.annotations.*;
import pages.targetMarket.CheckOutPage;
import pages.targetMarket.InarHomePage;
import pages.targetMarket.ShoppingCartPage;
import pages.targetMarket.TargetMarketHomePage;
import pages.targetMarket.LoginPage;
import utils.DriverManager;

public class Hooks2 {

    protected InarHomePage homePage;
    protected LoginPage loginPage;
    protected CheckOutPage checkOutPage;
    protected ShoppingCartPage shoppingCartPage;
    protected TargetMarketHomePage targetMarketHomePage;

    @Parameters("browser")
    @BeforeClass
    public static void SetUpTestEnvironment(@Optional("defaultBrowser")String browserType) {
        DriverManager.getDriver(browserType);
    }



    @AfterClass
    public static void tearDownTestEnvironment() {
        DriverManager.closeDriver();
    }
}
