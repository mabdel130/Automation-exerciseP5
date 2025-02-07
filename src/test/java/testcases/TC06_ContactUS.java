package testcases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P06_ContactUsPage;

import static drivers.DriverHolder.getDriver;
import static pages.BasePage.captureScreenshot;
import static pages.P00_HomePage.actualMessagefor_homepage;
import static pages.P00_HomePage.expected_Messagefor_homepage;
import static pages.P06_ContactUsPage.*;
import static util.Utlity.*;

public class TC06_ContactUS extends BaseTest {
    static String name = generateRandomFullName();
    static String email = generateDynamicEmail();
    static String msg = generateRandomMessage();

    @Test(priority = 1, description = "contactUs")
    public void contactUs() {
        // TODO:contactUs
        new P06_ContactUsPage(getDriver())
                .clickon_Cotactus_button().assertongetintouch_Text();
        captureScreenshot(getDriver(), "contactUs");
        Assert.assertEquals(actualMessagefor_getintouch, expected_Messagefor_getintouch, "Text does not match!");
        new P06_ContactUsPage(getDriver())
                .enterEmail(email)
                .entername(name)
                .enterMsg(msg)
                .clicktoUploadfile()
                .clickSubmitButton()
                .asserton_urDetails_Text();
        captureScreenshot(getDriver(), "ur Details Uploaded success");
        Assert.assertEquals(actualMessagefor_rurDetails, expected_Messagefor_urDetails, "Text does not match!");
        new P06_ContactUsPage(getDriver()).click0nhomeButton();
        captureScreenshot(getDriver(), "home page is visible successfully");
        Assert.assertEquals(actualMessagefor_homepage, expected_Messagefor_homepage, "Text does not match!");
    }
}