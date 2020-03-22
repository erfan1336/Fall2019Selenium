package com.automation.tests;

import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWait {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.CreateADriver("chrome");

    }

    @Test
    public void waitForTitle(){

        driver.get("http://google.com");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        //wait up to 10 seconds until tile contains Google
        wait.until(ExpectedConditions.titleContains("Google"));

        driver.navigate().to("http://amazon.com");
        wait.until(ExpectedConditions.titleContains("Amazon"));


    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
