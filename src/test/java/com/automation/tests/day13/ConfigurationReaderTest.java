package com.automation.tests.day13;

import com.automation.tests.utilities.configurationReader;
import org.testng.annotations.Test;

public class ConfigurationReaderTest {

    @Test
    public void readProperties(){

        String browser = configurationReader.getProperty("browser");
        String url = configurationReader.getProperty("qa1");
        String color = configurationReader.getProperty("color");
        String version = configurationReader.getProperty("java.version");


        System.out.println(browser);
        System.out.println(url);
        System.out.println(color);
        System.out.println("version = " + version);

        String storeManager = configurationReader.getProperty("store_manager");
        String password = configurationReader.getProperty("password");

        System.out.println("storeManager = " + storeManager);
        System.out.println("password = " + password);

    }
}
