package com.ita.edu.teachua.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ValueProvider {
    Properties properties = new Properties();

    public ValueProvider() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/data.properties");
        properties.load(fileInputStream);
    }

    public String getBaseUrl() {
        return properties.getProperty("baseURL");
    }

    public String getAdminPassword() {
        return properties.getProperty("adminPassword");
    }

    public String getAdminEmail() {
        return properties.getProperty("adminEmail");
    }
}
