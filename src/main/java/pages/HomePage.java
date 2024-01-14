package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
<<<<<<< HEAD

    // Locators
    @FindBy(linkText = "Weborder")
    private WebElement webOrderLink;

    @FindBy(linkText = "Webautomation")
    private WebElement webAutomationLink;

    @FindBy(linkText = "Target Market")
    private WebElement targetMarketLink;

    @FindBy(linkText = "Booking")
    private WebElement bookingLink;

    @FindBy(linkText = "Handling Certifications")
    private WebElement handlingCertificationLink;

    @FindBy(linkText = "File Uploading")
    private WebElement fileUploadingLink;

    @FindBy(css = "h1.display-1.text-fifth")
    private WebElement exploreInarTestingWorldTitletext;

    // Constructor
    public HomePage() {
        super();
    }

    // Page Actions with Java Methods
    public void clickOnWeborderLink() {
        webOrderLink.click();
    }

    public void clickWebAutomationLink() {
        webAutomationLink.click();
    }

    public void clickTargetMarketLink() {
        targetMarketLink.click();
    }

    public void clickBookingLink() {
        bookingLink.click();
    }

    public void clickHandlingCertificationLink() {
        handlingCertificationLink.click();
    }

    public void clickFileUploadingLink() {
        fileUploadingLink.click();
    }

    public String getWelcomeText() {
        return exploreInarTestingWorldTitletext.getText();
    }

    public void refreshPage() {
       DRIVER.navigate().refresh();
    }
}
=======
    @FindBy(linkText = "Target Market")
    private WebElement targetMarketLink;

    public void clickOnTargetMarketLink() {
        targetMarketLink.click();
    }
}
>>>>>>> 36925e7a5aaa36aeee529155eb1b6cd7a825da20
