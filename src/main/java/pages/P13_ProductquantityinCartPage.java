package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class P13_ProductquantityinCartPage extends BasePage {
    public P13_ProductquantityinCartPage(WebDriver driver) {
        super(driver);
    }


    // TODO: define locators using By

    private final By viewProduct_Button = By.xpath("(//a[contains(text(),\'View Product\')])[1]");

    private final By addQuantity_Button = By.xpath("//input[@id='quantity']");

    private final By addtocart_Button = By.xpath("//button[normalize-space()='Add to cart']");

    private final By viewcart_Button = By.xpath("//u[normalize-space()='View Cart']");
    private final By assertonQuantity_Text = By.xpath("//button[normalize-space()='4']");


    public static String actualQuantity;
    public static String expectedQuantity = String.valueOf(4);

    // TODO: public action methods
    public P13_ProductquantityinCartPage clickonproductViewButton() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((viewProduct_Button))).click();
        return new P13_ProductquantityinCartPage(driver);
    }


    public P13_ProductquantityinCartPage click_to_addQuantity(String quantity) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((addQuantity_Button))).clear();
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((addQuantity_Button))).sendKeys(quantity);
        return new P13_ProductquantityinCartPage(driver);
    }

    public P13_ProductquantityinCartPage clickonaddtoButton() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((addtocart_Button))).click();
        return new P13_ProductquantityinCartPage(driver);
    }

    public P13_ProductquantityinCartPage clickonviewcartButton() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((viewcart_Button))).click();
        return new P13_ProductquantityinCartPage(driver);
    }


    public P13_ProductquantityinCartPage verifythatproductisdisplayedincartpagewithexactquantity() {
        actualQuantity = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assertonQuantity_Text))).getText();
        return new P13_ProductquantityinCartPage(driver);
    }

}
