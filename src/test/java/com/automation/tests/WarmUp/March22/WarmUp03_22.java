package com.automation.tests.WarmUp.March22;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WarmUp03_22 {

    @Test
    public void test(){
        WebDriver driver = DriverFactory.CreateADriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.findElement(By.xpath("//table[1]//*[text()='Last Name']")).click();
        BrowserUtils.wait(3);

        //collect all the values from the first column
        List<WebElement> column = driver.findElements(By.xpath("//table[1]//tbody//td[1]"));

        for (int i = 0; i < column.size() - 1; i++){
            String value = column.get(i).getText();
            String nextValue = column.get(i+1).getText();

            Assert.assertTrue(value.compareTo(nextValue) <= 0);

            System.out.println(value.compareTo(nextValue));
        }
        driver.quit();



    }
}
