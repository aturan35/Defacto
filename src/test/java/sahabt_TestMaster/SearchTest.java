package sahabt_TestMaster;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class SearchTest {
    WebDriver driver;
    AppTest apptest = new AppTest();

    @Test
    public void Search_Test() throws InterruptedException {
        apptest.setup();
        apptest.login("aykut456@gmail.com","123456");

        apptest.search();

        apptest.payingTime();

        apptest.bigFinal();


    }
}