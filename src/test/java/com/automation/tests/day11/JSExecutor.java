package com.automation.tests.day11;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        //return document.title --> is a javascript code
        //document --> represents HTML page
        String actualTitle = (String) js.executeScript("return document.title");

        Assert.assertEquals(actualTitle,expectedTitle);

        System.out.println("actualTitle = " + actualTitle);
        System.out.println("expectedTitle = " + expectedTitle);


    }

    @Test
    public void clickTest(){


        WebElement link = driver.findElement(By.linkText("Multiple Buttons"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click",link);

        BrowserUtils.wait(4);

       // WebElement button6 = driver.findElement(By.id("disappearing_button"));




    }










    @AfterMethod
    public void teardown(){
        driver.quit();
    }





}
