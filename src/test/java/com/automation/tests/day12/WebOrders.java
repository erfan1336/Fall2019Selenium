package com.automation.tests.day12;

import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebOrders {

    private WebDriver driver;


    @BeforeMethod
    public void setup(){
        driver = DriverFactory.CreateADriver("chrome");

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);
    }

    /**
     * Go to web orders page
     * Click on "Check All" button
     * Verify that all records are selected
     */

    @Test
    public void checkBoxTest(){



    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
