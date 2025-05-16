package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P17_RemoveProductsFromCartPage;
import static drivers.DriverHolder.getDriver;
import static pages.BasePage.captureScreenshot;
import static pages.P17_RemoveProductsFromCartPage.AactualMsgremovingproduct;
import static pages.P17_RemoveProductsFromCartPage.expectedMsgremovingproduct;

public class TC17_RemoveProductsFromCart extends BaseTest {

    @Test(priority = 1, description = "Add Products in Cart")
    public void deleteProductfromcart_P() {
        // TODO:Add Products in Cart

        new P17_RemoveProductsFromCartPage(getDriver()).clickonproductButton()
                .clickonAddtocartButtonforProduct()
                .clickonViewCart();
        captureScreenshot(getDriver(), "Verify that cart page is displayed");
        new P17_RemoveProductsFromCartPage(getDriver())
                .deleteProduct()
                .verifythatproductisremovedfromthecart();
        captureScreenshot(getDriver(), "verifythatproductisremovedfromthecart");
        Assert.assertEquals(AactualMsgremovingproduct, expectedMsgremovingproduct, "Text does not match!");
    }
}