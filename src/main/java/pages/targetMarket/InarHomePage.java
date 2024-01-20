package pages.targetMarket;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class InarHomePage extends BasePage {

	// Locators
	@FindBy(linkText = "Target Market")
	private WebElement targetMarketLink;

	@FindBy(css = "h1.display-1.text-fifth")
	private WebElement exploreInarTestingWorldTitletext;

	// Constructor
	public InarHomePage() {
		super();
	}

	// Page Actions with Java Methods
	public LoginPage clickTargetMarketLink() {
		targetMarketLink.click();
		return new LoginPage();
	}

	public String getWelcomeText() {
		return exploreInarTestingWorldTitletext.getText();
	}

	public void refreshPage() {
		DRIVER.navigate().refresh();
	}

}
