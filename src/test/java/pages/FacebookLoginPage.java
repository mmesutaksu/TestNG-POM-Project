package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FacebookLoginPage {

    WebDriver  driver;

    public FacebookLoginPage(WebDriver driver){
        this.driver=driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//button[@type='submit'])[3]")
    public WebElement cookies;

    @FindBy(id="email")
    public WebElement emailTextBox;

    @FindBy(id="pass")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement loginButonu;


}
