package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class KoalaResortPage {


        public KoalaResortPage(){
            PageFactory.initElements(Driver.getDriver(),this);
        }

        @FindBy(id = "navLogon")
        public WebElement loginLink;

        @FindBy(id = "UserName")
        public WebElement userNameTextBox;

        @FindBy(id = "Password")
        public WebElement passwordTextBox;

        @FindBy(id = "btnSubmit")
        public WebElement loginButton;

        @FindBy(xpath = "//tbody//tr[1]//td")
        public List<WebElement> birinciSatirDatalar;

        @FindBy(xpath = "//thead//tr[1]//th")
        public List<WebElement> sütunBasliklariListesi;

        @FindBy(xpath = "//tbody")
        public WebElement tbodyWE;

        @FindBy(xpath = "//tbody//td")
        public List<WebElement> bodydekiTümCellListesi;

        @FindBy(xpath = "//tbody//tr")
        public List<WebElement> tümSatirlarListesi;

        public void koalaResortLogin(){
                Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
                loginLink.click();
                userNameTextBox.sendKeys(ConfigReader.getProperty("kr_valid_username"));
                passwordTextBox.sendKeys(ConfigReader.getProperty("kr_valid_password"));
                loginButton.click();
        }

        public void istenilenSatiriYazdir(int satirNo){

                String satirXpath = "//tbody//tr[" + (satirNo-1) + "]";

                System.out.println(satirNo + ". Satirdaki Data: " + Driver.getDriver().findElement(By.xpath(satirXpath)).getText());
        }

        public void sütunYazdir(int sütunNo){
                String sütunPath = "//tbody//tr//td[" + sütunNo + "]";

                WebElement sütunHead = Driver.getDriver().findElement(By.xpath("//thead//th[" + sütunNo + "]"));
                System.out.println(sütunHead.getText());

                List<WebElement> istenilenSütunList = Driver.getDriver().findElements(By.xpath(sütunPath));

                for (WebElement w : istenilenSütunList) {
                        System.out.println(w.getText());
                }
        }

        public String dataStringBul(int satirNo, int sutunNo){
                // ornek : her 3. satirdaki 2.sutunu bulmak istersek //tbody//tr[3]//td[2] yazabiliriz
                String dataPath="//tbody//tr["+ satirNo +"]//td["+sutunNo+"]";

                return Driver.getDriver().findElement(By.xpath(dataPath)).getText();
        }
}
