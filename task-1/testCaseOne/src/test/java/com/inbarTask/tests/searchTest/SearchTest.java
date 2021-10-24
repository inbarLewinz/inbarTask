package com.inbarTask.tests.searchTest;

import com.inbarTask.tests.ManagerTaskOneAutomation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends ManagerTaskOneAutomation {
    @Test
    public void SearchTest() {
        wait.until(ExpectedConditions.urlMatches("https://duckduckgo.com/"));
        searchPage.typeSearch("pyramid analytics");
        searchPage.clickSearchButton();
        wait.until(ExpectedConditions.visibilityOf(searchPage.firstResult));
        searchPage.checkFirstElementContainsLink();
    }

}
