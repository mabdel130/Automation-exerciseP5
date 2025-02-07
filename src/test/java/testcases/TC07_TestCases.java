package testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.P07_TestCasesPage;

import static drivers.DriverHolder.getDriver;
import static pages.BasePage.captureScreenshot;

import static pages.P07_TestCasesPage.actualMessagefor_TestCases;
import static pages.P07_TestCasesPage.expected_Messagefor_TestCases;

public class TC07_TestCases extends BaseTest {

    @Test(priority = 1, description = " Verify user is navigated to test cases page successfully")
    public void verifyTestCases_P() {
        // TODO:VerifyTestCasesPage
        new P07_TestCasesPage(getDriver())
                .clickon_TetCases_button()
                .Verifyuserisnavigatedtotestcasespagesuccessfully();
        captureScreenshot(getDriver(), "user is navigated to test cases page");
        Assert.assertEquals(actualMessagefor_TestCases, expected_Messagefor_TestCases, "Text does not match!");

    }

}



