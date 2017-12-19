package sahabt_TestMaster;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class CreateUserTest {
    WebDriver driver;
    AppTest apptest = new AppTest();

    @Test
    public void Create_User_Test(){
        apptest.setup();
        apptest.createUser();

        String title = apptest.getTitle();

        Assert.assertTrue("login Success",title.contains("DeFacto"));
        System.out.println("Login success");
    }
}
