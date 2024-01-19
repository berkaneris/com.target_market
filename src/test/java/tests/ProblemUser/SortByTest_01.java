package tests.ProblemUser;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.targetMarket.InarHomePage;
import tests.Hooks;
import utils.BrowserUtils;

import java.util.Collections;
import java.util.List;

public class SortByTest_01 extends Hooks {
    @Test
    public void sortByCheck() {
        homePage = new InarHomePage();
        loginPage = homePage.clickTargetMarketLink();
        targetMarketHomePage = loginPage.loginWithProblemUser();
        BrowserUtils.wait(4);
        BrowserUtils.scrollDownWithPageDown();
        targetMarketHomePage.clickOnSmartPhonesTab();
        targetMarketHomePage.sortBy("A-Z");
        List<String> namesOfProducts = targetMarketHomePage.getItemNameList();
        List<String> namesOfProducts2 = targetMarketHomePage.getItemNameList();
        Collections.sort(namesOfProducts);
        Assert.assertEquals(namesOfProducts, namesOfProducts2);


    }

}
