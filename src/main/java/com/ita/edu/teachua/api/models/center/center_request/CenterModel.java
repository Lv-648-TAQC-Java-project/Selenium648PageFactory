package com.ita.edu.teachua.api.models.center.center_request;

import java.util.List;

public class CenterModel {
    private String name;
    private String description;
    private String userId;
    private String contacts;
    private List<Location> locations;
    private List<Integer> clubsId;

    public CenterModel(){}

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUserId() {
        return userId;
    }

    public String getContacts() {
        return contacts;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public List<Integer> getClubsId() {
        return clubsId;
    }
}
