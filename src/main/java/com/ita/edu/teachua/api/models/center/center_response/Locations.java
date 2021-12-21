package com.ita.edu.teachua.api.models.center.center_response;

import lombok.Data;

@Data
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
}
