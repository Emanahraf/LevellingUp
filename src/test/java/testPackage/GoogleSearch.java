package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoogleSearch {
    WebDriver driver ;
    By secreachTextbox = By.id("APjFqb");
    By searchreult=By.xpath("//h3[@class=\"LC20lb MBeuO DKV0Md\"]");
    By pagetitle=By.xpath("//h1");

    @BeforeMethod
    public void Setup(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }
    @Test
    public void Searchgoogle() throws InterruptedException {

        driver.get("https://www.google.com/");
        driver.findElement(secreachTextbox).sendKeys("WebDriver", Keys.ENTER);
        String result =driver.findElement(searchreult).getText();
        Assert.assertTrue(result.contains("WebDriver"),"passed");

    }

    @Test
    public void Searchgoogle2()  {
        driver.get("https://www.selenium.dev/documentation/webdriver/");
        String result2 =driver.findElement(pagetitle).getText();
        Assert.assertTrue(result2.contains("WebDriver"),"passed");

    }
    @AfterMethod
    public void after(){
        driver.quit();
    }
}
