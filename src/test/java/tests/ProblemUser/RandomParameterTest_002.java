package tests.ProblemUser;

import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.targetMarket.InarHomePage;
import pages.targetMarket.LoginPage;
import pages.targetMarket.TargetMarketHomePage;
import tests.Hooks;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.List;

public class RandomParameterTest_002 extends Hooks {



    @Test
    public void randomParameterTest() {
        InarHomePage homePage = new InarHomePage();
        LoginPage loginPage = homePage.clickTargetMarketLink();
        TargetMarketHomePage targetMarketHomePage = loginPage.loginWithProblemUser();
        BrowserUtils.wait(4);
        BrowserUtils.wait(4);
        BrowserUtils.scrollDownWithPageDown();

        String chosenItem;
        SoftAssert softAssert = new SoftAssert();
        int expectedNumberOfProductsInCart = 0;
        List<String> selectedItems = new ArrayList<>();
        boolean isContinue ;

        do {
            isContinue =true;
            //choose the page randomly
            List<String> tabsNameList = targetMarketHomePage.getTabsName();
            int getTheTabRandomly = Math.abs((int) (Math.random() * tabsNameList.size()) - 3);

            try {
                targetMarketHomePage.clickOnTab(tabsNameList.get(getTheTabRandomly));
            } catch (ElementClickInterceptedException ex) {
                System.out.println(tabsNameList.get(getTheTabRandomly) + " should be clickable ");
                softAssert.assertTrue(isContinue, tabsNameList.get(getTheTabRandomly) + " should be clickable ");
                isContinue = false;

            }
        } while (!isContinue);
        //verify that clicked page similar to head tag



        // choose the item randomly

        do {
            List<String> namesOfItemInTheList = targetMarketHomePage.getItemNameList2();
            int getTheItemRandomly = (int) (Math.random() * namesOfItemInTheList.size());
            chosenItem = namesOfItemInTheList.get(getTheItemRandomly);
            targetMarketHomePage.scrollToTheItem(chosenItem);
            try {
                targetMarketHomePage.clickOnAddButton(chosenItem);
                BrowserUtils.wait(3);
                expectedNumberOfProductsInCart++;
                selectedItems.add(chosenItem);
            } catch (ElementClickInterceptedException ex) {
                System.out.println(chosenItem + " should be clickable ");
                softAssert.assertTrue(isContinue, chosenItem + " should be clickable ");
                isContinue = false;
            }
        } while (!isContinue);


        //click to add button


        //verify that added the cart message displayed
        softAssert.assertTrue(targetMarketHomePage.isProductAddedToCartMessageDisplayed());


        //verify that only there is  one item in cart about that product
        shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
        String quantityOfItemOnCart = shoppingCartPage.getItemQuantityOnCart(chosenItem);
        softAssert.assertEquals("1", quantityOfItemOnCart);

        //verify that number of product is true
        int actualNumberOfProductsInCart = shoppingCartPage.getNumberOfItemInTheCart();
        softAssert.assertEquals(actualNumberOfProductsInCart, expectedNumberOfProductsInCart);

        //verify that names in cart is true;
        List<String> productNameInTheCart = shoppingCartPage.getItemNamesOnCart();
        softAssert.assertTrue(productNameInTheCart.equals(selectedItems));


        //increase the quantity of a product

        shoppingCartPage.clickPlusButtonForItem(chosenItem);
        shoppingCartPage.clickPlusButtonForItem(chosenItem);
        shoppingCartPage.clickPlusButtonForItem(chosenItem);
        quantityOfItemOnCart = shoppingCartPage.getItemQuantityOnCart(chosenItem);
        softAssert.assertEquals("4", quantityOfItemOnCart);


        //decrease 1 times products
        shoppingCartPage.clickMinusButtonForItem(chosenItem);
        quantityOfItemOnCart = shoppingCartPage.getItemQuantityOnCart(chosenItem);
        softAssert.assertEquals("3", quantityOfItemOnCart);

        //go to check out
        BrowserUtils.wait(1);

        shoppingCartPage.clickOnCheckoutButton();
        BrowserUtils.wait(1);

        //
        shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
        checkOutPage = shoppingCartPage.clickOnCheckoutButton();
        BrowserUtils.wait(1);
        checkOutPage.enterAllInformation("jimmy", "durmaz", "Iowa", "9874563217412589", "4563218520");
        BrowserUtils.wait(1);
        BrowserUtils.scrollDownWithPageDown();
        checkOutPage.clickOnPlaceOrder();

        //verify that verificaiton message diplayed
        boolean actual = targetMarketHomePage.isOrderConfirmationBoxDisplayed();
        softAssert.assertTrue(actual);

        targetMarketHomePage.closeTheTabPopUpAfterPurchase();

        //verify that you are in All page
        String expectedTabName = "All";
        String actualTabName = targetMarketHomePage.getTabNameHeader();
        Assert.assertEquals(actualTabName, expectedTabName);

        //verify logout process funtion
        targetMarketHomePage.clickOnLogoutButton();
        Assert.assertTrue(loginPage.isLoginPageTextDisplayed());

        softAssert.assertAll();
    }

}

