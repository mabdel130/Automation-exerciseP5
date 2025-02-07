package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P11_SubscriptionincartPage;

import static drivers.DriverHolder.getDriver;
import static pages.BasePage.captureScreenshot;
import static pages.P10_SubscriptioninHomePage.*;
import static util.Utlity.generateDynamicEmail;

public class TC11_Subscriptionincart extends BaseTest {
    static String email = generateDynamicEmail();

    @Test(priority = 1, description = "Subscription in cart Page")
    public void VerifySubscriptionincartPage_P() {
        // TODO:Verify Subscription in Cart page

        new P11_SubscriptionincartPage(getDriver())
                .clickoncartButton()
                .scrollinpage();
        new P11_SubscriptionincartPage(getDriver())
                .VerifytextSUBSCRIPTION();
        captureScreenshot(getDriver(), "Verify text 'SUBSCRIPTION' is appear successfully in cartPage");
        Assert.assertEquals(actualMessagefor_Subscription, expectedMessagefor_Subscription, "Text does not match!");

        new P11_SubscriptionincartPage(getDriver())
                .enterEmailtosubscrip(email)
                .clickArrowButtontoconfirm()
                .Verifysuccessmessage();
        captureScreenshot(getDriver(), "Verify You have been successfully subscribed! in cartPage");
        Assert.assertEquals(actualMessagefor_successmessage, expectedMessagefor_successmessage, "Text does not match!");
    }
}