package tests.priorityBasedTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserFlowTest_03 extends HooksPriority {

	@Test(priority = 1)
	public void loginTest() {
		homePage = new InarHomePage();
		loginPage = homePage.clickTargetMarketLink();
		targetMarketHomePage = loginPage.loginWithStandardUser();
		Assert.assertTrue(loginPage.isLoginSuccessful(), "User should be successfully logged in.");
	}

	@Test(priority = 2, dependsOnMethods = "loginTest")
	public void selectItemTest() {
		targetMarketHomePage.clickOnSkincareTab();
		targetMarketHomePage.clickOnAddButton("Oil Free Moisturizer 100ml");
		BrowserUtils.scrollUpWithPageUp();
		targetMarketHomePage.clickOnLaptopsTab();
		targetMarketHomePage.clickOnAddButton("Samsung Galaxy Book");
		BrowserUtils.scrollUpWithPageUp();
		targetMarketHomePage.clickOnGroceriesTab();
		targetMarketHomePage.clickOnAddButton("Orange Essence Food Flavou");
		List<List<String>> expectedItemsInformation = new ArrayList<>();
		expectedItemsInformation.add(new ArrayList<>(Arrays.asList("Oil Free Moisturizer 100ml", "$40", "1")));
		expectedItemsInformation.add(new ArrayList<>(Arrays.asList("Samsung Galaxy Book", "$1499", "2")));
		expectedItemsInformation.add(new ArrayList<>(Arrays.asList("Orange Essence Food Flavou", "$14", "1")));
		shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
		shoppingCartPage.clickPlusButtonForItem("Samsung Galaxy Book");
		List<List<String>> itemsInformationOnCart = shoppingCartPage.getItemsNamesAndValuesOnCart();
		Assert.assertEquals(itemsInformationOnCart, expectedItemsInformation,
				"The information for selected items should be same with the items information on shopping cart");
	}

	@Test(priority = 3, dependsOnMethods = "selectItemTest")
	public void logoutTest() {
		targetMarketHomePage = shoppingCartPage.clickOnCloseButton();
		loginPage = targetMarketHomePage.clickOnLogoutButton();
		Assert.assertTrue(loginPage.isLoginPageTextDisplayed(), "The user should be on login page");
	}

}
