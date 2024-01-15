package Tests.TargetMarketHomePageTests.ShoppingCartTest.AllTabTests;

import Tests.BaseTests.Hooks;
import org.testng.annotations.Test;
import pages.InarHomePage.InarHomePage;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;


public class AllTabTest_02 extends Hooks {

    @Test
    public void testAllTabsSortByAToZ() {

        homePage = new InarHomePage();
        loginPage = homePage.clickTargetMarketLink();
        targetMarketHomePage = loginPage.loginWithStandardUser();
        targetMarketHomePage.clickOnSmartPhonesTab();
        List<String> nameOfItems1 = targetMarketHomePage.getItemNameList();
        targetMarketHomePage.sortBy("A-Z");
        List<String> nameOfItems2 = targetMarketHomePage.getItemNameList();
        assertNotEquals(nameOfItems1, nameOfItems2);
        Collections.sort(nameOfItems1);
        assertEquals(nameOfItems1, nameOfItems2);
    }

}
