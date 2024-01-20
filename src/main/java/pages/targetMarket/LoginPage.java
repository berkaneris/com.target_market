package pages.targetMarket;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class LoginPage extends BasePage {

	@FindBy(linkText = "Target Market")
	private WebElement target;

	@FindBy(css = "#login-username-input")
	private WebElement loginNameInput;

	@FindBy(css = "#login-password-input")
	private WebElement loginPasswordInput;

	@FindBy(css = "#login-button")
	private WebElement loginButton;

	@FindBy(id = "username-error-alert")
	private WebElement userNameErrorAlert;

	@FindBy(id = "password-error-alert")
	private WebElement passWordErrorAlert;

	@FindBy(xpath = "//p[contains(text() , 'please login')]")
	private WebElement loginPageText;

	public WebElement getLockedOutUserError() {
		return userNameErrorAlert;
	}

	public TargetMarketHomePage loginWithStandardUser() {
		loginNameInput.sendKeys("standard_user");
		loginPasswordInput.sendKeys("secret_password");
		loginButton.click();
		return new TargetMarketHomePage();
	}

	public void loginWithLockedOutUser() {
		// should prompt an error
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

	public TargetMarketHomePage loginWithAnyUser(String username, String password) {
		loginNameInput.sendKeys(username);
		loginPasswordInput.sendKeys(password);
		loginButton.click();
		if (isLoginSuccessful()) {
			return new TargetMarketHomePage();
		}
		return null;
	}

	public boolean isLoginSuccessful() {
		try {
			TargetMarketHomePage targetMarketHomePage = new TargetMarketHomePage();
			if (targetMarketHomePage.isWelcomeMessageDisplayed()) {
				return true;
			}
		}
		catch (NoSuchElementException ex) {

		}
		return false;
	}

	public boolean isUserNameErrorAlertDisplayed() {
		return userNameErrorAlert.isDisplayed();
	}

	public boolean isPasswordErrorAlertDisplayed() {
		return passWordErrorAlert.isDisplayed();
	}

	public boolean isLoginPageTextDisplayed() {
		return loginPageText.isDisplayed();
	}

}
