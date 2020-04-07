package com.automation.tests.vytrack;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.Driver;
import com.automation.tests.utilities.configurationReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public abstract class AbstractTestBase {

    //will be visible in the subclass, regardless on subclass location (same package or no)
    protected WebDriverWait wait;
    protected Actions actions;
    private configurationReader ConfigurationReader;

    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;

    @BeforeTest
    @Parameters("reportName")

    public void setupTest(@Optional String reportName){

        System.out.println("Report name:" +reportName);

        report = new ExtentReports();
        reportName = reportName == null? "report.html" : reportName + ".html";

        String reportPath = "";
        //location of report file
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            reportPath = System.getProperty("user.dir") + "\\test-output\\" + reportName;
        } else {
            reportPath = System.getProperty("user.dir") + "/test-output/" + reportName;
        }


        //is a HTML report itself
        htmlReporter = new ExtentHtmlReporter(reportPath);
        //add it to the reporter
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("VYTRACK TEST Automation Results");

    }

    @AfterTest
    public void afterTest(){
        report.flush();  //to release a report
    }


    @BeforeMethod
    public void setup(){
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 15);
        actions = new Actions(Driver.getDriver());
    }


    @AfterMethod
    public void teardown(ITestResult iTestResult) throws IOException {
        //ItestResult class describes the result of a test.
        //if test failed, take a screenshot
        if (iTestResult.getStatus() == ITestResult.FAILURE){
            //screenshot will have name of the test
            String screenshotPath = BrowserUtils.getScreenshot(iTestResult.getName());
            test.fail(iTestResult.getName());//attach test name that failed
            BrowserUtils.wait(2);
            test.addScreenCaptureFromPath(screenshotPath,"Failed");//attach screenshot
            test.fail(iTestResult.getThrowable());//attach console output
        }
        BrowserUtils.wait(2);
        Driver.closeDriver();
    }
}
