package com.inbarTask.pages.searchPage;

import com.inbarTask.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SearchPage extends PageObject {
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = Constants.SEARCH_WEB_INPUT_FIELD_CSS)
    public WebElement searchField;

    @FindBy(css = Constants.SEARCH_BUTTON_CSS)
    public WebElement searchButton;

    @FindBy(css = Constants.FIRST_RESULT)
    public WebElement firstResult;


    public void typeSearch(String searchValue){
        searchField.sendKeys(searchValue);
    }


    public void clickSearchButton() {
        searchButton.click();
    }

    public void checkFirstElementContainsLink() {
        Assert.assertTrue(firstResult.getAttribute("href").contains("https://www.pyramidanalytics.com"));
    }






}
