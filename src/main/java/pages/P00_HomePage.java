package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class P00_HomePage extends BasePage {
    public P00_HomePage(WebDriver driver) {
        super(driver);
    }

    // TODO: define locators using By
    private final By assertionhomepage_text = By.xpath("//div[@class='item active']//span[1]");
    private final By login_singnup_Button = By.xpath("//a[normalize-space()='Signup / Login']");


    public static String expected_Messagefor_homepage = "Automation";
    public static String actualMessagefor_homepage;


    // TODO: public action methods
    public P00_HomePage verifythathomepageisvisiblesuccessfully() {
        actualMessagefor_homepage = shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((assertionhomepage_text))).getText();
        return new P00_HomePage(driver);
    }

    public P00_HomePage click_on_login_signUp_button() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((login_singnup_Button))).click();
        return new P00_HomePage(driver);

    }


}