package com.automation.tests.vytrack.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//STATIC IMPORT OF ALL ASSERTIONS
import java.security.PublicKey;

import static org.testng.Assert.*;

public class LoginPageTest {

    private WebDriver driver;
    //HTTPS is a secured version of http protocol
    //HTTP its hypertext transfer protocol that every single website is using now days

    //HTTPs - data encrypted, no chance for hackers to retrieve info
    //HTTP - data as a plain text, very easy to hack it
    private String URL = "http://qa2.vytrack.com/user/login";

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79.0").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void teardown(){
        //if Webdriver object alive
        if (driver != null){
            //close browser, close session
            driver.quit();
            //destroy driver object for sure
            driver = null;
        }
    }
}
