package com.ita.edu.teachua.api.models.center.center_response;

import java.util.List;

public class CenterRoot {
    private int id;
    private int userId;
    private String name;
    private Object email;
    private Object phones;
    private String description;
    private Object urlWeb;
    private Object urlLogo;
    private String contacts;
    private List<Locations> locations;

    private CenterRoot(){}

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Object getEmail() {
        return email;
    }

    public Object getPhones() {
        return phones;
    }

    public String getDescription() {
        return description;
    }

    public Object getUrlWeb() {
        return urlWeb;
    }

    public Object getUrlLogo() {
        return urlLogo;
    }

    public String getContacts() {
        return contacts;
    }

    public List<Locations> getLocations() {
        return locations;
    }
}
