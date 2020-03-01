package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class myFirstSeleniumScript {

    public static void main(String[] args) throws InterruptedException {

        //setup chromedriver
        WebDriverManager.chromedriver().setup();
        //create chromedriver object
        ChromeDriver driver = new ChromeDriver();
        //open some website
        driver.get("http://google.com");

        driver.manage().window().maximize();//to maximize browser
        driver.manage().window().fullscreen();// to full screen
        Thread.sleep(3000);

        String title = driver.getTitle(); //returns <tile> Some Title </title> text
        System.out.println("Title is = " + title);

        String expectedTitle = "Google";
        if (expectedTitle.equals(title)){
            System.out.println("Test Passed!");
        }else
        {
            System.out.println("Test Fail");
        }

        //Go to Amazon website within same window
        driver.navigate().to("http://www.amazon.com");
        Thread.sleep(3000); //for demo, wait 3 seconds
        if (driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("Test passed for Amazon");
        }else {
            System.out.println("Test failed for Amazon");
        }

        //comeback to Google
        driver.navigate().back();
        Thread.sleep(3000);

        verifyEquals(driver.getTitle(),"Google");

        //Again, go forward back to Amazon
        driver.navigate().forward();
        Thread.sleep(3000);
        //Get Title
        System.out.println("Title = " + driver.getTitle());
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        driver.navigate().refresh();
        Thread.sleep(3000);

        //close at the end
        driver.close();// to close the browser
    }

    public static void verifyEquals(String arg1, String arg2){
        if (arg1.equals(arg2)){
            System.out.println("Test Passed!!");
        }else {
            System.out.println("Test Failed!!");
        }
    }
}
