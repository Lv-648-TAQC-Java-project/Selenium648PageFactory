package com.ita.edu.teachua.api.models.district;

public class SuccessDistrictModel {
    private Integer id;
    private String name;
    private String cityName;

    public SuccessDistrictModel() {
    }

    public SuccessDistrictModel(Integer id, String name, String cityName) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
