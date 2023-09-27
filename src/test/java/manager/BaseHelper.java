package manager;

import org.openqa.selenium.*;

import java.util.List;


public class BaseHelper {
    WebDriver driver;

    public BaseHelper(WebDriver driver){
        this.driver = driver;
    }

    private WebElement findElementBase(By locator){
        return driver.findElement(locator);
    }
    private List<WebElement> findElementsBase(By locator){
        return driver.findElements(locator);
    }

    public void clickBase(By locator){
        WebElement el = findElementBase(locator);
        el.click();
    }

    public String getTextBase(By locator){
        WebElement el = findElementBase(locator);
        return el.getText().trim().toUpperCase();
    }

    public void typeTextBase(By locator, String text){
        WebElement el = findElementBase(locator);
        el.click();
        el.clear();
        el.sendKeys(text);
    }

    public boolean isTextEqual(By locator, String expectedResult){
        String actualResult = getTextBase(locator);
        expectedResult = expectedResult.toUpperCase();

        if(expectedResult.equals(actualResult)){
            return true;
        }else{
            System.out.println("Expected result: " + expectedResult + "Actual result: " + actualResult );
            return false;
        }
    }
}
