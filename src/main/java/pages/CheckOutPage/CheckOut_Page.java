package pages.CheckOutPage;

import pages.BasePage.BasePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOut_Page extends BasePage {

    @FindBy(id = "firstName")
    private WebElement firstNameElement;

    @FindBy(id = "#lastName")
    private WebElement lastNameElement;

    @FindBy(id = "#address")
    private WebElement addressElement;

    @FindBy(id = "cardNumber")
    private WebElement cardNumberElement;

    @FindBy(id = "phoneNumber")
    private WebElement phoneNumberElement;

    @FindBy(linkText = "Place Order")
    private WebElement placeOrderElement;


    public void enterFirstName(String firstName) {
        firstNameElement.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameElement.sendKeys(lastName);
    }

    public void enterAddress(String address) {
        addressElement.sendKeys(address);
    }

    public void enterCardNumber(String cardNumber) {
        cardNumberElement.sendKeys(cardNumber);
    }

    public void enterPhoneNumber(String phoneNumber) {
        phoneNumberElement.sendKeys(phoneNumber);
    }

    public void clickOnPlaceOrder(){
        placeOrderElement.click();
    }

}
