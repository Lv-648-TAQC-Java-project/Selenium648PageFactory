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

    public String getCitiesUrl() {
        return properties.getProperty("citiesUrl");
    }

    public String getCityUrl() {
        return properties.getProperty("cityUrl");
    }

    public String getFeedbackUrl() {
        return properties.getProperty("feedbackUrl");
    }

    public String getResetPasswordUrl() {
        return properties.getProperty("resetPasswordUrl");
    }

    public String getChallengeUrl() {
        return properties.getProperty("challengeUrl");
    }

    public String getDistrictClientUrl() {
        return properties.getProperty("districtClientUrl");
    }

    public String getCategoriesClientUrl() {
        return properties.getProperty("categoriesClientUrl");
    }

    public String getCenterClientUrl() {
        return properties.getProperty("centerClientUrl");

    }

    public String getDistrictsListUrl() {
        return properties.getProperty("districtsListUrl");
    }

    public String getAboutUsUrl() {
        return properties.getProperty("aboutUsUrl");
    }

    public String getContactUrl() {
        return properties.getProperty("contactUrl");
    }

    public String getStationUrl() {
        return properties.getProperty("stationUrl");
    }

    public String getBannerClientUrl() {
        return properties.getProperty("bannerClientUrl");
    }
    public String getBannersClientUrl() {
        return properties.getProperty("bannersClientUrl");
    }
}
