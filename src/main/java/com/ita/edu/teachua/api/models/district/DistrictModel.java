package com.ita.edu.teachua.api.models.district;

public class DistrictModel {
    private String name;
    private String cityName;

    public DistrictModel() {
    }

    public DistrictModel(String name, String cityName) {
        this.name = name;
        this.cityName = cityName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
