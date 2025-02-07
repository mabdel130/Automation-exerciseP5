package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class P07_TestCasesPage extends BasePage {
    public P07_TestCasesPage(WebDriver driver) {
        super(driver);
    }

    // TODO: define locators using By
    private final By testcases_Button = By.xpath("//a[contains(text(),'Test Cases')]");

    private final By asserton_TestCases_Button = By.xpath("//b[normalize-space()='Test Cases']");

    public static String expected_Messagefor_TestCases = "TEST CASES";
    public static String actualMessagefor_TestCases;


    // TODO: public action methods
    public P07_TestCasesPage clickon_TetCases_button() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated((testcases_Button))).click();
        return new P07_TestCasesPage(driver);

    }

    public P07_TestCasesPage Verifyuserisnavigatedtotestcasespagesuccessfully() {
        actualMessagefor_TestCases = longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((asserton_TestCases_Button))).getText();
        return new P07_TestCasesPage(driver);

    }
}