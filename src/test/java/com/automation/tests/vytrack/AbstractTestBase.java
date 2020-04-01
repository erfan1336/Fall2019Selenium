package com.automation.tests.vytrack;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.Driver;
import com.automation.tests.utilities.configurationReader;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractTestBase {

    //will be visible in the subclass, regardless on subclass location (same package or no)
    protected WebDriverWait wait;
    protected Actions actions;
    private configurationReader ConfigurationReader;

    @BeforeMethod
    public void setup(){
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 15);
        actions = new Actions(Driver.getDriver());
    }


    @AfterMethod
    public void teardown(ITestResult iTestResult){
        //ItestResult class describes the result of a test.
        //if test failed, take a screenshot
        if (iTestResult.getStatus() == ITestResult.FAILURE){
            BrowserUtils.getScreenshot(iTestResult.getName());
        }
        Driver.closeDriver();
    }
}
