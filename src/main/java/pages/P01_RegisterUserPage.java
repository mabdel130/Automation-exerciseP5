package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class P01_RegisterUserPage extends BasePage {
    // TODO: constructor to intailize webdriver.

    public P01_RegisterUserPage(WebDriver driver) {
        super(driver);
    }


    // TODO: define locators using By
    private final By assertnewuser_signup_Text = By.xpath("//h2[normalize-space()='New User Signup!']");
    private final By name_Text = By.xpath("//input[@placeholder='Name']");
    private final By email_Text = By.xpath("//input[@data-qa='signup-email']");
    private final By singnup_Button = By.xpath("//button[normalize-space()='Signup']");
    private final By assertAccountinforomation = By.xpath("//b[normalize-space()='Enter Account Information']");
    private final By titele_box = By.xpath("//input[@id='id_gender1']");
    private static final By nameofuser = By.xpath("//input[@id='name']");
    private final By password_Text = By.xpath("//input[@id='password']");
    private final By newsletter_Box = By.xpath("//input[@id='newsletter']");
    private final By optin_Box = By.xpath("//input[@id='optin']");
    private final By firstName_Text = By.xpath("//input[@id='first_name']");
    private final By lastName_Text = By.xpath("//input[@id='last_name']");
    private final By compeny_Text = By.xpath("//input[@id='company']");
    private final By address1_Text = By.xpath(" //input[@id='address1']");
    private final By address2_Text = By.xpath("//input[@id='address2']");
    private final By state_Text = By.xpath("//input[@id='state']");
    private final By city_Text = By.xpath("//input[@id='city']");
    private final By zipcode_Text = By.xpath("//input[@id='zipcode']");
    private final By mobile_Number_Text = By.xpath("//input[@id='mobile_number']");
    private final By crate_Account_Button = By.xpath("//button[normalize-space()='Create Account']");
    private final By assertAccountCreated = By.xpath("//b[normalize-space()='Account Created!']");
    private final By Continue_Button = By.xpath("//a[normalize-space()='Continue']");
    private final By deleteAccount_Button = By.xpath("//a[normalize-space()='Delete Account']");
    private final By assert_Delete_Account = By.xpath("//b[normalize-space()='Account Deleted!']");
    private final By ContinueAfterdelete_Button = By.xpath("//a[normalize-space()='Continue']");

    public static String expected_Messagefor_NewuserSignUp = "New User Signup!";
    public static String actualMessagefor_NewuserSignUp;


    public static String expected_Messagefor_Accountinformation = "ENTER ACCOUNT INFORMATION";
    public static String actualMessagefor_Accountinformation;


    public static String expected_Messagefor_AccountCreated = "ACCOUNT CREATED!";
    public static String actualMessagefor_AccountCreated;


    public static String expected_Messagefor_DeletedAccount = "ACCOUNT DELETED!";
    public static String actualMessagefor_DeletedAccount;
    // TODO: public action methods

    public P01_RegisterUserPage Verify_New_User_Signup_is_visible() {
        actualMessagefor_NewuserSignUp = shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assertnewuser_signup_Text))).getText();
        return new P01_RegisterUserPage(driver);

    }

    public P01_RegisterUserPage enterName(String name) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((name_Text))).sendKeys(name);
        return new P01_RegisterUserPage(driver);
    }

    public P01_RegisterUserPage enterEmail(String email) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((email_Text))).sendKeys(email);
        return new P01_RegisterUserPage(driver);

    }

    public P01_RegisterUserPage clicksignupbutton() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((singnup_Button))).click();
        return new P01_RegisterUserPage(driver);
    }


    public P01_RegisterUserPage Verifythat_ENTER_ACCOUNT_INFORMATION_is_visible() {
        actualMessagefor_Accountinformation = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assertAccountinforomation))).getText();
        return new P01_RegisterUserPage(driver);

    }

    public P01_RegisterUserPage click_on_title() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((titele_box))).click();
        return new P01_RegisterUserPage(driver);


    }

    public P01_RegisterUserPage enterNameofuser(String name) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((nameofuser))).sendKeys(name);
        return new P01_RegisterUserPage(driver);
    }

    public P01_RegisterUserPage enterPassword(String password) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((password_Text))).sendKeys(password);
        return new P01_RegisterUserPage(driver);
    }

    public P01_RegisterUserPage enterdateofBirthdayes(String dateofBirhe_dayes) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement dayDropdown = driver.findElement(By.xpath("//select[@id='days']"));
        js.executeScript("arguments[0].value='" + dateofBirhe_dayes + "';", dayDropdown);
        return new P01_RegisterUserPage(driver);
    }

    public P01_RegisterUserPage enterdateofBirthMonth(String dateofBirhe_Month) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement monthDropdown = driver.findElement(By.xpath("//select[@id='months']"));
        js.executeScript("arguments[0].value='" + dateofBirhe_Month + "';", monthDropdown);
        return new P01_RegisterUserPage(driver);
    }

    public P01_RegisterUserPage enterdateofBirth_Year(String dateofBirhe_year) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement yearDropdown = driver.findElement(By.xpath("//select[@id='years']"));
        js.executeScript("arguments[0].value='" + dateofBirhe_year + "';", yearDropdown);
        return new P01_RegisterUserPage(driver);
    }

    public P01_RegisterUserPage click_on_NewsLetter() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((newsletter_Box))).click();
        return new P01_RegisterUserPage(driver);


    }

    public P01_RegisterUserPage click_on_Optin() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((optin_Box))).click();
        return new P01_RegisterUserPage(driver);


    }

    public P01_RegisterUserPage enterfirstName(String firstname) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((firstName_Text))).sendKeys(firstname);
        return new P01_RegisterUserPage(driver);
    }

    public P01_RegisterUserPage enterlastName(String lastname) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((lastName_Text))).sendKeys(lastname);
        return new P01_RegisterUserPage(driver);
    }

    public P01_RegisterUserPage enterCompany(String company) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((compeny_Text))).sendKeys(company);
        return new P01_RegisterUserPage(driver);
    }

    public P01_RegisterUserPage enteraddress1(String address1) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((address1_Text))).sendKeys(address1);
        return new P01_RegisterUserPage(driver);
    }

    public P01_RegisterUserPage enteraddress2(String address2) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((address2_Text))).sendKeys(address2);
        return new P01_RegisterUserPage(driver);
    }

    public P01_RegisterUserPage selectcountery() {
        WebElement countryDropdown = driver.findElement(By.xpath("//select[@id='country']"));
        Select select = new Select(countryDropdown);
        List<WebElement> options = select.getOptions();
        if (options.size() > 1) {
            Random random = new Random();
            int randomIndex = random.nextInt(options.size());
            select.selectByIndex(randomIndex);

        }
        return new P01_RegisterUserPage(driver);
    }

    public P01_RegisterUserPage enterstate(String state) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((state_Text))).sendKeys(state);
        return new P01_RegisterUserPage(driver);
    }

    public P01_RegisterUserPage entercity(String city) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((city_Text))).sendKeys(city);
        return new P01_RegisterUserPage(driver);
    }

    public P01_RegisterUserPage enterzipcode(String zipcode) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((zipcode_Text))).sendKeys(zipcode);
        return new P01_RegisterUserPage(driver);
    }

    public P01_RegisterUserPage entermobile_Number(String mobile_Number) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((mobile_Number_Text))).sendKeys(mobile_Number);
        return new P01_RegisterUserPage(driver);
    }

    public P01_RegisterUserPage clickcrate_Account() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((crate_Account_Button))).click();
        return new P01_RegisterUserPage(driver);
    }

    public P01_RegisterUserPage Verifythat_ACCOUNT_CREATED_is_visible() {
        actualMessagefor_AccountCreated = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assertAccountCreated))).getText();
        return new P01_RegisterUserPage(driver);

    }

    public P01_RegisterUserPage click_on_continue() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((Continue_Button))).click();
        return new P01_RegisterUserPage(driver);
    }

    public P01_RegisterUserPage click_on_deleteAccount() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((deleteAccount_Button))).click();
        return new P01_RegisterUserPage(driver);
    }

    public P01_RegisterUserPage Verify_that_ACCOUNT_DELETED_isvisible() {
        actualMessagefor_DeletedAccount = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assert_Delete_Account))).getText();
        return new P01_RegisterUserPage(driver);

    }

    public P01_RegisterUserPage click_on_Continue_button_AfterDelete() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((ContinueAfterdelete_Button))).click();
        return new P01_RegisterUserPage(driver);


    }


}


