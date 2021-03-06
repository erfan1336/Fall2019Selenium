package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.Driver;
import com.automation.tests.vytrack.AbstractTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class NewLoginTests extends AbstractTestBase {


    @Test
    public void verifyPageTitle(){
        //We must add to every test at the beginning
        //test --> is coming from ExtentTest
        //test = report.createTest("Test name")
        test = report.createTest("Verify Page Title");
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        //like system.out buts its goes to report as well
        test.info("Login as store manager");//log some steps
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        //if assertion passed, it will set test status in report to passed
        test.pass("Page Title Dashboard was verified.");
    }

    /**
     * Enter wrong credentials and verify warning message
     *
     */

    @Test
    public void verifyWarningMessage(){

        test = report.createTest("warning message test");
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong", "wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(), "Invalid user name or password.");
        //take a screenshot
        BrowserUtils.getScreenshot("loginPage");
        test.pass("Warning message Test verified.");
    }



}
