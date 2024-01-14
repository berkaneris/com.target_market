package pages.LoginPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeSuite;
import pages.BasePage;
import utils.DriverManager;

public class TargetMarketLoginPage extends BasePage {
    @FindBy(linkText = "Target Market")
    WebElement target;

    @FindBy(css = "#login-username-input")
    WebElement loginNameInput;
    @FindBy(css = "#login-password-input")
    WebElement loginPasswordInput;

    @FindBy(css = "#login-button")
    WebElement loginButton;

    @FindBy(css = "#username-error-alert")
    WebElement lockedOutUserError;

    public WebElement getLockedOutUserError() {
        return lockedOutUserError;
    }

    public void loginWithStandardUser() {
        loginNameInput.sendKeys("standard_user");
        loginPasswordInput.sendKeys("secret_password");
        loginButton.click();
    }

    public void loginWithLockedOutUser() {
        //should prompt an error
        loginNameInput.sendKeys("locked_out_user");
        loginPasswordInput.sendKeys("secret_password");
        loginButton.click();
    }

    public void loginWithProblemUser() {
        loginNameInput.sendKeys("problem_user");
        loginPasswordInput.sendKeys("secret_password");
        loginButton.click();
    }

    public void loginWithPerformanceGlitchUser() {
        loginNameInput.sendKeys("performance_glitch_user");
        loginPasswordInput.sendKeys("secret_password");
        loginButton.click();
    }

}
