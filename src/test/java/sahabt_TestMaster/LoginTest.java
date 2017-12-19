package sahabt_TestMaster;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest {
    WebDriver driver;
    AppTest apptest = new AppTest();

    @Test
    public void Login_Test() throws InterruptedException {
        apptest.setup();
        apptest.login("aykut456@gmail.com","123456");


    }
    @Test
    public void Wrong_login_Test() throws InterruptedException {
        apptest.setup();
        apptest.wrong_login("aykut@gmail.com","123456");


    }
}
