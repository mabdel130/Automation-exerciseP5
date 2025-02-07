package testcases;


import org.testng.annotations.Test;

import pages.P14_PlaceOrderRegisterwhileCheckoutPage;

import static drivers.DriverHolder.getDriver;
import static pages.BasePage.captureScreenshot;
import static util.Utlity.*;


public class TC14_PlaceOrderRegisterwhileCheckout extends BaseTest {
    static String comment = generateRandomMessage();
    static String name = generateRandomFullName();
    static String cardnumber = generateRandomCardNumber();
    static String CVC = generateRandomCardNumber();
    static String expirationMonth = String.valueOf(generateRandomMonth());
    static String expirationYear = String.valueOf(generateRandomYear(1950, 2025));

    @Test(priority = 1, description = "verifyPlaceOrderstep1")
    public void verifyPlaceOrderstep1_P() {
        // TODO:verifyPlaceOrderstep1
        new P14_PlaceOrderRegisterwhileCheckoutPage(getDriver())
                .clickonAddtocartButton()
                .clickonViewCartButton();
        captureScreenshot(getDriver(), " Verify that cart page is displayed");
        new P14_PlaceOrderRegisterwhileCheckoutPage(getDriver())
                .clickproceedToCheckoutButton()
                .clickRegisterLoginButton();

    }

    @Test(priority = 2, description = "verifyPlaceOrderstep2", dependsOnMethods = "testcases.TC01_Register_User.register_User_withvalidData_p")
    public void verifyPlaceOrderstep2_P() {
        new P14_PlaceOrderRegisterwhileCheckoutPage(getDriver())
                .clickoncartButton().clickproceedToCheckoutButton();
        captureScreenshot(getDriver(), " Verify Address Details and Review Your Order");
        new P14_PlaceOrderRegisterwhileCheckoutPage(getDriver())
                .addcomment(comment)
                .clickonPlaceorderButton()
                .addnameoncard(name)
                .addcardnumber(cardnumber)
                .addCVC(CVC)
                .addexpirationMonth(expirationMonth)
                .addexpirationYear(expirationYear)
                .clickonpayandconfirmorderButton();
        captureScreenshot(getDriver(), "'Your order has been placed successfully!'");
        new P14_PlaceOrderRegisterwhileCheckoutPage(getDriver())
                .clicktodeleteMyaccount();
        captureScreenshot(getDriver(), "Account Deleted!After place Order ");
        new P14_PlaceOrderRegisterwhileCheckoutPage(getDriver()).clicktocontafterdeleteMyaccount();
    }
}
