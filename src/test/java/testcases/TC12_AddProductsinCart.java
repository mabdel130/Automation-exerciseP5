package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.P12_AddProductsincartPage;

import static drivers.DriverHolder.getDriver;
import static pages.BasePage.captureScreenshot;

import static pages.P12_AddProductsincartPage.*;

public class TC12_AddProductsinCart extends BaseTest {

    @Test(priority = 1, description = "Add Products in Cart")
    public void addProudctsincart_P() {
        // TODO:Add Products in Cart

        new P12_AddProductsincartPage(getDriver()).clickonproductButton()
                .clickonAddtocartButtonforFirstProduct()
                .clickonconShopping()
                .clickonAddtocartButtonforsecondProduct()
                .clickonViewCart()
                .verifyPriceforFirstProduct()
                .verifyProductNameforFirstProduct()
                .verifyPriceforsecondtProduct()
                .verifyProductNameforSecondProduct();
        captureScreenshot(getDriver(), "Verify total Price and name of 2 products");
        Assert.assertEquals(actualPriceforFirstProduct, expectedPriceforFirstProduct, "Text does not match!");
        Assert.assertEquals(actualPriceforsecondtProduct, expectedPriceforsecondProduct, "Text does not match!");
        Assert.assertEquals(actualProductNameforFirstProduct, expectedProductNameforFirstProduct, "Text does not match!");
        Assert.assertEquals(actualProductNameforSecondProduct, expectedProductNameforSecondProduct, "Text does not match!");
    }
}