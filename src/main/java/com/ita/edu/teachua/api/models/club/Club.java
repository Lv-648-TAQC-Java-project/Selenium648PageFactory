package com.ita.edu.teachua.api.models.club;

import com.ita.edu.teachua.api.models.club.add_club.Category;
import com.ita.edu.teachua.api.models.club.add_club.Center;
import com.ita.edu.teachua.api.models.club.add_club.Location;
import com.ita.edu.teachua.api.models.club.add_club.User;

import java.util.List;

public class Club {
    private Integer id;
    private Integer ageFrom;
    private Integer ageTo;
    private String name;
    private String description;
    private Object urlWeb;
    private Object urlLogo;
    private Object urlBackground;
    private Object urlGallery;
    private Object workTime;
    private List<Category> categories;
    private User user;
    private Center center;
    private Object rating;
    private List<Location> locations;
    private Object isApproved;
    private Boolean isOnline;

    public Club(Integer id, Integer ageFrom, Integer ageTo, String name, String description, Object urlWeb, Object urlLogo, Object urlBackground, Object urlGallery, Object workTime, List<Category> categories, User user, Center center, Object rating, List<Location> locations, Object isApproved, boolean isOnline) {
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

    public Object getUrlWeb() {
        return urlWeb;
    }

    public Object getUrlLogo() {
        return urlLogo;
    }

    public Object getUrlBackground() {
        return urlBackground;
    }

    public Object getUrlGallery() {
        return urlGallery;
    }

    public Object getWorkTime() {
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

    public Object getRating() {
        return rating;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public Object getIsApproved() {
        return isApproved;
    }

    public boolean isOnline() {
        return isOnline;
    }

    @Override
    public String toString() {
        return "{\"Club\":{"
                + "\"id\":\"" + id + "\""
                + ", \"ageFrom\":\"" + ageFrom + "\""
                + ", \"ageTo\":\"" + ageTo + "\""
                + ", \"name\":\"" + name + "\""
                + ", \"description\":\"" + description + "\""
                + ", \"urlWeb\":" + urlWeb
                + ", \"urlLogo\":" + urlLogo
                + ", \"urlBackground\":" + urlBackground
                + ", \"urlGallery\":" + urlGallery
                + ", \"workTime\":" + workTime
                + ", \"categories\":" + categories
                + ", \"user\":" + user
                + ", \"center\":" + center
                + ", \"rating\":" + rating
                + ", \"locations\":" + locations
                + ", \"isApproved\":" + isApproved
                + ", \"isOnline\":\"" + isOnline + "\""
                + "}}";
    }
}
