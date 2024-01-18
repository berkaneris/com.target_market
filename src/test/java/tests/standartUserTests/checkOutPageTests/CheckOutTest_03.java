package tests.standartUserTests.checkOutPageTests;

import tests.Hooks;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;

public class CheckOutTest_03 extends Hooks {

	@DataProvider(name = "ValidUsersCredentials")
	public Object[][] provideLoginCredentials() {
		return new Object[][] { { "John", "King", "NewYork", "4123678945673214", "5334445556" },
				{ "Alice", "Apple", "Chicago", "5123668942673214", "2342167854" },
				{ "User1", "lastname1", "address1", "3455465351239876", "2312345431" } };
	}

	@Test(dataProvider = "ValidUsersCredentials")
	public void testCheckOutWithDifferentUsers(String firstName, String lastName, String address, String cardNumber,
			String phoneNumber) {
		homePage = new InarHomePage();
		loginPage = homePage.clickTargetMarketLink();
		targetMarketHomePage = loginPage.loginWithStandardUser();
		targetMarketHomePage.clickOnFurnitureTab();
		targetMarketHomePage.clickOnAddButton("Mornadi Velvet Bed");
		targetMarketHomePage.clickOnAddButton("3 Tier Corner Shelves");
		shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
		checkOutPage = shoppingCartPage.clickOnCheckoutButton();
		checkOutPage.enterAllInformation(firstName, lastName, address, cardNumber, phoneNumber);
		checkOutPage.clickOnPlaceOrder();
		softAssert.assertTrue(targetMarketHomePage.isOrderReceivedMessageDisplayed());
		softAssert.assertAll();
	}

}
