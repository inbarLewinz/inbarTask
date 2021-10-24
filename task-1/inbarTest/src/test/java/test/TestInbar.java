package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestInbar {
    public WebDriver driver;
    private ChromeOptions chromeOptions;
    @BeforeMethod
    public void prepareTests(){
        WebDriverManager.chromedriver().setup();
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://react-window-fixed.glitch.me/");
    }

    @AfterMethod
    public void terminateDriver(){
        driver.quit();
    }
    @Test
    public void testCase2() {
        scrollToItem(12);
    }

    private void scrollToItem(int number) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 1; i <= number; i++) {
            js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//p[@class='number' and text()='"+ i + "']")));
        }
    }
}
