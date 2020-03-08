package com.automation.tests.day5;

import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iFrameTest {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtils.wait(3);

        //switch into frame
        driver.switchTo().frame("mce_0_ifr");

        WebElement inputText = driver.findElement(By.id("tinymce"));

        System.out.println(inputText.getText());
        BrowserUtils.wait(3);

        inputText.clear();
        inputText.sendKeys("Hello World & Erfan");

        BrowserUtils.wait(3);


        //exit from the frame
        driver.switchTo().defaultContent();

        WebElement heading = driver.findElement(By.tagName("h3"));
        System.out.println(heading.getText());


        driver.quit();
    }
}
