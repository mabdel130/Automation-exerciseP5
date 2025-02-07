package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P00_HomePage;

import static drivers.DriverHolder.getDriver;
import static pages.BasePage.captureScreenshot;
import static pages.P00_HomePage.*;

public class TC00_HomePage extends BaseTest {

    @Test(priority = 1, description = "HomePage general")
    public void homePage_General() {
        // TODO: 1-HomePage general
        new P00_HomePage(getDriver())
                .verifythathomepageisvisiblesuccessfully();
        captureScreenshot(getDriver(), "home page is visible successfully");
        Assert.assertEquals(actualMessagefor_homepage, expected_Messagefor_homepage, "Text does not match!");
    }

    @Test(priority = 1, description = "HomePage LoginandSignUP")
    public void homePage_LoginandSignUP() {
        // TODO: 1-HomePageloginand signUP
        new P00_HomePage(getDriver()).click_on_login_signUp_button();

    }
}