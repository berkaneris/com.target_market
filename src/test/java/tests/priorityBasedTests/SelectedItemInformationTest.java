package tests.priorityBasedTests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectedItemInformationTest extends Hooks2{

    List<List<String>> expectedItemsInformation = new ArrayList<>();

    @Test(priority = 1)
    public void testLoginProcess(){
        homePage = new InarHomePage();
        loginPage = homePage.clickTargetMarketLink();
        targetMarketHomePage = loginPage.loginWithStandardUser();
        Assert.assertTrue(loginPage.isLoginSuccessful(), "User should be successfully logged in.");
    }

    @Test(priority = 2)
    public void testItemSelectionOnTargetMarketHomePage(){
        targetMarketHomePage.clickOnGroceriesTab();
        targetMarketHomePage.clickOnAddButton("Elbow Macaroni - 400 gm");
        softAssert.assertTrue(targetMarketHomePage.isAddedToCartButtonDisplayed("Elbow Macaroni - 400 gm"));
        expectedItemsInformation.add(new ArrayList<>(Arrays.asList("Elbow Macaroni - 400 gm" , "$14" , "1")));
        BrowserUtils.scrollUpWithPageUp();
        targetMarketHomePage.clickOnLaptopsTab();
        targetMarketHomePage.clickOnAddButton("Infinix INBOOK");
        softAssert.assertTrue(targetMarketHomePage.isAddedToCartButtonDisplayed("Infinix INBOOK"));
        expectedItemsInformation.add(new ArrayList<>(Arrays.asList("Infinix INBOOK" , "$1099" , "1")));
        BrowserUtils.scrollUpWithPageUp();
        BrowserUtils.scrollTabsLine(-645);
        targetMarketHomePage.clickOnTab("Womens Dresses");
        targetMarketHomePage.clickOnAddButton("frock gold printed");
        softAssert.assertTrue(targetMarketHomePage.isAddedToCartButtonDisplayed("frock gold printed"));
        expectedItemsInformation.add(new ArrayList<>(Arrays.asList("frock gold printed" , "$600" , "1")));
        shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void testItemsInformationOnShoppingCart(){
        List<List<String>> itemsInformationOnShoppingCart = shoppingCartPage.getItemsNamesAndValuesOnCart();
        softAssert.assertEquals(itemsInformationOnShoppingCart , expectedItemsInformation , "The items information should be same with the selected items");
        checkOutPage = shoppingCartPage.clickOnCheckoutButton();
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void testItemsInformationOnCheckoutPage(){
        List<List<String>> itemsInformationOnCheckoutPage = checkOutPage.getItemsInformationList();
        softAssert.assertEquals(itemsInformationOnCheckoutPage , expectedItemsInformation, "The items information should be same with the selected items");
        softAssert.assertAll();
    }
}
