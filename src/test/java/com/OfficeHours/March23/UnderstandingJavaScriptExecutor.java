package com.OfficeHours.March23;

import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class UnderstandingJavaScriptExecutor {


    @Test(description = "send text to search on etsy")
    public void test1(){

        WebDriver driver = DriverFactory.CreateADriver("chrome");
        driver.get("https://www.etsy.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('global-enhancements-search-query').value = 'send these characters'");

    }

}
