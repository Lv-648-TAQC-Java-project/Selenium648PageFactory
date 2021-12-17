package com.ita.edu.teachua.api.models.club.add_club_response;

import java.util.List;

public class Role {
    private Integer id;
    private String name;
    private List<String> users;

    public Role() {
    }

    public Role(Integer id, String name, List<String> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getUsers() {
        return users;
    }
}
