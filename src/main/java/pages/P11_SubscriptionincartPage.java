package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class P11_SubscriptionincartPage extends BasePage {
    public P11_SubscriptionincartPage(WebDriver driver) {
        super(driver);
    }

    // TODO: define locators using By
    private final By cart_Button = By.xpath("//a[normalize-space()='Cart']");
    private final By assertonSubscr_Text = By.xpath("//h2[normalize-space()='Subscription']");
    private final By email_Text = By.xpath("//input[@id='susbscribe_email']");
    private final By clickarrow_Button = By.xpath("//i[@class='fa fa-arrow-circle-o-right']");
    private final By assertsuccessmessage_Text = By.xpath("//div[@class=\"alert-success alert\"]");

    public static String actualMessagefor_Subscription;
    public static String actualMessagefor_successmessage;

    // TODO: public action methods
    public P11_SubscriptionincartPage clickoncartButton() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((cart_Button))).click();
        return new P11_SubscriptionincartPage(driver);
    }

    public P11_SubscriptionincartPage VerifytextSUBSCRIPTION() {
        actualMessagefor_Subscription = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assertonSubscr_Text))).getText();
        return new P11_SubscriptionincartPage(driver);
    }

    public P11_SubscriptionincartPage enterEmailtosubscrip(String email) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((email_Text))).sendKeys(email);
        return new P11_SubscriptionincartPage(driver);
    }

    public P11_SubscriptionincartPage clickArrowButtontoconfirm() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((clickarrow_Button))).click();
        return new P11_SubscriptionincartPage(driver);
    }

    public P11_SubscriptionincartPage Verifysuccessmessage() {
        actualMessagefor_successmessage = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assertsuccessmessage_Text))).getText();
        return new P11_SubscriptionincartPage(driver);
    }

}