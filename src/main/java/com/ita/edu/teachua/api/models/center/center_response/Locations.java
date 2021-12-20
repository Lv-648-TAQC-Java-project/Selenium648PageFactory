package com.ita.edu.teachua.api.models.center.center_response;

public class Locations {
    private int id;
    private String name;
    private String address;
    private int cityId;
    private int districtId;
    private int stationId;
    private String cityName;
    private String districtName;
    private String stationName;
    private Object coordinates;
    private double longitude;
    private double latitude;
    private int centerId;
    private Object clubId;
    private String phone;

    public Locations(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getCityId() {
        return cityId;
    }

    public int getDistrictId() {
        return districtId;
    }

    public int getStationId() {
        return stationId;
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

    public Object getCoordinates() {
        return coordinates;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public int getCenterId() {
        return centerId;
    }

    public Object getClubId() {
        return clubId;
    }

    public String getPhone() {
        return phone;
    }
}
