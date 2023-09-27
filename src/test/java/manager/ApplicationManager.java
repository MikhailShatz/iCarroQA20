package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver driver;
    UserHelper userHelper;

    @BeforeClass
    public void init(){
        driver = new ChromeDriver();
        driver.navigate().to("https://ilcarro.web.app/search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        userHelper = new UserHelper(driver);
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

