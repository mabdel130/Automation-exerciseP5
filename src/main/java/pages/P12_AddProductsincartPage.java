package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class P12_AddProductsincartPage extends BasePage {
    public P12_AddProductsincartPage(WebDriver driver) {
        super(driver);
    }

    // TODO: define locators using By
    private final By products_Button = By.xpath("//ul[@class='nav navbar-nav']//li//a[@href='/products']");
    private final By addtocartfirstproducts_Button = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[1]");
    private final By conShopping_Button = By.xpath("//button[normalize-space()='Continue Shopping']");
    private final By addtocartsecondproducts_Button = By.xpath("(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[3]");
    private final By viewcart_Button = By.xpath("//u[normalize-space()='View Cart']");
    private final By asserton_priceforFirstProduct_Text = By.xpath("//p[@class='cart_total_price'][normalize-space()='Rs. 500']");
    private final By assertonProductnameforFirstProduct_Text = By.xpath("//a[normalize-space()='Blue Top']");
    private final By asserton_priceforsecondProduct_Text = By.xpath("//p[@class='cart_total_price'][normalize-space()='Rs. 400']");
    private final By assertonProductnamefosecondProduct_Text = By.xpath("//a[normalize-space()='Men Tshirt']");



    public static String expectedProductNameforFirstProduct = "Blue Top";
    public static String expectedProductNameforSecondProduct = "Men Tshirt";


    public static String expectedPriceforFirstProduct = "Rs. 500";
    public static String expectedPriceforsecondProduct = "Rs. 400";

    public static String actualProductNameforFirstProduct;
    public static String actualProductNameforSecondProduct;

    public static String actualPriceforFirstProduct;
    public static String actualPriceforsecondtProduct;






    // TODO: public action methods
    public P12_AddProductsincartPage clickonproductButton() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((products_Button))).click();
        return new P12_AddProductsincartPage(driver);
    }

    public P12_AddProductsincartPage clickonAddtocartButtonforFirstProduct() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((addtocartfirstproducts_Button))).click();
        return new P12_AddProductsincartPage(driver);
    }

    public P12_AddProductsincartPage clickonconShopping() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((conShopping_Button))).click();
        return new P12_AddProductsincartPage(driver);
    }

    public P12_AddProductsincartPage clickonAddtocartButtonforsecondProduct() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((addtocartsecondproducts_Button))).click();
        return new P12_AddProductsincartPage(driver);
    }

    public P12_AddProductsincartPage clickonViewCart() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((viewcart_Button))).click();
        return new P12_AddProductsincartPage(driver);
    }

    public P12_AddProductsincartPage verifyProductNameforFirstProduct() {
        actualProductNameforFirstProduct = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assertonProductnameforFirstProduct_Text))).getText();
        return new P12_AddProductsincartPage(driver);
    }

    public P12_AddProductsincartPage verifyPriceforFirstProduct() {
        actualPriceforFirstProduct = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((asserton_priceforFirstProduct_Text))).getText();
        return new P12_AddProductsincartPage(driver);
    }

    public P12_AddProductsincartPage verifyProductNameforSecondProduct() {
        actualProductNameforSecondProduct = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assertonProductnamefosecondProduct_Text))).getText();
        return new P12_AddProductsincartPage(driver);
    }
    public P12_AddProductsincartPage verifyPriceforsecondtProduct() {
        actualPriceforsecondtProduct = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((asserton_priceforsecondProduct_Text))).getText();
        return new P12_AddProductsincartPage(driver);
    }

}