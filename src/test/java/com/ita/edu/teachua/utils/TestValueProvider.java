package com.ita.edu.teachua.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestValueProvider {
    Properties properties = new Properties();

    public TestValueProvider() throws IOException {
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

    public String getManagerEmail() {
        return properties.getProperty("managerRoleEmail");
    }
    public String getManagerPassword() {
        return properties.getProperty("managerRolePassword");
    }

    public String getUserEmail() {
        return properties.getProperty("userRoleEmail");
    }
    public String getUserPassword() {
        return properties.getProperty("userRolePassword");
    }

    public String getTestTeachUaMetaEmail() {
        return properties.getProperty("TestTeachUaMetaEmail");
    }
    public String getTestTeachUaMetaPassword() {
        return properties.getProperty("TestTeachUaMetaPassword");
    }
}
