package Tests.TargetMarketHomePageTests.ShoppingCartTest.AllTabTests;

import Tests.BaseTests.Hooks;
import org.testng.annotations.Test;
import pages.InarHomePage.InarHomePage;

import static org.testng.AssertJUnit.assertEquals;


public class AllTabTest_01 extends Hooks {

    @Test
    public void testAllTabsLink() {
        homePage = new InarHomePage();
        loginPage = homePage.clickTargetMarketLink();
        targetMarketHomePage = loginPage.loginWithStandardUser();
        targetMarketHomePage.clickOnAllTab();
        targetMarketHomePage.clickOnAddButton("iPhone X");
        assertEquals("1", targetMarketHomePage.getAddedItemQuantity());
    }

}
