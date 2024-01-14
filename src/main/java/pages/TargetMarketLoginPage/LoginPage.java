package pages.TargetMarketLoginPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage.BasePage;
import pages.TargetMarketHomePage.TargetMarketHomePage;


public class LoginPage extends BasePage {
    @FindBy(linkText = "Target Market")
    private WebElement target;

    @FindBy(css = "#login-username-input")
    private WebElement loginNameInput;
    @FindBy(css = "#login-password-input")
    private WebElement loginPasswordInput;

    @FindBy(css = "#login-button")
    private WebElement loginButton;

    @FindBy(css = "#username-error-alert")
    private WebElement lockedOutUserError;

    public WebElement getLockedOutUserError() {
        return lockedOutUserError;
    }

    public TargetMarketHomePage loginWithStandardUser() {
        loginNameInput.sendKeys("standard_user");
        loginPasswordInput.sendKeys("secret_password");
        loginButton.click();
        return new TargetMarketHomePage();
    }

    public void loginWithLockedOutUser() {
        //should prompt an error
        loginNameInput.sendKeys("locked_out_user");
        loginPasswordInput.sendKeys("secret_password");
        loginButton.click();
    }

    public TargetMarketHomePage loginWithProblemUser() {
        loginNameInput.sendKeys("problem_user");
        loginPasswordInput.sendKeys("secret_password");
        loginButton.click();
        return new TargetMarketHomePage();
    }

    public TargetMarketHomePage loginWithPerformanceGlitchUser() {
        loginNameInput.sendKeys("performance_glitch_user");
        loginPasswordInput.sendKeys("secret_password");
        loginButton.click();
        return new TargetMarketHomePage();
    }

}
