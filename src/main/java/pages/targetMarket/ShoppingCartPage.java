package pages.targetMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.*;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = "//button[text()='Go to Checkout']")
    private WebElement checkoutButton;
    @FindBy(xpath = "//button[text()='Close']")
    private WebElement closeButton;
    @FindBy(css = "button[aria-label='Close']")
    private WebElement crossButton;
    @FindBy(css = "div[class='mb-3 list-group'] > div")
    private List<WebElement> ItemsOnCart;
    @FindBy(css = ".text-start p")
    private WebElement totalPrice;
    @FindBy(xpath = "//p[contains(text(), 'empty')]")
    private WebElement emptyText;

    private WebElement getItemOnCart(String itemName) {
        for (int i = 0; i < ItemsOnCart.size(); i++) {
            if (ItemsOnCart.get(i).findElement(By.cssSelector("h3")).getText().equals(itemName)) {
                return ItemsOnCart.get(i);
            }
        }
        return null;
    }

    public boolean isItemOnCart(String itemName) {
        return !Objects.isNull(getItemOnCart(itemName));
    }

    public void clickPlusButtonForItem(String itemName) {
        if (isItemOnCart(itemName)) {
            getItemOnCart(itemName).findElement(By.cssSelector("button:nth-child(3)")).click();
        }
    }

    public void clickMinusButtonForItem(String itemName) {
        if (isItemOnCart(itemName)) {
            getItemOnCart(itemName).findElement(By.cssSelector("button:nth-child(1)")).click();
        }
    }

    public double getTotalPrice() {
        String price = totalPrice.getText().substring(14);
        return Double.parseDouble(price);

    }

    public CheckOutPage clickOnCheckoutButton() {
        try {
            checkoutButton.click();
            return new CheckOutPage();
        } catch (NoSuchElementException ex) {
            return null;
        }
    }

    public TargetMarketHomePage clickOnCloseButton() {
        closeButton.click();
        return new TargetMarketHomePage();
    }

    public boolean isEmptyTextDisplayed() {
        return emptyText.isDisplayed();
    }

    public String getItemPrice(String itemName) {
        String price = getItemOnCart(itemName)
                .findElement(By.cssSelector("div > div > p[class='text-muted mb-0 fs-4']:nth-child(2)"))
                .getText();
        return price.substring(0, price.length() - 11);
    }

    public List<String> getItemNamesOnCart() {
        List<String> itemNames = new ArrayList<>();
        for (int i = 0; i < ItemsOnCart.size(); i++) {
            itemNames.add(ItemsOnCart.get(i).findElement(By.cssSelector("h3")).getText());
        }
        return itemNames;
    }

    public List<List<String>> getItemsNamesAndValuesOnCart() {
        List<List<String>> itemNameAndValues = new ArrayList<>();
        for (int i = 0; i < ItemsOnCart.size(); i++) {
            List<String> itemValues = new ArrayList<>();
            String itemName = ItemsOnCart.get(i).findElement(By.cssSelector("h3")).getText();
            itemValues.add(itemName);
            itemValues.add(getItemPrice(itemName));
            itemValues.add(getItemQuantityOnCart(itemName));
            itemNameAndValues.add(itemValues);
        }
        return itemNameAndValues;
    }

    public String getItemTotalPriceOnCart(String itemName) {
        String totalPrice = getItemOnCart(itemName)
                .findElement(By.cssSelector("div > div > p[class='text-muted mb-0 fs-4']:nth-child(3)"))
                .getText();
        return totalPrice.substring(7);
    }

    public String getItemQuantityOnCart(String itemName) {
        String itemQuantity = getItemOnCart(itemName).findElement(By.cssSelector("div > div > div > span")).getText();
        return itemQuantity;
    }

    public int getItemQuantityValueOnCart(String itemName) {
        return Integer.parseInt(getItemQuantityOnCart(itemName));
    }

    public int getNumberOfItemInTheCart() {
        int count = 0;
        for (int i = 0; i < ItemsOnCart.size(); i++) {
            count++;
        }
        return count;
    }
}
