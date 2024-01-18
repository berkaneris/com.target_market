package tests.standartUserTests.checkOutPageTests;

import tests.Hooks;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.targetMarket.InarHomePage;

public class CheckOutTest_04 extends Hooks {

	@DataProvider(name = "MissingUsersCredentials")
	public Object[][] provideLoginCredentials() {
		return new Object[][] {
				{ "Groceries", "Elbow Macaroni - 400 gm", "Gulab Powder 50 Gram", "", "King", "NewYork",
						"4123678945673214", "5334445556", "First name is required", 1 },
				{ "Womens Dresses", "Ladies Multicolored Dress", "Malai Maxi Dress", "Alice", "", "Chicago",
						"5123668942673214", "2342167854", "Last name is required", 2 },
				{ "Womens Shoes", "Sneaker shoes", "Women Strip Heel", "User1", "lastname1", "", "3455465351239876",
						"2312345431", "Address is required", 3 },
				{ "Smartphones", "iPhone 9", "Huawei P30", "User2", "lastname2", "address1", "", "2337849431",
						"Card number is required", 4 },
				{ "Skincare", "Skin Beauty Serum.", "Freckle Treatment Cream- 15gm", "User2", "lastname2", "address1",
						"1235431239878855", "", "Phone number is required", 5 } };
	}

	@Test(dataProvider = "MissingUsersCredentials")
	public void testCheckOutWithDifferentUsers(String tabName, String itemName1, String itemName2, String firstName,
			String lastName, String address, String cardNumber, String phoneNumber, String alertMessage, int index) {
		homePage = new InarHomePage();
		loginPage = homePage.clickTargetMarketLink();
		targetMarketHomePage = loginPage.loginWithStandardUser();
		targetMarketHomePage.clickOnTab(tabName);
		targetMarketHomePage.clickOnAddButton(itemName1);
		targetMarketHomePage.clickOnAddButton(itemName2);
		shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
		checkOutPage = shoppingCartPage.clickOnCheckoutButton();
		checkOutPage.enterAllInformation(firstName, lastName, address, cardNumber, phoneNumber);
		checkOutPage.clickOnPlaceOrder();
		softAssert.assertEquals(checkOutPage.getAlertMessageText(index), alertMessage);
		softAssert.assertAll();
	}

}
