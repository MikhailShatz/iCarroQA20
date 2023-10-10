package tests;

import dto.UserDtoLombok;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{
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
}
