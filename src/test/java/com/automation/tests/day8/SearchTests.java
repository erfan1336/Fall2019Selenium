package com.automation.tests.day8;

import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {

    private WebDriver driver;

    @Test
    public void googleSearchTest(){
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Java", Keys.ENTER);
        BrowserUtils.wait(3);

        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
        for (WebElement searchItem : searchItems){
            String var = searchItem.getText();
            if (!var.isEmpty()){
                System.out.println(searchItem.getText());
                //verify that every search result contains java word
                Assert.assertTrue(var.toLowerCase().contains("java"));
                System.out.println(var.toLowerCase());
                System.out.println();
            }
        }
    }

    /**
     * Given user is on the amazon.com page
     * when user enters java as a search item
     * Then user clicks on the search button
     * And user clicks on the first search item
     * Then verify
     *
     */
    @Test(description = "Search for Java book on amazon")
    public void amazonSearchTest(){

        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java",Keys.ENTER);
        BrowserUtils.wait(3);

        List<WebElement> searchItems = driver.findElements(By.xpath("//h2//a"));

        for (WebElement searchItem : searchItems){
            System.out.println(searchItem.getText());
        }

        //click on the first item
        searchItems.get(0).click();
        BrowserUtils.wait(3);

        WebElement productTitle = driver.findElement(By.id("title"));
        String productTitleString = productTitle.getText();
        System.out.println("=======================================");
        System.out.println("Here is the Title: " + productTitleString);

        Assert.assertTrue(productTitleString.contains("Java"));

        



    }

    @BeforeMethod
    public void setup(){
        //setup Webdriver
        WebDriverManager.chromedriver().version("79.0").setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown(){
        //close browser and destroy Webdriver Object
        driver.quit();
    }
}
