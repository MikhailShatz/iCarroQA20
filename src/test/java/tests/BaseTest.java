package tests;

import dto.UserDtoLombok;
import manager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.RandomUtils;

public class BaseTest {
    static ApplicationManager app = new ApplicationManager();
    RandomUtils randomUtils = new RandomUtils();

    @BeforeSuite
    public void setup(){
        app.init();
    }
    UserDtoLombok userDtoLombok = UserDtoLombok.builder().
            email("abc@gmail.com").password("Bruh12345!").
            build();

    @AfterSuite
    public void stop(){
        app.tearDown();
    }

    public void logoutIfLogin(){
        if(app.getUserHelper().btnLogoutExist()){
            app.getUserHelper().logout();
        }
    }
}
