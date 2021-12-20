package com.ita.edu.teachua.api.models.center.center_request;

public class Location {
    private String name;
    private String cityName;
    private String districtName;
    private String stationName;
    private String address;
    private String coordinates;
    private String phone;
    private double key;

    public Location(){}

    public String getName() {
        return name;
    }

    public String getCityName() {
        return cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public String getStationName() {
        return stationName;
    }

    public String getAddress() {
        return address;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public String getPhone() {
        return phone;
    }

    public double getKey() {
        return key;
    }
}
