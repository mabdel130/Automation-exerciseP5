package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class P08_AllProductsandproductdetailPage extends BasePage {
    public P08_AllProductsandproductdetailPage(WebDriver driver) {
        super(driver);
    }

    // TODO: define locators using By
    private final By products_Button = By.xpath("//a[@href='/products']");
    private final By assert_onallProducts_Text = By.xpath("//h2[normalize-space()='All Products']");
    private final By asserton_ProductList_Text = By.xpath("//h2[normalize-space()='Category']");
    private final By selectFirstPeoduct_Button = By.xpath("(//a[contains(text(),'View Product')])[1]");
    private final By assertonProductname_Text = By.xpath("//h2[normalize-space()='Blue Top']");
    private final By assertonCategory_Text = By.xpath("//p[normalize-space()='Category: Women > Tops']");
    private final By asserton_price_Text = By.xpath("//span[normalize-space()='Rs. 500']");
    private final By asserton_Avilabilty_Text = By.xpath("//div[@class='product-details']//p[2]");
    private final By assertonconditions_Text = By.xpath("//body//section//p[3]");
    private final By assertonBrand_Text = By.xpath("//body//section//p[4]");


    public static String expected_Messagefor_allproducts = "ALL PRODUCTS";
    public static String actualMessagefor_allproducts;

    public static String expected_Messagefor_productList = "CATEGORY";
    public static String actualMessagefor_productList;

    public static String expectedProductName = "Blue Top";
    public static String expectedCategory = "Women > Tops";
    public static String expectedPrice = "Rs. 500";
    public static String expectedAvailability = "In Stock";
    public static String expectedCondition = "New";
    public static String expectedBrand = "Polo";

    public static String actualProductName;
    public static String actualCategory;
    public static String actualPrice;
    public static String actualAvailability;
    public static String actualCondition;
    public static String actualBrand;


    // TODO: public action methods
    public P08_AllProductsandproductdetailPage clickon_Products_button() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((products_Button))).click();
        return new P08_AllProductsandproductdetailPage(driver);

    }

    public P08_AllProductsandproductdetailPage VerifyuserisnavigatedtoALLPRODUCTSpagesuccessfully() {
        actualMessagefor_allproducts = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assert_onallProducts_Text))).getText();
        return new P08_AllProductsandproductdetailPage(driver);
    }

    public P08_AllProductsandproductdetailPage VerifyTheproductslistisvisible() {
        actualMessagefor_productList = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((asserton_ProductList_Text))).getText();
        return new P08_AllProductsandproductdetailPage(driver);
    }

    public P08_AllProductsandproductdetailPage selectFirstProduct() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(selectFirstPeoduct_Button)).click();
        return new P08_AllProductsandproductdetailPage(driver);

    }

    public P08_AllProductsandproductdetailPage verifyProductName() {
        actualProductName = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assertonProductname_Text))).getText();
        return new P08_AllProductsandproductdetailPage(driver);
    }

    public P08_AllProductsandproductdetailPage verifyCategory() {
        actualCategory = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assertonCategory_Text))).getText()
                .split(":")[1].trim();
        return new P08_AllProductsandproductdetailPage(driver);
    }

    public P08_AllProductsandproductdetailPage verifyPrice() {
        actualPrice = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((asserton_price_Text))).getText();
        return new P08_AllProductsandproductdetailPage(driver);
    }

    public P08_AllProductsandproductdetailPage verifyAvailability() {
        actualAvailability = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(asserton_Avilabilty_Text)).getText().split(":")[1].trim();
        return new P08_AllProductsandproductdetailPage(driver);
    }

    public P08_AllProductsandproductdetailPage verifyCondition() {
        actualCondition = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(assertonconditions_Text)).getText().split(":")[1].trim();
        return new P08_AllProductsandproductdetailPage(driver);
    }

    public P08_AllProductsandproductdetailPage verifyBrand() {
        actualBrand = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(assertonBrand_Text)).getText().split(":")[1].trim();
        return new P08_AllProductsandproductdetailPage(driver);
    }


}
