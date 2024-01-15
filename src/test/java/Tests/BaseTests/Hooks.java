package Tests.BaseTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.CheckOutPage.CheckOutPage;
import pages.InarHomePage.InarHomePage;
import pages.ShoppingCartPage.ShoppingCartPage;
import pages.TargetMarketHomePage.TargetMarketHomePage;
import pages.TargetMarketLoginPage.LoginPage;
import utils.DriverManager;



public class Hooks {

    protected InarHomePage homePage;
    protected LoginPage loginPage;
    protected CheckOutPage checkOutPage;
    protected ShoppingCartPage shoppingCartPage;
    protected TargetMarketHomePage targetMarketHomePage;

    @Parameters("browser")
    @BeforeMethod
    public static void SetUpTestEnvironment(@Optional("defaultBrowser")String browserType) {
        DriverManager.getDriver(browserType);
    }



    @AfterMethod
    public static void tearDownTestEnvironment() {
        DriverManager.closeDriver();
    }

}
