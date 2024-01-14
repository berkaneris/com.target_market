package Tests.AllTabTests;

import Tests.Hooks.Hooks;
import org.testng.annotations.Test;
import pages.InarHomePage.InarHomePage;
import pages.TargetMarketHomePage.TargetMarketHomePage;
import pages.TargetMarketLoginPage.LoginPage;


import static org.testng.AssertJUnit.assertEquals;


public class AllTabTest_01 extends Hooks {

    @Test
    public void testAllTabsLink(){
        InarHomePage homePage = new InarHomePage();
        LoginPage loginPage = homePage.clickTargetMarketLink();
        TargetMarketHomePage targetMarketHomePage = loginPage.loginWithStandardUser();
        targetMarketHomePage.clickOnAllTab();
        targetMarketHomePage.clickOnAddButton("iPhone X");
        assertEquals("1" , targetMarketHomePage.getAddedItemQuantity());
    }

}
