package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.P13_ProductquantityinCartPage;

import static drivers.DriverHolder.getDriver;
import static pages.BasePage.captureScreenshot;

import static pages.P13_ProductquantityinCartPage.actualQuantity;
import static pages.P13_ProductquantityinCartPage.expectedQuantity;

public class TC13_ProductquantityinCart extends BaseTest {
    String quantity = String.valueOf(4);

    @Test(priority = 1, description = "Verify Product quantity in Cart")
    public void verifyProductquantityinCart_P() {
        // TODO:Verify Product quantity in Cart
        new P13_ProductquantityinCartPage(getDriver())
                .clickonproductViewButton();
        captureScreenshot(getDriver(), " Verify product detail is opened");
        new P13_ProductquantityinCartPage(getDriver())
                .click_to_addQuantity(quantity)
                .clickonaddtoButton()
                .clickonviewcartButton()
                .verifythatproductisdisplayedincartpagewithexactquantity();
        captureScreenshot(getDriver(), "verifythatproductisdisplayedincartpagewithexactquantity");
        Assert.assertEquals(actualQuantity, expectedQuantity, "Text does not match!");
    }
}