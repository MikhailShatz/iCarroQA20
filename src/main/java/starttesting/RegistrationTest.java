package starttesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//import utils.RandomUtils;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    WebDriver driver;
  //  RandomUtils randomUtils = new RandomUtils();

    @BeforeClass
    public void preconditions(){
        driver = new ChromeDriver();
        driver.navigate().to("https://ilcarro.web.app/search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }


    public void registrationPositive(){
        String email = "Boozer123@gmail.com";
                //randomUtils.generateEmail(7);
        System.out.println(email);

        driver.findElement(By.xpath("//a[contains(@href, '/registration')]")).click();

        WebElement inputName = driver.findElement(By.xpath("//input[@id='name']"));
        inputName.click();
        inputName.clear();
        inputName.sendKeys("abc");

        WebElement inputName2 = driver.findElement(By.xpath("//input[@id='lastName']"));
        inputName2.click();
        inputName2.clear();
        inputName2.sendKeys("abcd");

        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='email']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys(email);

        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys("Beer12345!");

        //checkbox
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#terms-of-use').click();");
       // driver.findElement(By.xpath("//label[@for='terms-of-use']")).click();

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement textMessagePopUpH2 = driver.findElement(By.xpath("//div[@class='dialog-container']//h1[@class='title']"));
        String textMessageH1 = textMessagePopUpH2.getText().trim().toUpperCase();
        String expectedResult = "Registered".toUpperCase();
        System.out.println(textMessageH1); // if assert fails, need to check with sout
        Assert.assertEquals(textMessageH1, expectedResult);

    }

    @AfterClass
    public void postConditions(){
        driver.quit();
    }
}
