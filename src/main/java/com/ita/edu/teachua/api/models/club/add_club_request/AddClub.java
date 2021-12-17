package com.ita.edu.teachua.api.models.club.add_club_request;

import java.util.List;

public class AddClub {
    private List<String> categoriesName;
    private String name;
    private Integer ageFrom;
    private Integer ageTo;
    private Object urlLogo;
    private Object urlBackground;
    private Boolean isOnline;
    private String description;
    private String userId;
    private List<Location> locations;
    private String contacts;
    private Integer centerId;

    public AddClub() {
    }

    /*public AddClub(List<String> categoriesName, String name, Integer ageFrom, Integer ageTo, Object urlLogo, Object urlBackground, Boolean isOnline, String description, String userId, List<Location> locations, String contacts, Integer centerId) {
        this.categoriesName = categoriesName;
        this.name = name;
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
        this.urlLogo = urlLogo;
        this.urlBackground = urlBackground;
        this.isOnline = isOnline;
        this.description = description;
        this.userId = userId;
        this.locations = locations;
        this.contacts = contacts;
        this.centerId = centerId;
    }*/

    public List<String> getCategoriesName() {
        return categoriesName;
    }

    public String getName() {
        return name;
    }

    public Integer getAgeFrom() {
        return ageFrom;
    }

    public Integer getAgeTo() {
        return ageTo;
    }

    public Object getUrlLogo() {
        return urlLogo;
    }

    public Object getUrlBackground() {
        return urlBackground;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public String getDescription() {
        return description;
    }

    public String getUserId() {
        return userId;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public String getContacts() {
        return contacts;
    }

    public Integer getCenterId() {
        return centerId;
    }
}
