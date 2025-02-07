package testcases;

import org.testng.annotations.Test;
import pages.P16_LoginbeforeCheckoutPage;

import static drivers.DriverHolder.getDriver;
import static pages.BasePage.captureScreenshot;
import static util.Utlity.*;

public class TC16_LoginbeforeCheckout extends BaseTest {

    static String comment = generateRandomMessage();
    static String name = generateRandomFullName();
    static String cardnumber = generateRandomCardNumber();
    static String CVC = generateRandomCardNumber();
    static String expirationMonth = String.valueOf(generateRandomMonth());
    static String expirationYear = String.valueOf(generateRandomYear(2025, 2050));

    @Test(priority = 1, description = "login before Checkout", dependsOnMethods = "testcases.TC02_Login_User_with_Valid_Data.Login_User_with_correct_email_and_password_p")
    public void loginbeforeCheckout_P() {
        // TODO:login before Checkout
        new P16_LoginbeforeCheckoutPage(getDriver()).scrollinpage();
        new P16_LoginbeforeCheckoutPage(getDriver())
                .clickonAddtocartButton()
                .clickonViewCartButton();
        captureScreenshot(getDriver(), " Verify that cart page is displayed");
        new P16_LoginbeforeCheckoutPage(getDriver())
                .clickproceedToCheckoutButton();
        captureScreenshot(getDriver(), " Verify Address Details and Review Your Order");
        new P16_LoginbeforeCheckoutPage(getDriver())
                .addcomment(comment)
                .clickonPlaceorderButton()
                .addnameoncard(name)
                .addcardnumber(cardnumber)
                .addCVC(CVC)
                .addexpirationMonth(expirationMonth)
                .addexpirationYear(expirationYear)
                .clickonpayandconfirmorderButton();
        captureScreenshot(getDriver(), "'Your order has been placed successfully!'");
        new P16_LoginbeforeCheckoutPage(getDriver())
                .clicktodeleteMyaccount();
        captureScreenshot(getDriver(), "Account Deleted!After place Order ");
        new P16_LoginbeforeCheckoutPage(getDriver()).clicktocontafterdeleteMyaccount();


    }
}