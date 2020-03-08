package com.automation.tests.day4;

import com.automation.tests.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WarmUp {

    static WebDriver driver = DriverFactory.CreateADriver("chrome");


    public static void main(String[] args) throws InterruptedException {

        //This is the main method to call other functions
        //ebayTest();

        //amazonTest();
        wikiTest();


    }


    public static void ebayTest() throws InterruptedException {

        driver.get("http://www.ebay.com");
        WebElement elementName = driver.findElement(By.id("gh-ac"));
        elementName.sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();
        WebElement searchResults = driver.findElement(By.tagName("h1"));

        System.out.println("searchResults = " + searchResults);
        System.out.println("searchResults = " + searchResults.getText());
        System.out.println(searchResults.getText().split(" ")[0]);

        //another way to store as String, then print out
        String[] search = searchResults.getText().split(" ");
        search.toString();
        System.out.println(search[0]);


        System.out.println("searchResults.getLocation() = " + searchResults.getLocation());
       // System.out.println("searchResults.getCssValue() = " + searchResults.getCssValue());

        Thread.sleep(3000);

        driver.quit();

    }

    public static void amazonTest(){

        driver.get("http://www.amazon.com");
        WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
        element.sendKeys("coffee", Keys.ENTER);

        String title = driver.getTitle();

        if (title.contains("coffee")){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }


        driver.quit();

    }

    public static void wikiTest(){

        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.id("searchInput")).sendKeys("Selenium software",Keys.ENTER);
        String URL = driver.getCurrentUrl();
        System.out.println("URL = " + URL);

        if (URL.endsWith("Selenium_software")){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }

        driver.quit();


    }
}
