package com.automation.tests.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class configurationReader {

    private static Properties configFile;

    static {
        try {
            //location of properties file
            String path = System.getProperty("user.dir")+"/configuration.properties";
            //get that file as a stream
            FileInputStream input = new FileInputStream(path);
            //create object of Properties class
            configFile = new Properties();
            //load properties file into Properties object
            configFile.load(input);
            //close the input stream at the end
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }
    public static String getProperty(String keyName) {
        return configFile.getProperty(keyName);
    }
}
