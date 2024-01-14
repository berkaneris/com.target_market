package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class PurchaseElementSelector {

    public static WebElement getName(WebElement box) {
        return box.findElement(By.cssSelector("h5.card-title"));
    }

    public static WebElement getPrice(WebElement box) {
        return box.findElement(By.cssSelector("p.card-price i:nth-child(1)"));
    }

    public static WebElement getAddToCArtButton(WebElement box) {
        return box.findElement(By.cssSelector("button.btn.btn-danger"));
    }


}
