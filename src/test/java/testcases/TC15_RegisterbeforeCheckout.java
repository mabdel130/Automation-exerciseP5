package testcases;

import org.testng.annotations.Test;
import pages.P15_RegisterbeforeCheckoutPage;

import static drivers.DriverHolder.getDriver;
import static pages.BasePage.captureScreenshot;
import static util.Utlity.*;
import static util.Utlity.generateRandomYear;

public class TC15_RegisterbeforeCheckout extends BaseTest {

    static String comment = generateRandomMessage();
    static String name = generateRandomFullName();
    static String cardnumber = generateRandomCardNumber();
    static String CVC = generateRandomCardNumber();
    static String expirationMonth = String.valueOf(generateRandomMonth());
    static String expirationYear = String.valueOf(generateRandomYear(2025, 2050));

    @Test(priority = 1, description = "Register before Checkout", dependsOnMethods = "testcases.TC01_Register_User.register_User_withvalidData_p")
    public void registerbeforeCheckout_P() {
        // TODO:Register before Checkout
        new P15_RegisterbeforeCheckoutPage(getDriver()).scrollinpage();
        new P15_RegisterbeforeCheckoutPage(getDriver())
                .clickonAddtocartButton()
                .clickonViewCartButton();
        captureScreenshot(getDriver(), " Verify that cart page is displayed");
        new P15_RegisterbeforeCheckoutPage(getDriver())
                .clickproceedToCheckoutButton();
        captureScreenshot(getDriver(), " Verify Address Details and Review Your Order");
        new P15_RegisterbeforeCheckoutPage(getDriver())
                .addcomment(comment)
                .clickonPlaceorderButton()
                .addnameoncard(name)
                .addcardnumber(cardnumber)
                .addCVC(CVC)
                .addexpirationMonth(expirationMonth)
                .addexpirationYear(expirationYear)
                .clickonpayandconfirmorderButton();
        captureScreenshot(getDriver(), "'Your order has been placed successfully!'");
        new P15_RegisterbeforeCheckoutPage(getDriver())
                .clicktodeleteMyaccount();
        captureScreenshot(getDriver(), "Account Deleted!After place Order ");
        new P15_RegisterbeforeCheckoutPage(getDriver()).clicktocontafterdeleteMyaccount();


    }
}