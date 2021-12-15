package com.ita.edu.teachua.api.models.club.add_club;

public class Location {
    private Integer id;
    private String name;
    private String address;
    private Double latitude;
    private Double longitude;
    private District district;
    private Station station;
    private City city;

    public Location(Integer id, String name, String address, Double latitude, Double longitude, District district, Station station, City city) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.district = district;
        this.station = station;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public District getDistrict() {
        return district;
    }

    public Station getStation() {
        return station;
    }

    public City getCity() {
        return city;
    }
}
