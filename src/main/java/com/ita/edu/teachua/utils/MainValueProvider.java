package com.ita.edu.teachua.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MainValueProvider {
    Properties properties = new Properties();

    public MainValueProvider() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/data.properties");
        properties.load(fileInputStream);


    }

    public String getBaseApiUrl() {
        return properties.getProperty("baseApiUrl");
    }

    public String getSignInClientUrl() {
        return properties.getProperty("signInClientUrl");
    }

    public String getClubClientUrl() {
        return properties.getProperty("clubClientUrl");
    }

    public String getCategoryClientUrl() {
        return properties.getProperty("categoryClientUrl");
    }

    public String getCitiesUrl() {
        return properties.getProperty("citiesUrl");
    }

    public String getCityUrl() {
        return properties.getProperty("cityUrl");
    }

    public String getFeedbackUrl() {
        return properties.getProperty("feedbackUrl");
    }

}
