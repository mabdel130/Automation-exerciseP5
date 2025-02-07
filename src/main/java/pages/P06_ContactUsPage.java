package pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class P06_ContactUsPage extends BasePage {
    public P06_ContactUsPage(WebDriver driver) {
        super(driver);
    }
    // TODO: define locators using By
    private final By contactUs_Button = By.xpath("//a[normalize-space()='Contact us']");
    private final By getintouch_Text = By.xpath("//h2[normalize-space()='Get In Touch']");

    private final By name_Text = By.xpath("//input[@placeholder='Name']");

    private final By email_Text = By.xpath("//input[@placeholder='Email']");
    private final By subject_Text = By.xpath("//input[@placeholder='Subject']");
    private final By myMasg_Text = By.xpath("//textarea[@id='message']");

    private final By upload_file_Button = By.xpath("//input[@name='upload_file']");

    private final By submit_Button = By.xpath("//input[@name='submit']");
    private final By successMsg_Text = By.xpath("//div[@class='status alert alert-success']");
    private final By home_Button = By.xpath("//span[normalize-space()='Home']");

    public static String expected_Messagefor_getintouch = "GET IN TOUCH";
    public static String actualMessagefor_getintouch;


    public static String expected_Messagefor_urDetails = "Success! Your details have been submitted successfully.";
    public static String actualMessagefor_rurDetails;

    // TODO: public action methods
    public P06_ContactUsPage clickon_Cotactus_button() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((contactUs_Button))).click();
        return new P06_ContactUsPage(driver);
    }

    public P06_ContactUsPage assertongetintouch_Text() {
        actualMessagefor_getintouch = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((getintouch_Text))).getText();
        return new P06_ContactUsPage(driver);
    }

    public P06_ContactUsPage entername(String name) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((name_Text))).sendKeys(name);
        return new P06_ContactUsPage(driver);
    }

    public P06_ContactUsPage enterEmail(String email) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((email_Text))).sendKeys(email);
        return new P06_ContactUsPage(driver);
    }

    public P06_ContactUsPage entersubject(String subject) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((subject_Text))).sendKeys(subject);
        return new P06_ContactUsPage(driver);
    }

    public P06_ContactUsPage enterMsg(String msg) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(myMasg_Text)).sendKeys(msg);
        return new P06_ContactUsPage(driver);
    }

    public P06_ContactUsPage clicktoUploadfile() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(upload_file_Button))
                .sendKeys("C:/Users/AbdELGhanyM1/Desktop/New Text Document.txt");
        return new P06_ContactUsPage(driver);
    }

    public P06_ContactUsPage clickSubmitButton() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(submit_Button)).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return new P06_ContactUsPage(driver);
    }

    public P06_ContactUsPage asserton_urDetails_Text() {
        actualMessagefor_rurDetails = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((successMsg_Text))).getText();
        return new P06_ContactUsPage(driver);
    }

    public P06_ContactUsPage click0nhomeButton() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(home_Button)).click();
        return new P06_ContactUsPage(driver);
    }

}
