package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.P18_ViewCategoryProductsPage;

import static drivers.DriverHolder.getDriver;
import static pages.BasePage.captureScreenshot;

import static pages.P18_ViewCategoryProductsPage.ActualCategory;
import static pages.P18_ViewCategoryProductsPage.expectedCategory;

public class TC18_ViewCategoryProducts extends BaseTest {

    @Test(priority = 1, description = "ViewCategoryProducts")
    public void ViewCategoryProducts_P() {
        // TODO:ViewCategoryProducts

        new P18_ViewCategoryProductsPage(getDriver())
                .Verifythatcategoriesarevisibleonleftsidebar();
        captureScreenshot(getDriver(), "verifythatViewCategoryProducts");
        Assert.assertEquals(ActualCategory, expectedCategory, "Text does not match!");

        new P18_ViewCategoryProductsPage(getDriver()).clickonWomenItem()
                .clickonSubWOMENItems();

    }
}