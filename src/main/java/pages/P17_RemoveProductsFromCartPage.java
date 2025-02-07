package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class P17_RemoveProductsFromCartPage extends BasePage {
    public P17_RemoveProductsFromCartPage(WebDriver driver) {
        super(driver);
    }

    // TODO: define locators using By
    private final By products_Button = By.xpath("//ul[@class='nav navbar-nav']//li//a[@href='/products']");
    private final By addtocartfirstproducts_Button = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[1]");
    private final By viewcart_Button = By.xpath("//u[normalize-space()='View Cart']");
    private final By deleteproduct_Button = By.xpath("//i[@class='fa fa-times']");
    private final By assertonProudcteRemoving_Text = By.xpath("//b[normalize-space()='Cart is empty!']");


    public static String AactualMsgremovingproduct;
    public static String expectedMsgremovingproduct = "Cart is empty!";

    // TODO: public action methods
    public P17_RemoveProductsFromCartPage clickonproductButton() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((products_Button))).click();
        return new P17_RemoveProductsFromCartPage(driver);
    }

    public P17_RemoveProductsFromCartPage clickonAddtocartButtonforProduct() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((addtocartfirstproducts_Button))).click();
        return new P17_RemoveProductsFromCartPage(driver);
    }

    public P17_RemoveProductsFromCartPage clickonViewCart() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((viewcart_Button))).click();
        return new P17_RemoveProductsFromCartPage(driver);
    }

    public P17_RemoveProductsFromCartPage deleteProduct() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((deleteproduct_Button))).click();
        return new P17_RemoveProductsFromCartPage(driver);
    }

    public P17_RemoveProductsFromCartPage verifythatproductisremovedfromthecart() {
        AactualMsgremovingproduct = shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assertonProudcteRemoving_Text))).getText();
        return new P17_RemoveProductsFromCartPage(driver);
    }

}