package tests.practices;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CrystalHotelLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Practice01PozitiveTest {
/*
    1) com.techproed altinda bir package olustur : smoketest

    2) Bir Class olustur : PositiveTest

    3) Bir test method olustur positiveLoginTest()

    http://qa-environment.crystalkeyhotels.com adresine git

    login butonuna bas

    test data username: manager ,

    test data password : Manager2!

    Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
 */
    @Test
    public void positiveLoginTest (){
        //http://qa-environment.crystalkeyhotels.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("cr_url"));

        CrystalHotelLoginPage crystalHotelLoginPage = new CrystalHotelLoginPage();

        crystalHotelLoginPage.güvenlikDuvari.click();
        crystalHotelLoginPage.siteyeDevamEt.click();

        crystalHotelLoginPage.logInLink.click();

        crystalHotelLoginPage.userNameTextBox.sendKeys(ConfigReader.getProperty("cr_valid_username"));

        crystalHotelLoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("cr_valid_password"));

        crystalHotelLoginPage.logInButton.click();

        String actuelUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = ConfigReader.getProperty("cr_basarili_giris_url");

        Assert.assertEquals(actuelUrl,expectedUrl);







    }
}
