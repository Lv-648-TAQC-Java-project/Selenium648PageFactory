package com.ita.edu.teachua.api.models.club;

import java.util.List;

public class ClubRoot {
    private Integer id;
    private Integer ageFrom;
    private Integer ageTo;
    private String name;
    private String description;
    private String urlWeb;
    private String urlLogo;
    private String urlBackground;
    private List<UrlGallery> urlGallery;
    private String workTime;
    private List<Category> categories;
    private User user;
    private Center center;
    private Integer rating;
    private List<Location> locations;
    private Boolean isApproved;
    private Boolean isOnline;

    public ClubRoot() {
    }

    public ClubRoot(Integer id, Integer ageFrom, Integer ageTo, String name, String description, String urlWeb, String urlLogo, String urlBackground, List<UrlGallery> urlGallery, String workTime, List<Category> categories, User user, Center center, Integer rating, List<Location> locations, Boolean isApproved, Boolean isOnline) {
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
        this.categories = categories;
        this.user = user;
        this.center = center;
        this.rating = rating;
        this.locations = locations;
        this.isApproved = isApproved;
        this.isOnline = isOnline;
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

    public List<UrlGallery> getUrlGallery() {
        return urlGallery;
    }

    public String getWorkTime() {
        return workTime;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public User getUser() {
        return user;
    }

    public Center getCenter() {
        return center;
    }

    public Integer getRating() {
        return rating;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public Object getIsApproved() {
        return isApproved;
    }

    public Object getIsOnline() {
        return isOnline;
    }
}
