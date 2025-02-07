package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.P02_Login_User_with_Valid_Data_Page;

import static drivers.DriverHolder.getDriver;
import static pages.BasePage.captureScreenshot;

import static pages.P02_Login_User_with_Valid_Data_Page.*;


public class TC02_Login_User_with_Valid_Data extends BaseTest {
    String email = "mohamed@exa.com";
    String password = "123456789";

    @Test(priority = 1, description = "login to ur Account")
    public void Login_User_with_correct_email_and_password_p() {
        // TODO: Login_User_with_correct_email_and_password
        new P02_Login_User_with_Valid_Data_Page(getDriver())
                .Verify_login_to_ur_account_visible();
        captureScreenshot(getDriver(), "Verify 'Login to your account' is visible");
        Assert.assertEquals(expected_Messagefor_login, expected_Messagefor_login, "Text does not match!");
        new P02_Login_User_with_Valid_Data_Page(getDriver())
                .enterEmail_to_login(email)
                .enterPassword_to_login(password)
                .click_on_continue_to_login();

    }
}