package com.ita.edu.teachua.api.models.club.add_club_response;

import java.util.List;

public class Club {
    private Integer id;
    private Integer ageFrom;
    private Integer ageTo;
    private String name;
    private String description;
    private String urlWeb;
    private String urlLogo;
    private String urlBackground;
    private List<String> urlGallery;
    private String workTime;
    private Integer rating;
    private Integer feedbackCount;
    private Boolean isOnline;
    private List<String> locations;
    private List<String> categories;
    private User user;
    private String center;
    private Boolean isApproved;
    private String contacts;
    private Integer clubExternalId;
    private Integer centerExternalId;

    public Club() {
    }

    public Club(Integer id, Integer ageFrom, Integer ageTo, String name, String description, String urlWeb, String urlLogo, String urlBackground, List<String> urlGallery, String workTime, Integer rating, Integer feedbackCount, Boolean isOnline, List<String> locations, List<String> categories, User user, String center, Boolean isApproved, String contacts, Integer clubExternalId, Integer centerExternalId) {
        this.id = id;
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
        this.name = name;
        this.description = description;
        this.urlWeb = urlWeb;
        this.urlLogo = urlLogo;
        this.urlBackground = urlBackground;
        this.urlGallery = urlGallery;
        this.workTime = workTime;
        this.rating = rating;
        this.feedbackCount = feedbackCount;
        this.isOnline = isOnline;
        this.locations = locations;
        this.categories = categories;
        this.user = user;
        this.center = center;
        this.isApproved = isApproved;
        this.contacts = contacts;
        this.clubExternalId = clubExternalId;
        this.centerExternalId = centerExternalId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAgeFrom() {
        return ageFrom;
    }

    public Integer getAgeTo() {
        return ageTo;
    }

    public String getName() {
        return name;
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

    public String getUrlBackground() {
        return urlBackground;
    }

    public List<String> getUrlGallery() {
        return urlGallery;
    }

    public String getWorkTime() {
        return workTime;
    }

    public Integer getRating() {
        return rating;
    }

    public Integer getFeedbackCount() {
        return feedbackCount;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public List<String> getLocations() {
        return locations;
    }

    public List<String> getCategories() {
        return categories;
    }

    public User getUser() {
        return user;
    }

    public String getCenter() {
        return center;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public String getContacts() {
        return contacts;
    }

    public Integer getClubExternalId() {
        return clubExternalId;
    }

    public Integer getCenterExternalId() {
        return centerExternalId;
    }
}
