package com.automation.tests.day5;

import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrames {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/nested_frames");
        BrowserUtils.wait(4);

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        driver.switchTo().frame("frame-right");

        WebElement content = driver.findElement(By.id("content"));

        WebElement bodyText = driver.findElement(By.tagName("body"));
        System.out.println(bodyText.getText());

        System.out.println(content.getText());

        driver.quit();

    }
}
