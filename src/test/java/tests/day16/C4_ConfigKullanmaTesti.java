package tests.day16;

import org.testng.annotations.Test;
import pages.KoalaResortLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

public class C4_ConfigKullanmaTesti extends TestBase{

    /*
    1 ) Bir Class olustur : PositiveTest
    2) Bir test method olustur positiveLoginTest()
     http://qa-environment.koalaresorthotels.com adresine git
     login butonuna bas
     test data username: manager ,
     test data password : Manager1!
     Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
    */

    @Test
    public void test01(){

        driver.get("http://qa-environment.koalaresorthotels.com");

        KoalaResortLoginPage koalaResortLoginPage = new KoalaResortLoginPage(driver);

        koalaResortLoginPage.loginLink.click();
        koalaResortLoginPage.userNameTextBox.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        koalaResortLoginPage.password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        koalaResortLoginPage.loginButton.click();

    }

}
