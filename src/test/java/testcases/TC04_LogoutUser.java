package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P04_LogoutUserPage;

import static drivers.DriverHolder.getDriver;
import static pages.BasePage.captureScreenshot;
import static pages.P02_Login_User_with_Valid_Data_Page.expected_Messagefor_login;
import static pages.P04_LogoutUserPage.actualMessagefor_navigatedtologinpage;


public class TC04_LogoutUser extends BaseTest {

    String email = "mohamed@exa.com";
    String password = "123456789";

    @Test(priority = 1, description = "User LogOut")
    public void UserLogout_P() {
        // TODO: UserLogOut
        new P04_LogoutUserPage(getDriver())
                .Verify_login_to_ur_account_visible();
        captureScreenshot(getDriver(), "Verify 'Login to your account' is visible");
        Assert.assertEquals(expected_Messagefor_login, expected_Messagefor_login, "Text does not match!");
        new P04_LogoutUserPage(getDriver())
                .enterEmail_to_login(email)
                .enterPassword_to_login(password)
                .click_on_continue_to_login()
                .click_on_LogoutButton()
                .Verifythatuserisnavigatedtologinpage();
        captureScreenshot(getDriver(), "Verify 'Login to your account' is visible");
        Assert.assertEquals(expected_Messagefor_login, actualMessagefor_navigatedtologinpage, "Text does not match!");

    }
}