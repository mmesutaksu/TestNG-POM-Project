package tests.day17;

import org.testng.annotations.Test;
import pages.FacebookLoginPage;
import utilities.Driver;

public class C1_DriverIlkClass {

    @Test
    public void test01(){

        Driver.getDriver().get("https://youtube.com");

        Driver.getDriver().get("https://amazon.com");

        Driver.getDriver().get("https://facebook.com");

        Driver.closeDriver();
    }
}
