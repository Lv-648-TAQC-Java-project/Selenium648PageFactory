package com.ita.edu.teachua.api.models.club;

import java.util.List;

public class Center{
    private Integer id;
    private String name;
    private String contacts;
    private String urlBackgroundPicture;
    private String description;
    private String urlWeb;
    private String urlLogo;
    private List<Location> locations;
    private List<Club> clubs;
    private User user;
    private Integer centerExternalId;
    private Integer rating;
    private Integer clubCount;

    public Center() {
    }

    public Center(Integer id, String name, String contacts, String urlBackgroundPicture, String description, String urlWeb, String urlLogo, List<Location> locations, List<Club> clubs, User user, Integer centerExternalId, Integer rating, Integer clubCount) {
        this.id = id;
        this.name = name;
        this.contacts = contacts;
        this.urlBackgroundPicture = urlBackgroundPicture;
        this.description = description;
        this.urlWeb = urlWeb;
        this.urlLogo = urlLogo;
        this.locations = locations;
        this.clubs = clubs;
        this.user = user;
        this.centerExternalId = centerExternalId;
        this.rating = rating;
        this.clubCount = clubCount;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContacts() {
        return contacts;
    }

    public String getUrlBackgroundPicture() {
        return urlBackgroundPicture;
    }

    public String getDescription() {
        return description;
    }

    public String getUrlWeb() {
        return urlWeb;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public User getUser() {
        return user;
    }

    public Integer getCenterExternalId() {
        return centerExternalId;
    }

    public Integer getRating() {
        return rating;
    }

    public Integer getClubCount() {
        return clubCount;
    }
}