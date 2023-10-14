package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class BaseHelper {
    WebDriver driver;

    public BaseHelper(WebDriver driver){
        this.driver = driver;
    }

    private WebElement findElementBase(By locator){
        return driver.findElement(locator);
    } //no such element exception
    private List<WebElement> findElementsBase(By locator){
        return driver.findElements(locator);
    } //empty list

    public boolean isElementExist(By locator){
        return !findElementsBase(locator).isEmpty();
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
     public void  jsClickBase(String locator){
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript(locator);
     }

     public void clickByXY(By locator, double down, int right){ //5 15
        Rectangle rect = findElementBase(locator).getRect();
        int x = rect.getX() + (rect.getWidth()/right);
        int y = (int) (rect.getY() + (rect.getHeight()/ down)); //0.3

         Actions actions = new Actions(driver);
         actions.moveByOffset(x,y).click().perform();

     }


}
