package com.ita.edu.teachua.api.models.club.add_club;

public class Location {
    public String name;
    public String cityName;
    public String districtName;
    public String stationName;
    public String address;
    public String coordinates;
    public String phone;
    public Double key;

    public Location() {
    }

    public Location(String name, String cityName, String districtName, String stationName, String address, String coordinates, String phone, Double key) {
        this.name = name;
        this.cityName = cityName;
        this.districtName = districtName;
        this.stationName = stationName;
        this.address = address;
        this.coordinates = coordinates;
        this.phone = phone;
        this.key = key;
    }
}
