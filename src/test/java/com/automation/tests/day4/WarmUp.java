package com.automation.tests.day4;

import com.automation.tests.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WarmUp {

    static WebDriver driver = DriverFactory.CreateADriver("chrome");


    public static void main(String[] args) throws InterruptedException {

        //This is the main method to call other functions

        ebayTest();
        amazonTest();
        wikiTest();


    }


    public static void ebayTest() throws InterruptedException {


        driver.get("http://www.ebay.com");
        WebElement elementName = driver.findElement(By.id("gh-btn"));
        elementName.sendKeys("java book");

        Thread.sleep(3000);

        driver.quit();

    }

    public static void amazonTest(){

    }

    public static void wikiTest(){

    }
}
