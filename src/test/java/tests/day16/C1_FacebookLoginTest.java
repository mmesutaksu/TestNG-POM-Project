package tests.day16;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.FacebookLoginPage;
import utilities.TestBase;

public class C1_FacebookLoginTest extends TestBase {

    @Test
    public void gelenekselTest() {
        driver.get("http://facebook.com");
        driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();

        WebElement emailTextBox = driver.findElement(By.id("email"));
        emailTextBox.sendKeys("mehmet@gmail.com");

        WebElement passwordTextBox = driver.findElement(By.id("pass"));
        passwordTextBox.sendKeys("12345");

        driver.findElement(By.xpath("//button[@name='login']")).click();
    }

    @Test
    public void pageIleTest(){

        driver.get("http://facebook.com");

        FacebookLoginPage facebookLoginPage = new FacebookLoginPage(driver);

            facebookLoginPage.cookies.click();
            facebookLoginPage.emailTextBox.sendKeys("asdf@gmail.com");
            facebookLoginPage.passwordTextBox.sendKeys("123456");
            facebookLoginPage.loginButonu.click();
    }
}
