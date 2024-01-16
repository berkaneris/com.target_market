package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import pages.targetMarket.CheckOutPage;
import pages.targetMarket.InarHomePage;
import pages.targetMarket.ShoppingCartPage;
import pages.targetMarket.TargetMarketHomePage;
import pages.targetMarket.LoginPage;
import utils.DriverManager;



public class Hooks {

    protected InarHomePage homePage;
    protected LoginPage loginPage;
    protected CheckOutPage checkOutPage;
    protected ShoppingCartPage shoppingCartPage;
    protected TargetMarketHomePage targetMarketHomePage;
    protected SoftAssert softAssert = new SoftAssert();

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
