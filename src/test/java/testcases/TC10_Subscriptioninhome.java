package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P10_SubscriptioninHomePage;

import static drivers.DriverHolder.getDriver;
import static pages.BasePage.captureScreenshot;

import static pages.P10_SubscriptioninHomePage.*;
import static util.Utlity.generateDynamicEmail;

public class TC10_Subscriptioninhome extends BaseTest {
    static String email = generateDynamicEmail();

    @Test(priority = 1, description = "Subscription in home Page")
    public void VerifySubscriptioninhomepage_P() {
        // TODO:Verify Subscription in home page

        new P10_SubscriptioninHomePage(getDriver())
                .scrollinpage();
        new P10_SubscriptioninHomePage(getDriver())
                .VerifytextSUBSCRIPTION();
        captureScreenshot(getDriver(), "Verify text 'SUBSCRIPTION' is appear successfully in home Page");
        Assert.assertEquals(actualMessagefor_Subscription, expectedMessagefor_Subscription, "Text does not match!");

        new P10_SubscriptioninHomePage(getDriver())
                .enterEmailtosubscrip(email)
                .clickArrowButtontoconfirm()
                .Verifysuccessmessage();
        captureScreenshot(getDriver(), "Verify You have been successfully subscribed! in home Page");
        Assert.assertEquals(actualMessagefor_successmessage, expectedMessagefor_successmessage, "Text does not match!");
    }
}