package Tests.BaseTests;

import org.testng.annotations.*;
import pages.CheckOutPage.CheckOutPage;
import pages.InarHomePage.InarHomePage;
import pages.ShoppingCartPage.ShoppingCartPage;
import pages.TargetMarketHomePage.TargetMarketHomePage;
import pages.TargetMarketLoginPage.LoginPage;
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
