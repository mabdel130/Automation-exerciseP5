package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class P14_PlaceOrderRegisterwhileCheckoutPage extends BasePage {
    public P14_PlaceOrderRegisterwhileCheckoutPage(WebDriver driver) {
        super(driver);
    }


    // TODO: define locators using By
    private final By addtocart_Button = By.cssSelector("a[class='btn btn-default add-to-cart']");
    private final By clickonView_Button = By.xpath("//u[normalize-space()='View Cart']");
    private final By proceedToCheckout_Button = By.xpath("//a[normalize-space()='Proceed To Checkout']");
    private final By RegisterLogin_button = By.xpath("//u[normalize-space()='Register / Login']");
    private final By clickcart_Button = By.xpath("//a[normalize-space()='Cart']");
    private final By addmsg_Text = By.xpath("//textarea[@name='message']");
    private final By placeorder_Button = By.xpath("//a[normalize-space()='Place Order']");
    private final By nameoncard_Text = By.xpath(".//input[@name='name_on_card']");
    private final By cardnumber_Text = By.xpath("//input[@class=\"form-control card-number\"]");
    private final By cvc_Text = By.xpath("//input[@class=\"form-control card-cvc\"]");
    private final By expirationMonth_Text = By.xpath("//input[@class=\"form-control card-expiry-month\"]");
    private final By expirationYear_Text = By.xpath("//input[@class=\"form-control card-expiry-year\"]");
    private final By payandconfirmorderButton_Button = By.xpath("//button[@class=\"form-control btn btn-primary submit-button\"]");
    private final By delete_Button = By.xpath("//a[normalize-space()='Delete Account']");
    private final By conafterDeleteaccount_Button = By.xpath("//a[normalize-space()='Continue']");


    // TODO: public action methods
    public P14_PlaceOrderRegisterwhileCheckoutPage clickonAddtocartButton() {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((addtocart_Button))).click();
        return new P14_PlaceOrderRegisterwhileCheckoutPage(driver);
    }

    public P14_PlaceOrderRegisterwhileCheckoutPage clickonViewCartButton() {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((clickonView_Button))).click();
        driver.navigate().refresh();
        return new P14_PlaceOrderRegisterwhileCheckoutPage(driver);
    }

    public P14_PlaceOrderRegisterwhileCheckoutPage clickproceedToCheckoutButton() {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((proceedToCheckout_Button))).click();
        return new P14_PlaceOrderRegisterwhileCheckoutPage(driver);
    }

    public P14_PlaceOrderRegisterwhileCheckoutPage clickRegisterLoginButton() {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((RegisterLogin_button))).click();
        return new P14_PlaceOrderRegisterwhileCheckoutPage(driver);
    }

    public P14_PlaceOrderRegisterwhileCheckoutPage clickoncartButton() {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((clickcart_Button))).click();
        return new P14_PlaceOrderRegisterwhileCheckoutPage(driver);
    }

    public P14_PlaceOrderRegisterwhileCheckoutPage addcomment(String comment) {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((addmsg_Text))).sendKeys(comment);
        return new P14_PlaceOrderRegisterwhileCheckoutPage(driver);
    }

    public P14_PlaceOrderRegisterwhileCheckoutPage clickonPlaceorderButton() {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((placeorder_Button))).click();
        return new P14_PlaceOrderRegisterwhileCheckoutPage(driver);
    }

    public P14_PlaceOrderRegisterwhileCheckoutPage addnameoncard(String cardname) {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((nameoncard_Text))).sendKeys(cardname);
        return new P14_PlaceOrderRegisterwhileCheckoutPage(driver);
    }

    public P14_PlaceOrderRegisterwhileCheckoutPage addcardnumber(String cardnumber) {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((cardnumber_Text))).sendKeys(cardnumber);
        return new P14_PlaceOrderRegisterwhileCheckoutPage(driver);
    }

    public P14_PlaceOrderRegisterwhileCheckoutPage addCVC(String CVC) {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((cvc_Text))).sendKeys(CVC);
        return new P14_PlaceOrderRegisterwhileCheckoutPage(driver);
    }

    public P14_PlaceOrderRegisterwhileCheckoutPage addexpirationMonth(String expirationMonth) {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((expirationMonth_Text))).sendKeys(expirationMonth);
        return new P14_PlaceOrderRegisterwhileCheckoutPage(driver);
    }

    public P14_PlaceOrderRegisterwhileCheckoutPage addexpirationYear(String expirationYear) {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((expirationYear_Text))).sendKeys(expirationYear);
        return new P14_PlaceOrderRegisterwhileCheckoutPage(driver);
    }

    public P14_PlaceOrderRegisterwhileCheckoutPage clickonpayandconfirmorderButton() {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((payandconfirmorderButton_Button))).click();
        return new P14_PlaceOrderRegisterwhileCheckoutPage(driver);
    }

    public P14_PlaceOrderRegisterwhileCheckoutPage clicktodeleteMyaccount() {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((delete_Button))).click();
        return new P14_PlaceOrderRegisterwhileCheckoutPage(driver);
    }

    public P14_PlaceOrderRegisterwhileCheckoutPage clicktocontafterdeleteMyaccount() {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((conafterDeleteaccount_Button))).click();
        return new P14_PlaceOrderRegisterwhileCheckoutPage(driver);
    }
}
