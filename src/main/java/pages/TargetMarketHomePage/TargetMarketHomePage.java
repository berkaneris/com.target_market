package pages.TargetMarketHomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage.BasePage;
import pages.ShoppingCartPage.ShoppingCart_Page;
import utils.PurchaseElementSelector;

import java.util.ArrayList;
import java.util.List;

public class TargetMarketHomePage extends BasePage {

    @FindBy(css = "a[data-rr-ui-event-key='1']")
    protected WebElement allTab;
    @FindBy(css = "a[data-rr-ui-event-key='2']")
    protected WebElement smartphonesTab;
    @FindBy(css = "a[data-rr-ui-event-key='3']")
    protected WebElement laptopsTab;
    @FindBy(css = "a[data-rr-ui-event-key='4']")
    protected WebElement skincareTab;
    @FindBy(css = "a[data-rr-ui-event-key='5']")
    protected WebElement groceriesTab;
    @FindBy(css = "a[data-rr-ui-event-key='6']")
    protected WebElement homeDecorationTab;
    @FindBy(css = "a[data-rr-ui-event-key='7']")
    protected WebElement furnitureTab;
    @FindBy(css = "a[data-rr-ui-event-key='8']")
    protected WebElement topsTab;
    @FindBy(css = "a[data-rr-ui-event-key='9']")
    protected WebElement womensDressesTab;
    @FindBy(css = "a[data-rr-ui-event-key='10']")
    protected WebElement womensShoesTab;

    @FindBy(css = "h5.display-5")
    protected WebElement welcomeText;

    @FindBy(xpath = "//button[text()='Logout']")
    protected WebElement logoutButton;

    @FindBy(css = "button.mx-3:nth-child(2)")
    protected WebElement shoppingButton;

    @FindBy(id = "sortType")
    protected WebElement sortDropDown;

    @FindBy(css = "div.card-body")
    protected List<WebElement> itemsList;

    public String getWelcomeText() {
        wait.until(ExpectedConditions.visibilityOf(welcomeText));
        return welcomeText.getText();
    }
    public void clickOnAllTab(){
       allTab.click();
    }

    public void clickOnSmartPhonesTab(){
        smartphonesTab.click();
    }

    public void clickOnLaptopsTab(){
        laptopsTab.click();
    }

    public void clickOnSkincareTab(){
        skincareTab.click();
    }
    public void clickOnGroceriesTab(){
        groceriesTab.click();
    }
    public void clickOnHomeDecorationTab(){
        homeDecorationTab.click();
    }
    public void clickOnFurnitureTab(){
        furnitureTab.click();
    }

    public void clickOnTopsTab(){
        topsTab.click();
    }
    public void clickOnWomenDressesTab(){
        womensDressesTab.click();
    }
    public void clickOnWomenShoesTab(){
        womensShoesTab.click();
    }
    public void clickOnLogoutButton(){
        logoutButton.click();
    }

    public WebElement getItem(String itemName){
        for(int i = 0;  i < itemsList.size(); i++){
            if(PurchaseElementSelector.getName(itemsList.get(i)).getText().equals(itemName)){
                return itemsList.get(i);
            }
        }
        return null;
    }
    public void clickOnAddButton(String itemName){
        PurchaseElementSelector.getAddToCArtButton(getItem(itemName)).click();
    }
    public String getAddedItemQuantity(){
       return shoppingButton.findElement(By.cssSelector("span")).getText();
    }
    public ShoppingCart_Page clickOnShoppingButton(){
        shoppingButton.click();
        return new ShoppingCart_Page();
    }

    public List<String> getItemNameList(){
        List<String> itemNameList = new ArrayList<>();
        for(int i = 0;  i < itemsList.size(); i++){
            itemNameList.add(PurchaseElementSelector.getName(itemsList.get(i)).getText());
        }
        return itemNameList;
    }
}

