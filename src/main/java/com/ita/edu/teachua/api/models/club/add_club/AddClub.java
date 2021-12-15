package com.ita.edu.teachua.api.models.club.add_club;

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

    public AddClub(List<String> categoriesName, String name, int ageFrom, int ageTo, Object urlLogo, Object urlBackground, boolean isOnline, String description, String userId, List<Location> locations, String contacts, int centerId) {
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
    }

    public List<String> getCategoriesName() {
        return categoriesName;
    }

    public String getName() {
        return name;
    }

    public int getAgeFrom() {
        return ageFrom;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public Object getUrlLogo() {
        return urlLogo;
    }

    public Object getUrlBackground() {
        return urlBackground;
    }

    public boolean isOnline() {
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

    public int getCenterId() {
        return centerId;
    }

    @Override
    public String toString() {
        return "{\"AddClub\":{"
                + "\"categoriesName\":" + categoriesName
                + ", \"name\":\"" + name + "\""
                + ", \"ageFrom\":\"" + ageFrom + "\""
                + ", \"ageTo\":\"" + ageTo + "\""
                + ", \"urlLogo\":" + urlLogo
                + ", \"urlBackground\":" + urlBackground
                + ", \"isOnline\":\"" + isOnline + "\""
                + ", \"description\":\"" + description + "\""
                + ", \"userId\":\"" + userId + "\""
                + ", \"locations\":" + locations
                + ", \"contacts\":\"" + contacts + "\""
                + ", \"centerId\":\"" + centerId + "\""
                + "}}";
    }
}
