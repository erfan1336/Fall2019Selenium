package com.automation.tests.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    //same for everyone

    /**
     * from now on, Every single test will use same Webdriver object. It's shared, since its Static
     * Static belongs to class, not object
     */
    private static WebDriver driver;





    //make constructor private as below;
    //so no once can create object of Driver class
    //everyone should call static getter method instead
    private Driver(){
        //empty constructor;
    }

    public static WebDriver getDriver(){

        //if webdriver object doesn't exist, then create it
        if (driver == null){
            //specify browser type in configuration.properties file
            String browser = configurationReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().version("79").setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driver = new ChromeDriver();
                    break;
                case "chromeheadless":
                    //to run chrome without interface (headless mode)
                    WebDriverManager.chromedriver().version("79").setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Wrong Browser Name");
            }
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }


}
