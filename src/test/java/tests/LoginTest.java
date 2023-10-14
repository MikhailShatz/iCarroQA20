package tests;

import dto.UserDTO;
import dto.UserDTOWith;
import dto.UserDtoLombok;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @BeforeTest
    public void preconditionsLogin(){
      //  app.navigateToMainPage();
       logoutIfLogin();
        // user login
        // user open web not login
    }
    
    @AfterTest
    public void postConditionsLogin(){
        app.getUserHelper().clickOkPopUpSuccessLogin();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Test
    public void PositiveLoginUserDTO(){
        UserDTO userDTO = new UserDTO("abc@gmail.com", "Bruh12345!");
        app.getUserHelper().login(userDTO);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());
    }
    @Test
    public void PositiveLoginUserDTOWith(){
        UserDTOWith userDTOWith = new UserDTOWith().withEmail("abc@gmail.com").withPassword("Bruh12345!");
        app.getUserHelper().login(userDTOWith);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());
    }
    @Test
    public void positiveLogin(){
        UserDtoLombok userDtoLombok = UserDtoLombok.builder().
                email("abc@gmail.com").password("Bruh12345!").
                build();
        app.getUserHelper().loginUserDtoLombok(userDtoLombok);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());
    }

    @Test
    public void negativePasswordWithoutSymbol(){
        UserDtoLombok userDtoLombok = UserDtoLombok.builder().
                email("abc@gmail.com").password("Bruh12345A").
                build();
        app.getUserHelper().loginUserDtoLombok(userDtoLombok);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageLoginIncorrect());
    }
    @Test
    public void negativePasswordWithoutNumbers(){
        UserDtoLombok userDtoLombok = UserDtoLombok.builder().
                email("abc@gmail.com").password("juqUUhui!").
                build();
        app.getUserHelper().loginUserDtoLombok(userDtoLombok);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageLoginIncorrect());
    }
    @Test
    public void negativePasswordWithoutLetters(){
        UserDtoLombok userDtoLombok = UserDtoLombok.builder().
                email("abc@gmail.com").password("1234512!").
                build();
        app.getUserHelper().loginUserDtoLombok(userDtoLombok);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageLoginIncorrect());
    }

}
