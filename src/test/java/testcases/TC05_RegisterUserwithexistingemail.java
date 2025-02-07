package testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.P05_RegisterUsewithexistingemailPage;

import static drivers.DriverHolder.getDriver;
import static pages.BasePage.captureScreenshot;

import static pages.P01_RegisterUserPage.expected_Messagefor_NewuserSignUp;
import static pages.P05_RegisterUsewithexistingemailPage.*;


public class TC05_RegisterUserwithexistingemail extends BaseTest {
    String name = "RECORD 01-27-25 9.58.50 AM";
    String email = "only4307@goeschan.com";

    @Test(priority = 1, description = "registerUserwithexistingemail")
    public void registerUserwithexistingemail_N() {
        // TODO:registerUserwithexistingemail

        new P05_RegisterUsewithexistingemailPage(getDriver())
                .Verify_New_User_Signup_is_visible();
        captureScreenshot(getDriver(), "NewuserSignUp");
        Assert.assertEquals(actualMessagefor_NewuserSignUp, expected_Messagefor_NewuserSignUp, "Text does not match!");
        new P05_RegisterUsewithexistingemailPage(getDriver())
                .enterName(name)
                .enterEmail(email)
                .clicksignupbutton()
                .VerifyerrorEmailAddressalreadyexistisvisible();
        captureScreenshot(getDriver(), "EmailAddressalreadyexist");
        Assert.assertEquals(actualMessagefor_Emailalreadyexist, expected_Messagefor_Emailalreadyexist, "Text does not match!");
    }
}