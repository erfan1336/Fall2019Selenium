package com.automation.tests.day6;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.CreateADriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        //Task #1 click on first button
        //##################################################################
        buttons.get(0).click(); //click on the first button
        BrowserUtils.wait(3);

        String popupText = driver.switchTo().alert().getText();//to get text from popup message
        System.out.println("popupText = " + popupText);

        driver.switchTo().alert().accept(); //to click ok

        BrowserUtils.wait(3);

        //Task #2: click on second button
        //###################################################################
        buttons.get(1).click();//to click on the 2nd button
        BrowserUtils.wait(3);
        driver.switchTo().alert().dismiss(); //click to cancel

        String expected2 = "You clicked: Ok";
        String actual2 = driver.findElement(By.id("result")).getText();

        if (expected2.equals(actual2)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
            System.out.println("expected2 = " + expected2);
            System.out.println("actual2 = " + actual2);
        }


        //Task: click on button #3
        //Enter some text:
        //Verify that result text:
        buttons.get(2).click();
        BrowserUtils.wait(2);
        Alert alert = driver.switchTo().alert();

        alert.sendKeys("Erfan Hamit");
        alert.accept();


        String expected3 = "Erfan Hamit";
        String actual3 = driver.findElement(By.id("result")).getText();

        if (expected3.equals(actual3)){
            System.out.println("you rock Erfan");
        }

        System.out.println(actual3);







        //Xpath samples :

        //   //button[text() = 'Click for JS Prompt']
        //   //button[@onclick = "jsPrompt()"]




        BrowserUtils.wait(3);
        driver.quit();
    }
}
