package tests;

import dto.UserDtoLombok;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{



    @AfterTest
    public void postConditionLogin(){

    }
    @Test
    public void positiveRegistrationTest(){
        String email = randomUtils.generateEmail(7);
        UserDtoLombok user = UserDtoLombok.builder().
                email(email).password("Bruh12345!").
                lastName("awggw").name("fdnseg").
                build();
        app.getUserHelper().fillRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterRegistration());
    }
@Test
    public void negativeRegistrationWrongEmail(){

        UserDtoLombok user = UserDtoLombok.builder().
                email("abc@").password("Bruh12345!").
                lastName("awggw").name("fdnseg").
                build();
        app.getUserHelper().fillRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validateMessageIncorrectEmail());
    }

    @Test
    public void negativeRegistrationWrongPassword(){

        UserDtoLombok user = UserDtoLombok.builder().
                email("abc@gmail.com").password("Bruh12345").
                lastName("awggw").name("fdnseg").
                build();
        app.getUserHelper().fillRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validateMessageWrongPasswordReg());
    }
    @Test
    public void negativeRegistrationBlankEmail(){

        UserDtoLombok user = UserDtoLombok.builder().
                email("").password("Bruh12345!").
                lastName("awggw").name("fdnseg").
                build();
        app.getUserHelper().fillRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validateMessageBlankEmail());
    }



}
