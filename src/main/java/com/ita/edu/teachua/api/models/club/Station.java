package com.ita.edu.teachua.api.models.club;

public class Station{
    private Integer id;
    private String name;
    private City city;
    public District district;

    public Station() {
    }

    public Station(Integer id, String name, City city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }
}