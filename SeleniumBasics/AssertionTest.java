package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class AssertionTest {
    WebDriver driver;

    @Test
    public void test() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        WebElement accept = driver.findElement(By.xpath("//*[@id='L2AGLb']/div"));
        accept.click();
        WebElement search = driver.findElement(By.xpath("//input[@title='Szukaj']"));
        search.click();
        search.sendKeys("Selenium dev");
        search.sendKeys(Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("//a[contains(@href,'selenium.dev')]//h3"));
        Assert.assertTrue(result.isDisplayed());
    }
    @AfterTest
        public void AfterTest() {

        driver.quit();


    }
}




