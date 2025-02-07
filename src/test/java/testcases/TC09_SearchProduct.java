package testcases;


import org.testng.Assert;
import org.testng.annotations.Test;


import pages.P09_SearchProductPage;


import static drivers.DriverHolder.getDriver;
import static pages.BasePage.captureScreenshot;
import static pages.P09_SearchProductPage.actualMessagefor_allproducts;
import static pages.P09_SearchProductPage.expected_Messagefor_allproducts;
import static pages.P09_SearchProductPage.actualMessagefor_SearchedProducts;
import static pages.P09_SearchProductPage.expected_Messagefor_SearchedProducts;

public class TC09_SearchProduct extends BaseTest {
    P09_SearchProductPage searchProductPage = new P09_SearchProductPage(getDriver());

    @Test(priority = 1, description = " SearchProduct")
    public void searchProducts_P() {
        // TODO:SearchProducts

        new P09_SearchProductPage(getDriver())
                .clickon_Products_button()
                .VerifyuserisnavigatedtoALLPRODUCTSpagesuccessfully();
        captureScreenshot(getDriver(), "Verify user is navigated to ALL PRODUCTS page successfully");
        Assert.assertEquals(actualMessagefor_allproducts, expected_Messagefor_allproducts, "Text does not match!");

        new P09_SearchProductPage(getDriver())
                .clickonSearchButton("Men")
                .clickonSearchButtonafteraddname()
                .VerifyforSearchedProducts();
        captureScreenshot(getDriver(), "VerifyforSearchedProducts");
        Assert.assertEquals(actualMessagefor_SearchedProducts, expected_Messagefor_SearchedProducts, "Text does not match!");


    }
}