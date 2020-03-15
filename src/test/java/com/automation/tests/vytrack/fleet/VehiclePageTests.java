package com.automation.tests.vytrack.fleet;

import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VehiclePageTests {

    //In this task, will need to navigate to Fleet --> Vehicles and verify that page subtitle
    //is equals to "All Cars"

    private WebDriver driver;

    private String URL = "http://qa2.vytrack.com/user/login";

    //CREDENTIALS FOR STORE MANAGER
    private String username = "storemanager85";
    private String password = "UserUser123";

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    private By fleetBy = By.xpath("//span[@class = 'title title-level-1'and contains (text(),'Fleet')]");

    private By subtitle = By.className("oro-subtitle");

    @Test
    public void verifyPageSubTitle(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);

        BrowserUtils.wait(5);


        //Click on fleet
        //driver.findElement(fleetBy).click();

        //Actions class is used for more advanced browser interactions
        Actions actions = new Actions(driver);
        //below method, instead of clicking we will use move to other element
        BrowserUtils.wait(4);
        actions.moveToElement(driver.findElement(fleetBy)).perform();
        BrowserUtils.wait(2);

        //Click on Vehicles
        driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtils.wait(5);

        //find subtitle Element
        WebElement subtitleElement = driver.findElement(subtitle);
        System.out.println(subtitleElement.getText());
    }


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
