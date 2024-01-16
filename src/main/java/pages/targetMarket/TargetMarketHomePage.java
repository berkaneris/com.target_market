package pages.targetMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import utils.BrowserUtils;
import utils.DriverManager;


import java.util.ArrayList;
import java.util.List;

public class TargetMarketHomePage extends BasePage {

    @FindBy(css = "a[data-rr-ui-event-key='1']")
    private WebElement allTab;
    @FindBy(css = "a[data-rr-ui-event-key='2']")
    private WebElement smartphonesTab;
    @FindBy(css = "a[data-rr-ui-event-key='3']")
    private WebElement laptopsTab;
    @FindBy(css = "a[data-rr-ui-event-key='4']")
    private WebElement skincareTab;
    @FindBy(css = "a[data-rr-ui-event-key='5']")
    private WebElement groceriesTab;
    @FindBy(css = "a[data-rr-ui-event-key='6']")
    private WebElement homeDecorationTab;
    @FindBy(css = "a[data-rr-ui-event-key='7']")
    private WebElement furnitureTab;
    @FindBy(css = "a[data-rr-ui-event-key='8']")
    private WebElement topsTab;
    @FindBy(css = "a[data-rr-ui-event-key='9']")
    private WebElement womensDressesTab;
    @FindBy(css = "a[data-rr-ui-event-key='10']")
    private WebElement womensShoesTab;

    @FindBy(css = "h5.display-5")
    private WebElement welcomeText;

    @FindBy(xpath = "//button[text()='Logout']")
    private WebElement logoutButton;

    @FindBy(css = "button.mx-3:nth-child(2)")
    private WebElement shoppingButton;

    @FindBy(id = "sortType")
    private WebElement sortDropDown;

    @FindBy(css = "div.card-body")
    private List<WebElement> itemsList;

    @FindBy(css= ".display-1")
    private WebElement tabNameHeader;
    @FindBy(xpath = "//p[contains(text() , 'received')]")
    private WebElement orderReceivedMessage;

    @FindBy(css = "#target-market .text-center")
    private WebElement orderConfirmationBox;

    @FindBy(css = "div a[role='tab']")
    private List<WebElement> tabsList;

    @FindBy(css = ".text-center.bg-light.p-5.rounded-3.position-relative")
    private List<WebElement> messageAppearAfterPurchaseProcess;

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


    public LoginPage clickOnLogoutButton(){
        logoutButton.click();
        return new LoginPage();
    }

    public String getWelcomeText() {
        wait.until(ExpectedConditions.visibilityOf(welcomeText));
        return welcomeText.getText();
    }
    public boolean isWelcomeMessageDisplayed(){
        try {
            return welcomeText.isDisplayed();
        }catch (NoSuchElementException ex){
            return false;
        }
    }
    private WebElement getItem(String itemName){
        for(int i = 0;  i < itemsList.size(); i++){
            if(BrowserUtils.getName(itemsList.get(i)).getText().equals(itemName)){
                return itemsList.get(i);
            }
        }
        return null;
    }
    public void clickOnAddButton(String itemName){
        BrowserUtils.getAddToCArtButton(getItem(itemName)).click();
    }
    public String getAddedItemQuantity(){
       return shoppingButton.findElement(By.cssSelector("span")).getText();
    }
    public ShoppingCartPage clickOnShoppingButton(){
        shoppingButton.click();
        return new ShoppingCartPage();
    }

    public List<String> getItemNameList(){
        List<String> itemNameList = new ArrayList<>();
        for(int i = 0;  i < itemsList.size(); i++){
            itemNameList.add(BrowserUtils.getName(itemsList.get(i)).getText().toLowerCase());
        }
        return itemNameList;
    }

    public void sortBy(String sortSelectionText){
        Select select = new Select(sortDropDown);
        select.selectByVisibleText(sortSelectionText);
    }

    public List<Integer> getPriceList(){
        List<Integer> priceList = new ArrayList<>();
        for(int i = 0;  i < itemsList.size(); i++){
            String price =  BrowserUtils.getPrice(itemsList.get(i)).getText().substring(1);
            priceList.add(Integer.parseInt(price));
        }
        return priceList;
    }

    public boolean isAddedToCartButtonDisplayed(String itemName){
       return BrowserUtils.getAddToCArtButton(getItem(itemName)).getText().equals("Added to Cart");
    }

    public String getTabNameHeader(){
        return tabNameHeader.getText();
    }

    public boolean isOrderReceivedMessageDisplayed(){
        return orderReceivedMessage.isDisplayed();
    }

    public boolean isOrderConfirmationBoxDisplayed(){
        return orderConfirmationBox.isDisplayed();
    }

    public String getItemPrice(String itemName){
        return BrowserUtils.getPrice(getItem(itemName)).getText();
    }

    public void clickOnTab(String tabName){
        for(int i = 0; i < tabsList.size(); i++){
            if(tabsList.get(i).findElement(By.cssSelector("span")).getText().equals(tabName)){
                tabsList.get(i).click();
                break;
            }
        }
    }
    public String messageAfterOrderProcessCompleted() {
        String contex = "";
        for (WebElement appearAfterPurchaseProcess : messageAppearAfterPurchaseProcess) {
            contex += (appearAfterPurchaseProcess.getText());
        }
        return contex;
    }

    public void closeTheTabPopUpAfterPurchase() {
        WebElement xButton = DriverManager.getDriver().findElement(By.cssSelector("button[aria-label='Close']"));
        xButton.click();
    }




}

