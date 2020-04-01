package com.automation.tests.vytrack.activities;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalendarEventsPageTests {

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private WebDriver driver;
    private Actions actions;

    private String storeManagerUserName = "storemanager85";
    private String storeManagerPassword = "UserUser123";
    private By activitiesBy = By.xpath("//span[@class = 'title title-level-1' and contains(text(),'Activities')]");
    private By createCalendarEventBtnBy = By.cssSelector("a[title='Create Calendar event']");
    private By currentUserBy = By.cssSelector("#user-menu > a");
    private By ownerBy = By.id("s2id_oro_calendar_event_form_calendar");
    private By titleName = By.cssSelector("[name = 'oro_calendar_event_form[title]']");
    private By startDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start']");
    private By startTime = By.cssSelector("[id*='time_selector_oro_calendar_event_form_start']");

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.CreateADriver("chrome");
        driver.get("http://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        actions = new Actions(driver);

        BrowserUtils.wait(2);

        BrowserUtils.wait(3);
        driver.findElement(usernameBy).sendKeys(storeManagerUserName);
        driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);
        BrowserUtils.wait(5);

        //hover over Activities
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);

        driver.findElement(By.linkText("Calendar Events")).click();

        BrowserUtils.wait(5);

    }


    @Test
    public void verifyCreateButton(){
        WebElement createCalendarEventBtn = driver.findElement(createCalendarEventBtnBy);
        Assert.assertTrue(createCalendarEventBtn.isDisplayed());
    }

    @Test(description = "Default options")
    public void verifyDefaultValues(){
        //Click on Create Calendar Event
        driver.findElement(createCalendarEventBtnBy).click();
        BrowserUtils.wait(3);

        String currentUserName = driver.findElement(currentUserBy).getText();
        String defaultOwnerName = driver.findElement(ownerBy).getText();

        Assert.assertEquals(currentUserName,defaultOwnerName);

        //Default title should be blank
        WebElement titleElement = driver.findElement(titleName);
        Assert.assertTrue(titleElement.getAttribute("value").isEmpty());


    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }


}
