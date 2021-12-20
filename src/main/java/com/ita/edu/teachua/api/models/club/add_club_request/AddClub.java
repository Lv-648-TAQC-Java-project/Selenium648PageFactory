package com.ita.edu.teachua.api.models.club.add_club_request;

import lombok.Data;

import java.util.List;

@Data
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
}
