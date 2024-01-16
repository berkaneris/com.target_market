package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.nio.file.Files;

public class BrowserUtils {

    private static Actions actions = new Actions(DriverManager.getDriver());
    public static void scrollDownWithPageDown(){
        actions.keyDown(Keys.PAGE_DOWN).release().build().perform();
        wait(1);
    }

    public static void scrollUpWithPageUp(){
        actions.keyDown(Keys.PAGE_UP).release().build().perform();
        wait(1);
    }

    public static void wait(double timeout){
        try{
            Thread.sleep((long)timeout * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void wait(int timeout){
        try{
            Thread.sleep(timeout * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static String getTitle(){
        return DriverManager.getDriver().getTitle();
    }

    public static void takeScreenShot(String fileName){
        try {
            // Convert WebDriver object to TakesScreenshot
            TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();

            // Capture screenshot as a File
            File screenshot = ts.getScreenshotAs(OutputType.FILE);

            // Specify the destination of the screenshot
            File destination = new File(fileName);

            // Copy the screenshot file to the specified destination
            Files.copy(screenshot.toPath(), destination.toPath());

            System.out.println("Screenshot taken: " + destination.getAbsolutePath());
        } catch (Exception e) {
            System.err.println("Exception while taking screenshot: " + e.getMessage());
        }
    }

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
