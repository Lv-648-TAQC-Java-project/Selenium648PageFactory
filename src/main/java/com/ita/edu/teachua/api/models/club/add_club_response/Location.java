package com.ita.edu.teachua.api.models.club.add_club_response;

public class Location{
    private Integer id;
    private String name;
    private String address;
    private Integer latitude;
    private Integer longitude;
    private String phone;
    private District district;
    private Station station;
    private City city;
    private Club club;
    private String center;

    public Location() {
    }

    public Location(Integer id, String name, String address, Integer latitude, Integer longitude, String phone, District district, Station station, City city, Club club, String center) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.phone = phone;
        this.district = district;
        this.station = station;
        this.city = city;
        this.club = club;
        this.center = center;
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

    public Integer getLatitude() {
        return latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public String getPhone() {
        return phone;
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

    public Club getClub() {
        return club;
    }

    public String getCenter() {
        return center;
    }
}