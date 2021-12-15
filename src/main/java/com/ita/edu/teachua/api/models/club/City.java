package com.ita.edu.teachua.api.models.club;

public class City{
    private Integer id;
    private String name;
    private Integer latitude;
    private Integer longitude;

    public City() {
    }

    public City(Integer id, String name, Integer latitude, Integer longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }
}