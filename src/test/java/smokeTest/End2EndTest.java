package smokeTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CrystalHotelLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class End2EndTest {

    /*
    1. Tests packagenin altına class olusturun: D17_CreateHotel
    2. Bir metod olusturun: createHotel
    3. http://qa-environment.crystalkeyhotels.com adresine git.
    4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri girin.
        a. Username : manager
        b. Password : Manager2!
    5. Login butonuna tıklayın.
    6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
    7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
    8. Save butonuna tıklayın.
    9. “Hotel was inserted successfully” textinin göründüğünü test edin.
    10. OK butonuna tıklayın.
     */
    @Test
    public void creatHotel(){
        Driver.getDriver().get(ConfigReader.getProperty("cr_url"));

        CrystalHotelLoginPage crystalHotelLoginPage = new CrystalHotelLoginPage();

        crystalHotelLoginPage.güvenlikDuvari.click();
        crystalHotelLoginPage.siteyeDevamEt.click();

        crystalHotelLoginPage.logInLink.click();

        crystalHotelLoginPage.userNameTextBox.sendKeys(ConfigReader.getProperty("cr_valid_username"));
        crystalHotelLoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("cr_valid_password"));

        crystalHotelLoginPage.logInButton.click();

        crystalHotelLoginPage.hotelManagementLink.click();

        crystalHotelLoginPage.hotelListLink.click();

        crystalHotelLoginPage.addHotelLink.click();

        Actions actions = new Actions(Driver.getDriver());

        actions.click(crystalHotelLoginPage.codeTextBox).
                sendKeys(ConfigReader.getProperty("cr_form_code")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("cr_form_name")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("cr_form_address")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("cr_form_phone")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("cr_form_email")).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();

        //Driver.getDriver().switchTo().alert().accept();









    }
}
