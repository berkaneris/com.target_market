package Tests.Hooks;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.DriverManager;



public class Hooks {
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
