package Tests;


<<<<<<< HEAD
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.DriverManager;

import java.time.Duration;

public class Hooks {
    @Parameters("browser")
    @BeforeMethod
    public static void SetUpTestEnvironment(@Optional("defaultBrowser")String browserType) {
        DriverManager.getDriver(browserType);

=======
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.DriverManager;

public class Hooks {

    @Parameters("browser")
    @BeforeMethod
    public static void SetUpTestEnvironment(String browserType) {
        DriverManager.getDriver(browserType);
>>>>>>> 36925e7a5aaa36aeee529155eb1b6cd7a825da20
    }

    @AfterMethod
    public static void tearDownTestEnvironment() {
        DriverManager.closeDriver();
    }

}
