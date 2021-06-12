package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KoalaResortLoginPage {

    WebDriver driver;
    public KoalaResortLoginPage(WebDriver driver){
        this.driver=driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "navLogon")
    public WebElement loginLink;

    @FindBy(id = "UserName")
    public WebElement userNameTextBox;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(id = "btnSubmit")
    public WebElement loginButton;

}
