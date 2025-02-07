package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.P08_AllProductsandproductdetailPage;

import static drivers.DriverHolder.getDriver;
import static pages.BasePage.captureScreenshot;
import static pages.P08_AllProductsandproductdetailPage.*;

public class TC08_AllProductsandproductdetail extends BaseTest {

    @Test(priority = 1, description = " AllProductsandproductdetail")
    public void verifyAllProductsandproductdetail_P() {
        // TODO:verifyAllProductsandproductdetail

        new P08_AllProductsandproductdetailPage(getDriver())
                .clickon_Products_button()
                .VerifyuserisnavigatedtoALLPRODUCTSpagesuccessfully();

        captureScreenshot(getDriver(), "Verify user is navigated to ALL PRODUCTS page successfully");
        Assert.assertEquals(actualMessagefor_allproducts,expected_Messagefor_allproducts, "Text does not match!");

        new P08_AllProductsandproductdetailPage(getDriver())
                .VerifyTheproductslistisvisible();

        captureScreenshot(getDriver(), "VerifyTheproductslistisvisible");
        Assert.assertEquals(actualMessagefor_productList, expected_Messagefor_productList, "Text does not match!");

        new P08_AllProductsandproductdetailPage(getDriver())
                .selectFirstProduct()
                .verifyProductName()
                .verifyCategory()
                .verifyPrice()
                .verifyAvailability()
                .verifyCondition()
                .verifyBrand();

        captureScreenshot(getDriver(), "Verify Product details");

        Assert.assertEquals(actualProductName, expectedProductName, "Product name mismatch");
        Assert.assertEquals(actualCategory, expectedCategory, "Category mismatch");
        Assert.assertEquals(actualPrice, expectedPrice, "Price mismatch");
        Assert.assertEquals(actualAvailability, expectedAvailability, "Availability mismatch");
        Assert.assertEquals(actualCondition, expectedCondition, "Condition mismatch");
        Assert.assertEquals(actualBrand, expectedBrand, "Brand mismatch");
        System.out.println("All details are correct!");
    }
}