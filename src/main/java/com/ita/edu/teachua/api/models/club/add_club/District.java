package com.ita.edu.teachua.api.models.club.add_club;

public class District {
    private Integer id;
    private String name;
    private City city;

    public District(Integer id, String name, City city) {
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
