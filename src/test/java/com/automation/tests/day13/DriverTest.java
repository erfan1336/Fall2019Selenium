package com.automation.tests.day13;

import com.automation.tests.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverTest {

    @Test
    public void googleTest(){

        Driver.getDriver().get("http://www.google.com");
        Assert.assertEquals(Driver.getDriver().getTitle(),"Google");
        Driver.closeDriver();
    }
}
