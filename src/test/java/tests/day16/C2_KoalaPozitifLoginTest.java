package tests.day16;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.KoalaResortLoginPage;
import utilities.Driver;
import utilities.TestBase;

public class C2_KoalaPozitifLoginTest extends TestBase {

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
    public void pozitifLoginTest(){
        driver.get("http://qa-environment.koalaresorthotels.com");

        KoalaResortLoginPage koalaResortPage = new KoalaResortLoginPage(driver);

        koalaResortPage.loginLink.click();
        koalaResortPage.userNameTextBox.sendKeys("manager");
        koalaResortPage.password.sendKeys("Manager1!");
        koalaResortPage.loginButton.click();

    }

}
