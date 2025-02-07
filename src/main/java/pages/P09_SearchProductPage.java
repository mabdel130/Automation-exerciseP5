package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class P09_SearchProductPage extends BasePage {
    public P09_SearchProductPage(WebDriver driver) {
        super(driver);
    }

    // TODO: define locators using By
    private final By products_Button = By.xpath("//a[@href='/products']");
    private final By assert_onallProducts_Text = By.xpath("//h2[normalize-space()='All Products']");
    private final By serach_Button = By.xpath("//input[@id='search_product']");
    private final By productContainer = By.xpath("//div[@class='features_items']");
    private final By productName = By.xpath(".//p");
    private final By productPrice = By.xpath(".//h2");
    private final By searcbuttonafteraddname_Button = By.xpath("//i[@class='fa fa-search']");

    private final By assert0nSearchProduct_Text = By.xpath("//h2[normalize-space()='Searched Products']");


    public static String expected_Messagefor_allproducts = "ALL PRODUCTS";
    public static String actualMessagefor_allproducts;


    public static String expected_Messagefor_SearchedProducts = "SEARCHED PRODUCTS";
    public static String actualMessagefor_SearchedProducts;


    // TODO: public action methods
    public P09_SearchProductPage clickon_Products_button() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((products_Button))).click();
        return new P09_SearchProductPage(driver);

    }

    public P09_SearchProductPage VerifyuserisnavigatedtoALLPRODUCTSpagesuccessfully() {
        actualMessagefor_allproducts = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assert_onallProducts_Text))).getText();
        return new P09_SearchProductPage(driver);
    }

    public P09_SearchProductPage clickonSearchButton(String Search_item) {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((serach_Button))).sendKeys(Search_item);

        return new P09_SearchProductPage(driver);
    }


    public P09_SearchProductPage clickonSearchButtonafteraddname() {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((searcbuttonafteraddname_Button))).click();
        return new P09_SearchProductPage(driver);
    }


    public P09_SearchProductPage VerifyforSearchedProducts() {
        actualMessagefor_SearchedProducts = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assert0nSearchProduct_Text))).getText();
        return new P09_SearchProductPage(driver);
    }

}
