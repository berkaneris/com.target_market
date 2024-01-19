package pages.targetMarket;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import utils.BrowserUtils;
import utils.DriverManager;

import java.util.*;

public class TargetMarketHomePage extends BasePage {

    @FindBy(css = "h5.display-5")
    private WebElement welcomeText;
    @FindBy(css = "div a[role='tab']")
    private List<WebElement> tabsList;
    @FindBy(xpath = "//button[text()='Logout']")
    private WebElement logoutButton;
    @FindBy(css = "button.mx-3:nth-child(2)")
    private WebElement shoppingButton;
    @FindBy(id = "sortType")
    private WebElement sortDropDown;
    @FindBy(css = "div.card-body")
    private List<WebElement> itemsList;
    @FindBy(css = ".display-1")
    private WebElement tabNameHeader;
    @FindBy(xpath = "//p[contains(text() , 'received')]")
    private WebElement orderReceivedMessage;
    @FindBy(css = "#target-market .text-center")
    private WebElement orderConfirmationBox;
    @FindBy(css = ".text-center.bg-light.p-5.rounded-3.position-relative")
    private List<WebElement> messageAppearAfterPurchaseProcess;

    @FindBy(id = "splide02-list")
    private List<WebElement> getTabsList;

    @FindBy(css = "div[role='alert']")
    private WebElement productAddedToCartMessage;

    public void clickOnAllTab() {
        clickOnTab("All");
    }

    public void clickOnSmartPhonesTab() {
        clickOnTab("Smartphones");
    }

    public void clickOnLaptopsTab() {
        clickOnTab("Laptops");
    }

    public void clickOnSkincareTab() {
        clickOnTab("Skincare");
    }

    public void clickOnGroceriesTab() {
        clickOnTab("Groceries");
    }

    public void clickOnHomeDecorationTab() {
        clickOnTab("Home Decoration");
    }

    public void clickOnFurnitureTab() {
        clickOnTab("Furniture");
    }

    public void clickOnTopsTab() {
        clickOnTab("Tops");
    }

    public void clickOnWomenDressesTab() {
        clickOnTab("Womens Dresses");
    }

    public void clickOnWomenShoesTab() {
        clickOnTab("Womens Shoes");
    }

    public LoginPage clickOnLogoutButton() {
        logoutButton.click();
        return new LoginPage();
    }

    public String getWelcomeText() {
        wait.until(ExpectedConditions.visibilityOf(welcomeText));
        return welcomeText.getText();
    }

    public boolean isWelcomeMessageDisplayed() {
        try {
            return welcomeText.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    private WebElement getItem(String itemName) {
        for (int i = 0; i < itemsList.size(); i++) {
            if (BrowserUtils.getName(itemsList.get(i)).getText().equals(itemName)) {
                return itemsList.get(i);
            }
        }
        return null;
    }

    public void clickOnAddButton(String itemName) {
        BrowserUtils.getAddToCArtButton(getItem(itemName)).click();
    }

    public String getAddedItemQuantity() {
        return shoppingButton.findElement(By.cssSelector("span")).getText();
    }

    public ShoppingCartPage clickOnShoppingButton() {
        shoppingButton.click();
        return new ShoppingCartPage();
    }

    public List<String> getItemNameList() {
        List<String> itemNameList = new ArrayList<>();
        for (int i = 0; i < itemsList.size(); i++) {
            itemNameList.add(BrowserUtils.getName(itemsList.get(i)).getText().toLowerCase());
        }
        return itemNameList;
    }

    public List<String> getItemNameList2() {
        List<String> itemNameList = new ArrayList<>();
        for (int i = 0; i < itemsList.size(); i++) {
            itemNameList.add(BrowserUtils.getName(itemsList.get(i)).getText());
        }
        return itemNameList;
    }

    public void sortBy(String sortSelectionText) {
        Select select = new Select(sortDropDown);
        select.selectByVisibleText(sortSelectionText);
    }

    public List<Integer> getPriceList() {
        List<Integer> priceList = new ArrayList<>();
        for (int i = 0; i < itemsList.size(); i++) {
            String price = BrowserUtils.getPrice(itemsList.get(i)).getText().substring(1);
            priceList.add(Integer.parseInt(price));
        }
        return priceList;
    }

    public boolean isAddedToCartButtonDisplayed(String itemName) {
        return BrowserUtils.getAddToCArtButton(getItem(itemName)).getText().equals("Added to Cart");
    }

    public String getTabNameHeader() {
        return tabNameHeader.getText();
    }

    public boolean isOrderReceivedMessageDisplayed() {
        return orderReceivedMessage.isDisplayed();
    }

    public boolean isOrderConfirmationBoxDisplayed() {
        return orderConfirmationBox.isDisplayed();
    }

    public String getItemPrice(String itemName) {
        return BrowserUtils.getPrice(getItem(itemName)).getText();
    }

    public double getItemPriceValue(String itemName) {
        return Double.parseDouble(getItemPrice(itemName).substring(1));
    }

    public void clickOnTab(String tabName) {
        if (tabName.equals("Tops") || tabName.equals("Womens Dresses") || tabName.equals("Womens Shoes")) {
            wait.until(ExpectedConditions.visibilityOf(welcomeText));
            BrowserUtils.scrollTabsLine(-645);
        } else {
            wait.until(ExpectedConditions.visibilityOf(welcomeText));
            BrowserUtils.scrollTabsLine(0);
        }
        for (int i = 0; i < tabsList.size(); i++) {
            if (tabsList.get(i).findElement(By.cssSelector("span")).getText().equals(tabName)) {
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

    public List<String> getTabsName() {
        List<String> tabsName = new ArrayList<>();
        for (int i = 0; i < tabsList.size(); i++) {
            tabsName.add(tabsList.get(i).findElement(By.cssSelector("span")).getText());
        }


        return tabsName;
    }

    public boolean isProductAddedToCartMessageDisplayed() {
        return productAddedToCartMessage.isDisplayed();
    }

    public void scrollToTheItem(String nameOfProduct) {
        BrowserUtils.scrollDownWithJavaScript(0,-2000);
        int i;
        for (i = 0; i < itemsList.size(); i++) {
            if (BrowserUtils.getName(itemsList.get(i)).getText().equals(nameOfProduct)) {
                BrowserUtils.scrollDownWithPageDown();
                break;
            }
        }
        System.out.println(" i  : "+i);
        for (int m = 0; m < (i / 4)+1 ; m++) {
            if (m < 5) {
               BrowserUtils.scrollDownWithJavaScript(0,600);
            } else {
                BrowserUtils.scrollDownWithJavaScript(0,650);

            }
        }


    }
}





