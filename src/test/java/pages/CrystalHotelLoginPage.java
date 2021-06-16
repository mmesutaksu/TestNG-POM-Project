package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CrystalHotelLoginPage {

    public CrystalHotelLoginPage(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy (id = "details-button")
    public WebElement güvenlikDuvari;

    @FindBy(id = "proceed-link")
    public WebElement siteyeDevamEt;

    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement logInLink;

    @FindBy(id = "UserName")
    public WebElement userNameTextBox;

    @FindBy(id = "Password")
    public WebElement passwordTextBox;

    @FindBy(id = "btnSubmit")
    public WebElement logInButton;

    @FindBy(xpath = "//*[text()='Hotel Management']")
    public WebElement hotelManagementLink;

    @FindBy(xpath = "(//i[@class='icon-calendar'])[2]")
    public WebElement hotelListLink;

    @FindBy(css = ".hidden-480")
    public WebElement addHotelLink;

    @FindBy(id = "Code")
    public WebElement codeTextBox;

    @FindBy(xpath = "//*[text()='Hotel was inserted successfully']")
    public WebElement successfullyText;

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement okButton;
}
