package com.automation.tests.day6;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByValue {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.CreateADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        Select stateSelect = new Select(driver.findElement(By.id("state")));

        stateSelect.selectByValue("DC");

        String expected = "District of Columbia";
        String actual = stateSelect.getFirstSelectedOption().getText();

        if (expected.equalsIgnoreCase(actual)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }









        BrowserUtils.wait(3);
        driver.quit();
    }
}
