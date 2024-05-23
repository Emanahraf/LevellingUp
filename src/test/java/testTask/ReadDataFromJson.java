package testTask;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class ReadDataFromJson {
    WebDriver driver ;
    By secreachTextbox = By.id("APjFqb");
    By searchreult=By.xpath("//h3[@class=\"LC20lb MBeuO DKV0Md\"]");
    By pagetitle=By.xpath("//h1");
    String SearchText;
    FileReader f ;

    JSONParser j = new JSONParser();


    @BeforeMethod
    public void Setup() throws IOException, ParseException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        f=new FileReader("D:\\Text Data.json");
        // parse json content
        Object o = j.parse(f);

        // convert parsing object to JSON object
        JSONObject detail = (JSONObject)o;
        SearchText = (String)detail.get("search");
        System.out.println(SearchText);
    }
    @Test
    public void Searchgoogle() throws InterruptedException {

        driver.get("https://www.google.com/");

        driver.findElement(secreachTextbox).sendKeys(SearchText, Keys.ENTER);
        String result =driver.findElement(searchreult).getText();
        Assert.assertTrue(result.contains(SearchText),"passed");

    }

    @Test
    public void Searchgoogle2()  {
        driver.get("https://www.selenium.dev/documentation/webdriver/");
        String result2 =driver.findElement(pagetitle).getText();
        Assert.assertTrue(result2.contains("SearchText"),"passed");

    }
    @AfterMethod
    public void after(){
        driver.quit();
    }
}
