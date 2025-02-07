package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class P03_Login_User_with_inValid_Data_Page extends BasePage {
    public P03_Login_User_with_inValid_Data_Page(WebDriver driver) {
        super(driver);
    }

    // TODO: define locators using By
    private final By assert_on_login_Text = By.xpath("//h2[normalize-space()='Login to your account']");
    private final By email_Text = By.xpath("//input[@data-qa='login-email']");
    private final By password_Text = By.xpath("//input[@placeholder='Password']");
    private final By submitlogin_Button = By.xpath("//button[normalize-space()='Login']");
    private final By assertonerrorinurdat_Text = By.xpath("//p[normalize-space()='Your email or password is incorrect!']");

    public static String expected_Messagefor_login = "Login to your account";
    public static String actualMessagefor_login;

    public static String expected_Messagefor_errordata = "Your email or password is incorrect!";
    public static String actualMessagefor_errordata;

    // TODO: public action methods
    public P01_RegisterUserPage Verify_login_to_ur_account_visible() {
        actualMessagefor_login = shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assert_on_login_Text))).getText();
        return new P01_RegisterUserPage(driver);

    }

    public P03_Login_User_with_inValid_Data_Page enterEmail_to_login(String email) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((email_Text))).sendKeys(email);
        return new P03_Login_User_with_inValid_Data_Page(driver);

    }

    public P03_Login_User_with_inValid_Data_Page enterPassword_to_login(String password) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((password_Text))).sendKeys(password);
        return new P03_Login_User_with_inValid_Data_Page(driver);
    }

    public P03_Login_User_with_inValid_Data_Page click_on_continue_to_login() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((submitlogin_Button))).click();
        return new P03_Login_User_with_inValid_Data_Page(driver);
    }


    public P03_Login_User_with_inValid_Data_Page VerifyerrorYouremailorpasswordisincorrectisvisible() {
        actualMessagefor_errordata = shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assertonerrorinurdat_Text))).getText();
        return new P03_Login_User_with_inValid_Data_Page(driver);
    }

}
