package tests.practices;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CrystalHotelLoginPage;
import utilities.ConfigReader;
import utilities.Driver;


public class Practices02NegativeTest {

    /*
    1) smokeTest paketi altinda yeni bir Class olustur: NegativeTest
        3 Farkli test Methodunda 3 senaryoyu test et
        - yanlisSifre
        - yanlisKulllanici
        - yanlisSifreKullanici
        test data dogru username: manager , dogru password : Manager2!
    2) http://qa-environment.crystalkeyhotels.com adresine git
    3) Login butonuna bas
    4) Verilen senaryolar ile giris yapilamadigini test et
     */
    @Test (priority = 1)
    public void wrongUsernameTest(){
        Driver.getDriver().get(ConfigReader.getProperty("cr_url"));

        CrystalHotelLoginPage crystalHotelLoginPage = new CrystalHotelLoginPage();

        crystalHotelLoginPage.güvenlikDuvari.click();
        crystalHotelLoginPage.siteyeDevamEt.click();

        crystalHotelLoginPage.logInLink.click();

        crystalHotelLoginPage.userNameTextBox.sendKeys(ConfigReader.getProperty("cr_wrong_username"));

        crystalHotelLoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("cr_valid_password"));

        crystalHotelLoginPage.logInButton.click();

        String actuelUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = ConfigReader.getProperty("cr_basarili_giris_url");

        Assert.assertFalse(actuelUrl.equals(expectedUrl));
    }

    @Test (priority = 2)
    public void wrongPasswordTest(){
        Driver.getDriver().get(ConfigReader.getProperty("cr_url"));

        CrystalHotelLoginPage crystalHotelLoginPage = new CrystalHotelLoginPage();

        crystalHotelLoginPage.logInLink.click();

        crystalHotelLoginPage.userNameTextBox.sendKeys(ConfigReader.getProperty("cr_valid_username"));

        crystalHotelLoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("cr_wrong_password"));

        crystalHotelLoginPage.logInButton.click();

        String actuelUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = ConfigReader.getProperty("cr_basarili_giris_url");

        Assert.assertFalse(actuelUrl.equals(expectedUrl));
    }

    @Test (priority = 3)
    public void wrongUsernamePasswordTest(){
        Driver.getDriver().get(ConfigReader.getProperty("cr_url"));

        CrystalHotelLoginPage crystalHotelLoginPage = new CrystalHotelLoginPage();

        crystalHotelLoginPage.logInLink.click();

        crystalHotelLoginPage.userNameTextBox.sendKeys(ConfigReader.getProperty("cr_wrong_username"));

        crystalHotelLoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("cr_wrong_password"));

        crystalHotelLoginPage.logInButton.click();

        String actuelUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = ConfigReader.getProperty("cr_basarili_giris_url");

        Assert.assertFalse(actuelUrl.equals(expectedUrl));
    }

}
