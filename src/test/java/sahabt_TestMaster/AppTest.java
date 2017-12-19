package sahabt_TestMaster;

import junit.framework.Test;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppTest {
    WebDriver driver;


    public String driverName = "webdriver.chrome.driver";
    public String driverPath = "driver/chromedriver.exe";
    public String url = "http://www.defacto.com.tr";



    @Before
    public void setup() {
        System.setProperty(driverName, driverPath);
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.get("http://www.defacto.com.tr");
    }

    public void createUser(){
        //click(By.cssSelector(".fa-times"));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
        action.sendKeys(Keys.ESCAPE).build().perform();

        click(By.cssSelector(".btn-warning"));
        find(By.id("RegisterModel_CustomerFirstName")).sendKeys("ali");
        find(By.id("RegisterModel_CustomerLastName")).sendKeys("ayşe");
        find(By.id("RegisterModel_CustomerEmail")).sendKeys("aykut45@gmail.com");
        find(By.id("RegisterModel_CustomerMobilePhone")).sendKeys("5548792301");
        find(By.id("RegisterModel_CustomerBirthDateDay")).sendKeys("29");
        find(By.id("RegisterModel_CustomerBirthDateMonth")).sendKeys("11");
        find(By.id("RegisterModel_CustomerBirthDateYear")).sendKeys("1981");
        find(By.cssSelector("[name=\"RegisterModel\\.Gender\"]")).sendKeys("e");
        find(By.id("RegisterModel_CustomerPassword")).sendKeys("123456");
        find(By.id("RegisterModel_CustomerPasswordConfirm")).sendKeys("123456");
        click(By.cssSelector("[for=\"RegisterModel_CustomerIsApprovedContract\"] [data-val]"));
        //click(By.cssSelector("[type=\"submit\"]"));

    }

    public void login(String email, String password) throws InterruptedException {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
        action.sendKeys(Keys.ESCAPE).build().perform();
        //Thread.sleep(1000);

        click(By.cssSelector(".btn-login-icon.hidden-sm"));
        action.sendKeys(Keys.ESCAPE).build().perform();
        find(By.id("LoginModel_Email")).sendKeys(email);
        find(By.id("LoginModel_Password")).sendKeys(password);


        click(By.id("LoginBtn"));
        Thread.sleep(2000);
        action.sendKeys(Keys.ESCAPE).build().perform();


        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Erkek')]"));
        Assert.assertTrue("Text not found!", list.size() > 0);
        System.out.println("Kullanıcı girişi başarılı!");


    }

    public void wrong_login(String email,String password) throws InterruptedException {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
        action.sendKeys(Keys.ESCAPE).build().perform();
        //Thread.sleep(1000);

        click(By.cssSelector(".btn-login-icon.hidden-sm"));
        action.sendKeys(Keys.ESCAPE).build().perform();
        find(By.id("LoginModel_Email")).sendKeys(email);
        find(By.id("LoginModel_Password")).sendKeys(password);


        click(By.id("LoginBtn"));
        Thread.sleep(2000);
        action.sendKeys(Keys.ESCAPE).build().perform();


        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Kullanıcı Girişi')]"));
        Assert.assertTrue("Text not found!", list.size() > 0);
        System.out.println("Hatalı e-mail ya da şifre!!");


    }

    public void search() throws InterruptedException {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();

        click(By.cssSelector("#navbar-collapse-grid [href=\"\\/erkek\"] span"));
        action.sendKeys(Keys.ESCAPE).build().perform();

        click(By.cssSelector("._mCS_9 li:nth-of-type(1) gt"));
        action.sendKeys(Keys.ESCAPE).build().perform();

        click(By.cssSelector("._mCS_17 li:nth-of-type(8) gt"));
        action.sendKeys(Keys.ESCAPE).build().perform();

        click(By.cssSelector("#facetAccordion .panel-default:nth-of-type(5) [data-toggle]"));
        action.sendKeys(Keys.ESCAPE).build().perform();

        click(By.xpath("//div[@id='fx_c']/div/div/div/div[@class='mCSB_container']/div[@id='boutique-category']/ul[@class='navbar-default']//gt[.='Gri']"));
        action.sendKeys(Keys.ESCAPE).build().perform();

        click(By.xpath("//div[@id='fx_c']/div/div/div/div[@class='mCSB_container']/div[@id='boutique-category']/ul[@class='navbar-default']//gt[.='Çivit Mavisi']"));
        action.sendKeys(Keys.ESCAPE).build().perform();

        click(By.xpath("//ul[@id='CatalogFacetTabs']//ul[@class='pagination pagination-sm pull-right']//a[@title='Sonraki']"));
        action.sendKeys(Keys.ESCAPE).build().perform();

        click(By.xpath("/html//section[@id='fixed']//a[@href='/modern-fit-gomlek-758642']/figure//h2[.='Modern Fit Gömlek']"));
        action.sendKeys(Keys.ESCAPE).build().perform();

        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Modern Fit Gömlek')]"));
        Assert.assertTrue("Text not found!", list.size() > 0);
        System.out.println("Gömlek bulundu");


        click(By.xpath("/html//section[@id='fixed']/div[5]/div/div//ul[@class='productSizes productWidthHeight top15']//a[@href='javascript:;']/span[.='S']"));
        action.sendKeys(Keys.ESCAPE).build().perform();

        WebElement element=driver.findElement(By.cssSelector("[class=\"col-lg-2 col-md-4 col-sm-4 col-xs-3 no-padding\"] .form-control"));
        action.doubleClick(element).perform();

        click(By.cssSelector("[class=\"product-detail col-lg-4 col-md-6 col-sm-6 col-xs-12 no-paddingL\"] [type=\"button\"]"));
        Thread.sleep(2000);

        click(By.cssSelector("#popupBasket_ComplateShopping"));
        //find(By.cssSelector("[class=\"col-lg-2 col-md-4 col-sm-4 col-xs-3 no-padding\"] .form-control"));

    }

    public void payingTime() throws InterruptedException {
        Actions action = new Actions(driver);



        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Sepet')]"));
        Assert.assertTrue("Text not found!", list.size() > 0);
        System.out.println("Sepette ürün mevcut");


        click(By.cssSelector("button"));
        action.sendKeys(Keys.ESCAPE).build().perform();
        Thread.sleep(2000);

        click(By.cssSelector("#ShippingAddressForm > .form-group:nth-child(1) [class=\"col-lg-10\"] .form-control"));
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
        action.sendKeys(Keys.ENTER).build().perform();



        action.sendKeys(Keys.TAB).build().perform();
        find(By.xpath("/html//select[@id='Address_AddressCityId']")).sendKeys("manisa");


        action.sendKeys(Keys.TAB).build().perform();
        find(By.xpath("/html//select[@id='Address_AddressCountyId']")).sendKeys("yunusemre");


        action.sendKeys(Keys.TAB).build().perform();
        find(By.xpath("/html//input[@id='Address_AddressPostalCode']")).sendKeys("45010");

        action.sendKeys(Keys.TAB).build().perform();
        find(By.xpath("/html//textarea[@id='Address_AddressText']")).sendKeys("3818.sokak 3/5");

        action.sendKeys(Keys.TAB).build().perform();
        find(By.xpath("/html//input[@id='Address_AddressFirstName']")).sendKeys("ali");

        action.sendKeys(Keys.TAB).build().perform();
        find(By.xpath("/html//input[@id='Address_AddressLastName']")).sendKeys("ayşe");

        action.sendKeys(Keys.TAB).build().perform();
        find(By.xpath("/html//input[@id='Address_AddressMobilePhone']")).sendKeys("5078456321");



        click(By.xpath("/html//form[@id='AddressForm']/div[@class='form-group row top15']//input[@value='Kaydet']"));
        Thread.sleep(10000);

        driver.findElements(By.xpath("//*[contains(text(),'Adrese Teslimat')]"));
        Assert.assertTrue("Text not found!", list.size() > 0);
        System.out.println("Adres bilgileri mevcut");

        click(By.xpath("/html/body/section/div[3]//button[@name='ClickCollectID']"));


    }
     public void bigFinal() throws InterruptedException {
         Actions action = new Actions(driver);
         action.sendKeys(Keys.ESCAPE).build().perform();
         Thread.sleep(5000);

         find(By.xpath("/html//input[@id='Payment_CardNumber1']")).sendKeys("5235296000000000");

         action.sendKeys(Keys.TAB).build().perform();
         find(By.xpath("/html//select[@id='Payment_ExpireMonth']")).sendKeys("6");

         action.sendKeys(Keys.TAB).build().perform();
         find(By.xpath("/html//select[@id='Payment_ExpireYear']")).sendKeys("2020");

         action.sendKeys(Keys.TAB).build().perform();
         find(By.xpath("/html//input[@id='Payment_SecurityCode']")).sendKeys("202");
         Thread.sleep(3000);

         click(By.xpath("/html//div[@id='MasterPassIsActive']/div[3]//div[@class='form-horizontal']/div[@class='installment-main']/div[@id='installment']/div[@class='well']/div[@class='columbs']/div[3]/div[@class='col-lg-4 col-md-4 col-sm-4 col-xs-4 inst-num']/div[@class='pull-left value']/div[@class='df-radio']/span/input[@id='Payment_BankInstallmentId']"));
         System.out.println("Karta bağlı olarak taksit yapılabilir");


         click(By.cssSelector("#IsCreditCardContractEnable"));



    }

    public String getTitle() {
        return driver.getTitle();
    }
    public void click(By by) {driver.findElement(by).click();}
    public void submit(By by) {driver.findElement(by).submit();}
    public void sendKey(By by, String value) {
        driver.findElement(by).sendKeys(value);
    }
    public WebElement find(By by) {
        return driver.findElement(by);
    }
    public void thread(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
