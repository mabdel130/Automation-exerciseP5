package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class P05_RegisterUsewithexistingemailPage extends BasePage{
    public P05_RegisterUsewithexistingemailPage(WebDriver driver) {
        super(driver);
    }

    // TODO: define locators using By
    private final By assertnewuser_signup_Text = By.xpath("//h2[normalize-space()='New User Signup!']");
    private final By name_Text = By.xpath("//input[@placeholder='Name']");
    private final By email_Text = By.xpath("//input[@data-qa='signup-email']");
    private final By singnup_Button = By.xpath("//button[normalize-space()='Signup']");
private final By assertonEmailAddressalreadyexist_Text=By.xpath("//p[normalize-space()='Email Address already exist!']");


    public static String actualMessagefor_NewuserSignUp;


    public static String expected_Messagefor_Emailalreadyexist="Email Address already exist!";
    public static String actualMessagefor_Emailalreadyexist;




    // TODO: public action methods
    public P05_RegisterUsewithexistingemailPage Verify_New_User_Signup_is_visible() {
        actualMessagefor_NewuserSignUp = shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assertnewuser_signup_Text))).getText();
        return new P05_RegisterUsewithexistingemailPage(driver);

    }

    public P05_RegisterUsewithexistingemailPage enterName(String name) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((name_Text))).sendKeys(name);
        return new P05_RegisterUsewithexistingemailPage(driver);
    }

    public P05_RegisterUsewithexistingemailPage enterEmail(String email) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((email_Text))).sendKeys(email);
        return new P05_RegisterUsewithexistingemailPage(driver);

    }

    public P05_RegisterUsewithexistingemailPage clicksignupbutton() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((singnup_Button))).click();
        return new P05_RegisterUsewithexistingemailPage(driver);
    }



    public P05_RegisterUsewithexistingemailPage VerifyerrorEmailAddressalreadyexistisvisible() {
        actualMessagefor_Emailalreadyexist=longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assertonEmailAddressalreadyexist_Text))).getText();
        return new P05_RegisterUsewithexistingemailPage(driver);
    }
    
}
