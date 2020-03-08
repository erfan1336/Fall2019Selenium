package com.automation.tests.day6;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NoSelectDropdown {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.CreateADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        driver.findElement(By.id("dropdownMenuLink")).click(); //to expand dropdown menu
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Amazon")).click(); //select and click on option

        /**
         * From Selenium Perspective, there are 2 types of drop downs: Select and Other.
         * To handle select drop downs, use Select class from selenium. You can select by:
         * - text
         * - value(<option> value = <"smth">
         * - index
         */




        BrowserUtils.wait(2);
        driver.quit();
    }
}
