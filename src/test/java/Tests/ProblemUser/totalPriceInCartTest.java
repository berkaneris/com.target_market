package Tests.ProblemUser;

import Tests.BaseTests.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.InarHomePage.InarHomePage;
import pages.TargetMarketHomePage.TargetMarketHomePage;
import pages.TargetMarketLoginPage.LoginPage;
import utils.BrowserUtils;

import java.util.List;

public class totalPriceInCartTest extends Hooks {

    @Test
    public void cartGetEmptyAfterShoppingTest() {
        SoftAssert softAssert = new SoftAssert();
        InarHomePage homePage = new InarHomePage();
        LoginPage loginPage = homePage.clickTargetMarketLink();
        TargetMarketHomePage targetMarketHomePage = loginPage.loginWithProblemUser();
        BrowserUtils.wait(4);
        BrowserUtils.scrollDownWithPageDown();
        targetMarketHomePage.clickOnGroceriesTab();
        BrowserUtils.scrollDownWithPageDown();
        //    BrowserUtils.scrollDownWithPageDown();
        List<String> namesOfProducts = targetMarketHomePage.getItemNameList();
        int actualTotalPrice = 0;
        for (int i = 0; i < namesOfProducts.size(); i++) {
            if (i != 0 && i % 4 == 0) {
                BrowserUtils.scrollDownWithPageDown();
                BrowserUtils.wait(1);
            }
            BrowserUtils.wait(3);
            targetMarketHomePage.clickOnAddButton(namesOfProducts.get(i));
            actualTotalPrice += (int)Double.parseDouble(targetMarketHomePage.getItemPrice(namesOfProducts.get(i)).substring(1));
        }
        shoppingCartPage = targetMarketHomePage.clickOnShoppingButton();
        System.out.println(shoppingCartPage.getTotalPrice());
        int expectedTotalPrice= Integer.parseInt(shoppingCartPage.getTotalPrice().substring(1));
        Assert.assertEquals(expectedTotalPrice, actualTotalPrice, "Total Price of products should be $" + expectedTotalPrice);


    }
}
