package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P03_Login_User_with_inValid_Data_Page;
import static drivers.DriverHolder.getDriver;
import static pages.BasePage.captureScreenshot;
import static pages.P02_Login_User_with_Valid_Data_Page.expected_Messagefor_login;
import static pages.P03_Login_User_with_inValid_Data_Page.*;
import static util.Utlity.generateDynamicEmail;
import static util.Utlity.generateDynamicPassword;


public class TC03_Login_User_with_inValid_Data extends BaseTest {
    static String email = generateDynamicEmail();
    static String password = generateDynamicPassword();

    @Test(priority = 1, description = "login to ur Account with in valid data")
    public void Login_User_with_incorrect_email_and_password_N() {
        // TODO: Login_User_with_in_correct_email_and_password
        new P03_Login_User_with_inValid_Data_Page(getDriver())
                .Verify_login_to_ur_account_visible();
        captureScreenshot(getDriver(), "Verify 'Login to your account' is visible");
        Assert.assertEquals(actualMessagefor_login, expected_Messagefor_login, "Text does not match!");
        new P03_Login_User_with_inValid_Data_Page(getDriver())
                .enterEmail_to_login(email)
                .enterPassword_to_login(password)
                .click_on_continue_to_login()
                .VerifyerrorYouremailorpasswordisincorrectisvisible();
        captureScreenshot(getDriver(), " Login_User_with_in_correct_email_and_password");
        Assert.assertEquals(actualMessagefor_errordata, expected_Messagefor_errordata, "Text does not match!");

    }
}