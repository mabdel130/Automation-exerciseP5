package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class P04_LogoutUserPage extends BasePage {
    public P04_LogoutUserPage(WebDriver driver) {
        super(driver);
    }

    // TODO: define locators using By
    private final By assert_on_login_Text = By.xpath("//h2[normalize-space()='Login to your account']");
    private final By email_Text = By.xpath("//input[@data-qa='login-email']");
    private final By password_Text = By.xpath("//input[@placeholder='Password']");
    private final By submitlogin_Button = By.xpath("//button[normalize-space()='Login']");
    private final By logout_Button = By.xpath("//a[normalize-space()='Logout']");

    public static String actualMessagefor_login;
    public static String actualMessagefor_navigatedtologinpage;


    // TODO: public action methods
    public P04_LogoutUserPage Verify_login_to_ur_account_visible() {
        actualMessagefor_login = shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assert_on_login_Text))).getText();
        return new P04_LogoutUserPage(driver);

    }

    public P04_LogoutUserPage enterEmail_to_login(String email) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((email_Text))).sendKeys(email);
        return new P04_LogoutUserPage(driver);

    }

    public P04_LogoutUserPage enterPassword_to_login(String password) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((password_Text))).sendKeys(password);
        return new P04_LogoutUserPage(driver);
    }

    public P04_LogoutUserPage click_on_continue_to_login() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((submitlogin_Button))).click();
        return new P04_LogoutUserPage(driver);
    }

    public P04_LogoutUserPage click_on_LogoutButton() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((logout_Button))).click();
        return new P04_LogoutUserPage(driver);
    }

    public P04_LogoutUserPage Verifythatuserisnavigatedtologinpage() {
        actualMessagefor_navigatedtologinpage = shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assert_on_login_Text))).getText();
        return new P04_LogoutUserPage(driver);

    }
}