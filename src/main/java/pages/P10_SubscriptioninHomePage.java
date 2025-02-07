package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class P10_SubscriptioninHomePage extends BasePage {
    public P10_SubscriptioninHomePage(WebDriver driver) {
        super(driver);
    }

    // TODO: define locators using By
    private final By assertonSubscr_Text = By.xpath("//h2[normalize-space()='Subscription']");
    private final By email_Text = By.xpath("//input[@id='susbscribe_email']");
    private final By clickarrow_Button = By.xpath("//i[@class='fa fa-arrow-circle-o-right']");
private final By assertsuccessmessage_Text=By.xpath("//div[@class=\"alert-success alert\"]");





    public static String expectedMessagefor_Subscription = "SUBSCRIPTION";
    public static String actualMessagefor_Subscription;


    public static String actualMessagefor_successmessage;
    public static String expectedMessagefor_successmessage="You have been successfully subscribed!";



    // TODO: public action methods
    public P10_SubscriptioninHomePage VerifytextSUBSCRIPTION() {
        actualMessagefor_Subscription = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assertonSubscr_Text))).getText();
        return new P10_SubscriptioninHomePage(driver);
    }

    public P10_SubscriptioninHomePage enterEmailtosubscrip(String email) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((email_Text))).sendKeys(email);
        return new P10_SubscriptioninHomePage(driver);
    }
    public P10_SubscriptioninHomePage clickArrowButtontoconfirm() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((clickarrow_Button))).click();
        return new P10_SubscriptioninHomePage(driver);
    }
    public P10_SubscriptioninHomePage Verifysuccessmessage() {
        actualMessagefor_successmessage = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assertsuccessmessage_Text))).getText();
        return new P10_SubscriptioninHomePage(driver);
    }

}