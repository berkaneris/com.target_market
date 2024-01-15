package pages.ShoppingCartPage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage.BasePage;
import pages.CheckOutPage.CheckOutPage;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = "//button[text()='Go to Checkout']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//button[text()='Close']")
    private WebElement closeButton;

    @FindBy(css = "button[aria-label='Close']")
    private WebElement crossButton;

    @FindBy(css = "div[class='mb-3 list-group'] > div")
    private List<WebElement> selectedItems;

    @FindBy(css = ".text-start p")
    private WebElement totalPrice;

    @FindBy(xpath = "//p[contains(text(), 'empty')]")
    private WebElement emptyText;

    private WebElement getItemOnCart(String itemName){
        for(int i = 0; i < selectedItems.size(); i++){
            if(selectedItems.get(i).findElement(By.cssSelector("h3")).getText().equalsIgnoreCase(itemName)){
                return selectedItems.get(i);
            }
        }
        return null;
    }
    public boolean isItemOnCart(String itemName){
        return !getItemOnCart(itemName).equals(null);
    }

    public void clickPlusButtonForItem(String itemName){
        getItemOnCart(itemName).findElement(By.xpath("//button[text()='+']")).click();
    }
    public void clickMinusButtonForItem(String itemName){
        getItemOnCart(itemName).findElement(By.xpath("//button[text()='-']")).click();
    }

    public String getTotalPrice(){
        return totalPrice.getText().substring(13);
    }

    public CheckOutPage clickOnCheckoutButton(){
        try {
            checkoutButton.click();
            return new CheckOutPage();
        }catch (NoSuchElementException ex){
            return null;
        }
    }
    public boolean isEmptyTextDisplayed(){
        return emptyText.isDisplayed();
    }
}
