package manager;

import dto.UserDTO;
import dto.UserDTOWith;
import dto.UserDtoLombok;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{




    public UserHelper(WebDriver driver) {
        super(driver);
    }

    By btnLoginNavigatorMenu =  By.xpath("//a[contains(@href, '/login')]");
    By inputEmailLoginForm = By.xpath("//input[@id='email']");

    By inputPasswordLoginForm = By.xpath("//input[@id='password']");

    By btnYallaLoginForm = By.xpath("//button[@type='submit']");

    By textSuccessLoginPopUp = By.xpath("//h2[@class='message']");

    By btnRegForm = (By.xpath("//a[contains(@href, '/registration')]"));

    By inputNameReg = (By.xpath("//input[@id='name']"));
    By inputLastNameReg = (By.xpath("//input[@id='lastName']"));
    By inputEmailReg = (By.xpath("//input[@id='email']"));
    By inputPasswordReg = (By.xpath("//input[@id='password']"));

    String btnRegNewUser = "document.querySelector('#terms-of-use').click();";
    By checkBoxReg = By.xpath("//label[@for='name']");

    By btnYallaReg = By.xpath("//button[@type='submit']");
    By textPopUpMessageRegH1 = (By.xpath("//div[@class='dialog-container']//h1[@class='title']"));

    public void login(UserDTO userDTO) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, userDTO.getEmail());
        typeTextBase(inputPasswordLoginForm, userDTO.getPassword());
        clickBase(btnYallaLoginForm);
    }
    public void login(UserDTOWith userDTO) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, userDTO.getEmail());
        typeTextBase(inputPasswordLoginForm, userDTO.getPassword());
        clickBase(btnYallaLoginForm);
    }

    public void loginUserDtoLombok(UserDtoLombok user) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, user.getEmail());
        typeTextBase(inputPasswordLoginForm, user.getPassword());
        clickBase(btnYallaLoginForm);
    }
    
    public boolean validatePopUpMessageSuccessAfterLogin(){
        return isTextEqual(textSuccessLoginPopUp, "LOGGED IN SUCCESS");
    }

    public void fillRegistrationForm(UserDtoLombok user) {
        clickBase(btnRegForm);
        typeTextBase(inputNameReg, user.getName());
        typeTextBase(inputLastNameReg, user.getLastName());
        typeTextBase(inputEmailReg, user.getEmail());
        typeTextBase(inputPasswordReg, user.getPassword());
       // jsClickBase(btnRegNewUser);
        clickByXY(checkBoxReg, 10, 12);
        clickBase(btnYallaReg);

        /*


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

         */
    }

    public boolean validatePopUpMessageSuccessAfterRegistration() {
        String expectedResult = "Registered".toUpperCase();
        return isTextEqual(textPopUpMessageRegH1, expectedResult);
    }
}
