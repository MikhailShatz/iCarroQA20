package tests;

import dto.UserDTO;
import dto.UserDTOWith;
import dto.UserDtoLombok;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

//    @Test
//    public void PositiveLoginUserDTO(){
//        UserDTO userDTO = new UserDTO("abc@gmail.com", "Bruh12345!");
//        app.getUserHelper().login(userDTO);
//        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());
//    }
//    @Test
//    public void PositiveLoginUserDTOWith(){
//        UserDTOWith userDTOWith = new UserDTOWith().withEmail("abc@gmail.com").withPassword("Bruh12345!");
//        app.getUserHelper().login(userDTOWith);
//        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());
//    }
    @Test
    public void positiveLogin(){
        UserDtoLombok userDtoLombok = UserDtoLombok.builder().
                email("abc@gmail.com").password("Bruh12345!").
                build();
        app.getUserHelper().loginUserDtoLombok(userDtoLombok);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());
    }
}
