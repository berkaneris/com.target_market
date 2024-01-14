package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchaseElementSelector {
    private WebElement name;
    private WebElement price;
    private WebElement addToCArtButton;

    public PurchaseElementSelector(WebElement box) {
        name = box.findElement(By.cssSelector("h5.card-title"));
        price = box.findElement(By.cssSelector("p.card-price i:nth-child(1)"));
        addToCArtButton = box.findElement(By.cssSelector("button.btn.btn-danger"));
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getPrice() {
        return price;
    }

    public WebElement getAddToCArtButton() {
        return addToCArtButton;
    }
}
