package tests.ProblemUser;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.targetMarket.InarHomePage;
import tests.Hooks;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.List;

public class UserFlowTest_02 extends Hooks {

	@Test
	public void randomParameterTest() {
		SoftAssert softAssert = new SoftAssert();
		int expectedNumberOfProductsInCart = 0;
		List<String> selectedItems = new ArrayList<>();

		homePage = new InarHomePage();
		loginPage = homePage.clickTargetMarketLink();
		targetMarketHomePage = loginPage.loginWithStandardUser();
		BrowserUtils.wait(4);
		BrowserUtils.scrollDownWithPageDown();

		// chose 3 products
		for (int i = 0; i < 3; i++) {
			// choose the page randomly
			List<String> tabsNameList = targetMarketHomePage.getTabsName();
			int getTheTabRandomly = Math.abs((int) (Math.random() * tabsNameList.size()) - 3);

			targetMarketHomePage.clickOnTab(tabsNameList.get(getTheTabRandomly));

			// choose the item randomly

			List<String> namesOfItemInTheList = targetMarketHomePage.getItemNameList2();
			int getTheItemRandomly = (int) (Math.random() * namesOfItemInTheList.size());
			String chosenItem = namesOfItemInTheList.get(getTheItemRandomly);
			targetMarketHomePage.scrollToTheItem(chosenItem);
			//

			// never chose an added element
			if (!selectedItems.contains(chosenItem)) {
				selectedItems.add(chosenItem);
				expectedNumberOfProductsInCart++;

				// click to add button
				targetMarketHomePage.clickOnAddButton(chosenItem);

				// verify that added the cart message displayed
				softAssert.assertTrue(targetMarketHomePage.isProductAddedToCartMessageDisplayed());
			}

			BrowserUtils.scrollToTheStartOfPage();
			BrowserUtils.scrollDownWithPageDown();
		}
		shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
		// verify that number of product is true
		int actualNumberOfProductsInCart = shoppingCartPage.getNumberOfItemInTheCart();
		softAssert.assertEquals(actualNumberOfProductsInCart, expectedNumberOfProductsInCart);

		// verify that names in cart is true;
		List<String> productNameInTheCart = shoppingCartPage.getItemNamesOnCart();
		softAssert.assertTrue(productNameInTheCart.equals(selectedItems));

		// verify that only one item in cart about that product
		String quantityOfItemOnCart = shoppingCartPage
			.getItemQuantityOnCart(selectedItems.get((int) (Math.random() * selectedItems.size())));
		softAssert.assertEquals("1", quantityOfItemOnCart);

		// increase the quantity of a product
		String chosenProduct = selectedItems.get((int) (Math.random() * selectedItems.size()));
		shoppingCartPage.clickPlusButtonForItem(chosenProduct);
		shoppingCartPage.clickPlusButtonForItem(chosenProduct);
		shoppingCartPage.clickPlusButtonForItem(chosenProduct);
		quantityOfItemOnCart = shoppingCartPage.getItemQuantityOnCart(chosenProduct);
		softAssert.assertEquals("4", quantityOfItemOnCart);

		// decrease 1 times products
		shoppingCartPage.clickMinusButtonForItem(chosenProduct);
		quantityOfItemOnCart = shoppingCartPage.getItemQuantityOnCart(chosenProduct);
		softAssert.assertEquals("3", quantityOfItemOnCart);

		// go to check out
		BrowserUtils.wait(1);

		shoppingCartPage.clickOnCheckoutButton();
		BrowserUtils.wait(1);

		//
		shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
		checkOutPage = shoppingCartPage.clickOnCheckoutButton();
		checkOutPage.enterAllInformation("jimmy", "durmaz", "Iowa", "9874563217412589", "4563218520");
		BrowserUtils.wait(1);
		BrowserUtils.scrollDownWithPageDown();
		checkOutPage.clickOnPlaceOrder();

		// verify that verificaiton message diplayed
		boolean actual = targetMarketHomePage.isOrderConfirmationBoxDisplayed();
		softAssert.assertTrue(actual);

		targetMarketHomePage.closeTheTabPopUpAfterPurchase();

		// verify that you are in All page
		BrowserUtils.wait(1);
		String expectedTabName = "All";
		String actualTabName = targetMarketHomePage.getTabNameHeader();
		Assert.assertEquals(actualTabName, expectedTabName);

		softAssert.assertAll();

	}

}
