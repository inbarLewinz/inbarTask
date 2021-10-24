package com.inbarTask.tests;

import com.inbarTask.pages.searchPage.SearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ManagerTaskOneAutomation {
    public String systemUnderTest;
    public String lastName ;
    public String password;
    public String selectDayByValue;
    public String selectMonthByIndex;
    public String selectYearByVisibleText;
    public String womensWear;
    public String  mensWear;


    private String pathToGlobalVariables  = "src\\test\\resources\\globalvariables.properties";
    public WebDriver driver;
    private ChromeOptions chromeOptions;
    public SearchPage searchPage;
    public SoftAssert softAssert;
    public WebDriverWait wait ;


    @BeforeTest
    public void loadParameters() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(pathToGlobalVariables );
        properties.load(fileInputStream);
        systemUnderTest = properties.getProperty("url");
    }


    @BeforeMethod
    public void prepareTests(){
            WebDriverManager.chromedriver().setup();
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get(systemUnderTest);
            searchPage = new SearchPage(driver);
            softAssert = new SoftAssert();
            wait = new WebDriverWait(driver, 5);

    }

    @AfterMethod
    public void terminateDriver(){
        //driver.quit();
    }
}
