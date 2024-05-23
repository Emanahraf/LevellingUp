package testPackage;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static dev.failsafe.internal.util.Assert.*;

public class GoogleTest {
    WebDriver driver;
    By secreachTextbox = By.id("APjFqb");
By searchreult=By.xpath("//h3[@class=\"LC20lb MBeuO DKV0Md\"]");
By pagetitle=By.xpath("//h1");
    @Test
    public void Searchgoogle() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(secreachTextbox).sendKeys("WebDriver", Keys.ENTER);
        String result =driver.findElement(searchreult).getText();
        Assert.assertTrue(result.contains("WebDriver"),"passed");
        driver.findElement(searchreult).click();
        String result2 =driver.findElement(pagetitle).getText();
        Assert.assertTrue(result2.contains("WebDriver"),"passed");
        driver.quit();
    }
}
