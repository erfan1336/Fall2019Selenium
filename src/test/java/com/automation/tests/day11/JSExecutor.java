package com.automation.tests.day11;

import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
      driver = DriverFactory.CreateADriver("chrome");
      driver.get("http://practice.cybertekschool.com/");
      driver.manage().window().maximize();
    }


    @Test
    public void verifyTitle(){

        String expectedTitle = "Practice";
        //create javascript object by casting webdrive object
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //executeScript -> this method executes javascript code
        //we provide js code as a string
        String actualTitle = (String) js.executeScript("return document.title");

        Assert.assertEquals(actualTitle,expectedTitle);


    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }





}
