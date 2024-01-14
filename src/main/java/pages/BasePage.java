package pages;

import org.openqa.selenium.WebDriver;
<<<<<<< HEAD
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
=======
import org.openqa.selenium.interactions.Actions;
>>>>>>> 36925e7a5aaa36aeee529155eb1b6cd7a825da20
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public abstract class BasePage {

    protected final WebDriver DRIVER = DriverManager.getDriver();

    protected WebDriverWait wait = new WebDriverWait(DRIVER, Duration.ofSeconds(10));

    public Actions actions = new Actions(DRIVER);

    public BasePage() {
        PageFactory.initElements(DRIVER, this);
<<<<<<< HEAD

        DRIVER.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

=======
        DRIVER.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
>>>>>>> 36925e7a5aaa36aeee529155eb1b6cd7a825da20
    }
}