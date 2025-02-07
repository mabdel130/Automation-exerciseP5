package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class P02_Login_User_with_Valid_Data_Page extends BasePage {
    public P02_Login_User_with_Valid_Data_Page(WebDriver driver) {
        super(driver);
    }

    // TODO: define locators using By
    private final By assert_on_login_Text = By.xpath("//h2[normalize-space()='Login to your account']");
    private final By email_Text = By.xpath("//input[@data-qa='login-email']");
    private final By password_Text = By.xpath("//input[@placeholder='Password']");
    private final By submitlogin_Button = By.xpath("//button[normalize-space()='Login']");
    private final By deleteAccount_Button = By.xpath("//a[normalize-space()='Delete Account']");
    private final By assert_Delete_Account = By.xpath("//b[normalize-space()='Account Deleted!']");
    private final By ContinueAfterdelete_Button = By.xpath("//a[normalize-space()='Continue']");


    public static String expected_Messagefor_login = "Login to your account";
    public static String actualMessagefor_login;

    public static String actualMessagefor_DeletedAccount_login;


    // TODO: public action methods
    public P02_Login_User_with_Valid_Data_Page Verify_login_to_ur_account_visible() {
        actualMessagefor_login = shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assert_on_login_Text))).getText();
        return new P02_Login_User_with_Valid_Data_Page(driver);

    }

    public P02_Login_User_with_Valid_Data_Page enterEmail_to_login(String email) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((email_Text))).sendKeys(email);
        return new P02_Login_User_with_Valid_Data_Page(driver);

    }

    public P02_Login_User_with_Valid_Data_Page enterPassword_to_login(String password) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((password_Text))).sendKeys(password);
        return new P02_Login_User_with_Valid_Data_Page(driver);
    }

    public P02_Login_User_with_Valid_Data_Page click_on_continue_to_login() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((submitlogin_Button))).click();
        return new P02_Login_User_with_Valid_Data_Page(driver);
    }

    public P02_Login_User_with_Valid_Data_Page click_on_deleteAccount() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((deleteAccount_Button))).click();
        return new P02_Login_User_with_Valid_Data_Page(driver);
    }

    public P02_Login_User_with_Valid_Data_Page Verify_that_ACCOUNT_DELETED_isvisible() {
        actualMessagefor_DeletedAccount_login = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assert_Delete_Account))).getText();
        return new P02_Login_User_with_Valid_Data_Page(driver);

    }

    public P02_Login_User_with_Valid_Data_Page click_on_Continue_button_AfterDelete() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((ContinueAfterdelete_Button))).click();
        return new P02_Login_User_with_Valid_Data_Page(driver);


    }


}
