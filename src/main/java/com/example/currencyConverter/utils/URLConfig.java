package com.example.currencyConverter.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class URLConfig { // Class for loading properties from the configuration file
    private static final String BAD_FILE_MESSAGE = "Something wrong with properties file";
    private Properties properties = new Properties();

    public URLConfig() {
        try (FileInputStream input = new FileInputStream("src/main/resources/com/example/currencyConverter/app.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(BAD_FILE_MESSAGE, e);
        }
    }

    public String getApiUrl() {
        return properties.getProperty("api.url");
    }// Get the API URL from the configuration
}
