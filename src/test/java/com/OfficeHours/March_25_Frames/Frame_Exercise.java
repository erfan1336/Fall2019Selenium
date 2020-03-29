package com.OfficeHours.March_25_Frames;

import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Frame_Exercise {

    WebDriver driver = DriverFactory.CreateADriver("chrome");

    @Test
    public void test(){
        driver.get("http://practice.cybertekschool.com/nested_frames");
        driver.switchTo().frame("frame-top");
        List<WebElement> frameList = driver.findElements(By.xpath("//frame"));

        /*
            we have stored all frames webelements inside the list
            1. Loop through list
            2. switch to each frame
                a. get test from body
                b. switch to parent
         */

       // for (WebElement each : frameList){
            for (int i = 0; i < frameList.size(); i++){
            driver.navigate().refresh();

            driver.switchTo().frame(i);
            String bodyText = driver.findElement(By.xpath("//body")).getText();
            System.out.println("bodyText = " + bodyText);
            driver.switchTo().parentFrame();
        }
    }
}
