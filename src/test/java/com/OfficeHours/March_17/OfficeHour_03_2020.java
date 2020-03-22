package com.OfficeHours.March_17;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.DriverFactory;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OfficeHour_03_2020 {

    public static void main(String[] args) {


        WebDriver driver = DriverFactory.CreateADriver("chrome");
        driver.get("http://qa3.vytrack.com");

        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));

        password.sendKeys("UserUser123");
        password.submit();


        WebElement contacts_link = driver.findElement(By.xpath("//span[.='Contacts']/following-sibling::a"));
        contacts_link.click();
        BrowserUtils.wait(3);





    }


}
