package testTask;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class FileUpload {
    WebDriver driver ;
    By FileUpload = By.id("file-upload");
    By Submit = By.id("file-submit");
    By FileUpladetext=By.tagName("h3");
    File uploadFile = new File("D:\\Fuel in Liters Bug.png");
    @BeforeMethod
    public void Setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }
    @Test
    public void UploadImage() throws InterruptedException {

        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement fileInput = driver.findElement(FileUpload);
        fileInput.sendKeys(uploadFile.getAbsolutePath());
        driver.findElement(Submit).click();
        Assert.assertEquals(driver.findElement(FileUpladetext).getText(),"File Uploaded!");

    }


    @AfterMethod
    public void after(){
        driver.quit();
    }
}
