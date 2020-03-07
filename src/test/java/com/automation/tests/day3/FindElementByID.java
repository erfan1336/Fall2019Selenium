package com.automation.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementByID {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");

        Thread.sleep(3000);

        //driver.findElement(By.name("password")).sendKeys("SuperSecretPassword"); // we can also do it this way

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");

        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(3000);


        //let's click on Logout Button,
        //every element with <a> tag is a link
        //if you have couple spaces in the text, just use partialLinkText instead of linkText
        //linkText - equals()
        //partialLinkText - contains()

        WebElement logout = driver.findElement(By.linkText("Logout"));
        String href= logout.getAttribute("href");
        String className = logout.getAttribute("class");
        System.out.println("href = " + href);
        System.out.println("className = " + className);

        logout.click();
        Thread.sleep(3000);

        driver.quit();



    }
}
