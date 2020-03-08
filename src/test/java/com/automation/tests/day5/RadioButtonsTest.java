package com.automation.tests.day5;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonsTest {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.CreateADriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(2);

        WebElement blackButton = driver.findElement(By.id("black"));

        if (blackButton.isDisplayed() & blackButton.isEnabled()){
            System.out.println("Click on black button");
            blackButton.click();
        }else{
            System.out.println("failed to click on black button");
        }


        BrowserUtils.wait(2);
        if (blackButton.isSelected()){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }


        driver.quit();


    }
}
