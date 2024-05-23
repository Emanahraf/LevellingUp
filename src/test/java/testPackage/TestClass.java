package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestClass {
    WebDriver driver ;
    By secreachTextbox=By.id("APjFqb");
   // By searchbtn=By.name("btnK");

    By sgt=By.xpath("(//div[@class=\"wM6W7d\"])[1]");
@Test
public void test() throws InterruptedException {
     driver = new ChromeDriver();
     driver.get("https://www.google.com/");
    driver.findElement(secreachTextbox).sendKeys("test automation");
    driver.findElement(sgt).click();
    Thread.sleep(1000);




    driver.quit();
}
}
