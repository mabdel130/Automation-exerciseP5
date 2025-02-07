package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_RegisterUserPage;

import static drivers.DriverHolder.getDriver;
import static pages.BasePage.captureScreenshot;
import static pages.P01_RegisterUserPage.*;
import static util.Utlity.*;

public class TC01_Register_User extends BaseTest {
    static String name = generateRandomFullName();
    static String email = generateDynamicEmail();
    static String password = generateDynamicPassword();
    static String dateofBirhe_dayes = String.valueOf(generateRandomDay(2000, 10));
    static String dateofBirhe_Month = String.valueOf(generateRandomMonth());
    static String dateofBirhe_year = String.valueOf(generateRandomYear(1950, 2025));
    static String firstname = generateRandomFirstName();
    static String lastname = generateRandomLastName();
    static String company = generateRandomCompanyName();
    static String address1 = generateRandomAddress();
    static String address2 = generateRandomAddress();
    static String state = generateRandomState();
    static String city = generateRandomCity();
    static String zipcode = generateRandomPostalCode();
    static String mobile_Number = generateEgyptianPhoneNumber();

    @Test(priority = 1, description = "Register User")
    public void register_User_withvalidData_p() {
        // TODO: register_User
        new P01_RegisterUserPage(getDriver())
                .Verify_New_User_Signup_is_visible();
        captureScreenshot(getDriver(), "NewuserSignUp");
        Assert.assertEquals(actualMessagefor_NewuserSignUp, expected_Messagefor_NewuserSignUp, "Text does not match!");
        new P01_RegisterUserPage(getDriver())
                .enterName(name)
                .enterEmail(email)
                .clicksignupbutton()
                .Verifythat_ENTER_ACCOUNT_INFORMATION_is_visible();
        captureScreenshot(getDriver(), "AccountInformationtTEXT");
        Assert.assertEquals(actualMessagefor_Accountinformation, expected_Messagefor_Accountinformation, "Text does not match!");
        new P01_RegisterUserPage(getDriver())
                .click_on_title()
                .enterNameofuser(name)
                .enterPassword(password)
                .enterdateofBirthdayes(dateofBirhe_dayes)
                .enterdateofBirthMonth(dateofBirhe_Month)
                .enterdateofBirth_Year(dateofBirhe_year)
                .click_on_NewsLetter()
                .click_on_Optin()
                .enterfirstName(firstname)
                .enterlastName(lastname)
                .enterCompany(company)
                .enteraddress1(address1)
                .enteraddress2(address2)
                .selectcountery()
                .enterstate(state)
                .entercity(city)
                .enterzipcode(zipcode)
                .entermobile_Number(mobile_Number)
                .clickcrate_Account()
                .Verifythat_ACCOUNT_CREATED_is_visible();
        captureScreenshot(getDriver(), "AccountCreated");
        Assert.assertEquals(actualMessagefor_AccountCreated, expected_Messagefor_AccountCreated, "Text does not match!");
        new P01_RegisterUserPage(getDriver())
                .click_on_continue();
    }

    @Test(priority = 2, description = " delete Register User")
    public void delete_register_User_withvalidData_p() {
        new P01_RegisterUserPage(getDriver())
                .click_on_deleteAccount()
                .Verify_that_ACCOUNT_DELETED_isvisible();
        captureScreenshot(getDriver(), "AccountDeleted");
        Assert.assertEquals(actualMessagefor_DeletedAccount, expected_Messagefor_DeletedAccount, "Text does not match!");
        new P01_RegisterUserPage(getDriver()).click_on_Continue_button_AfterDelete();

    }
}

