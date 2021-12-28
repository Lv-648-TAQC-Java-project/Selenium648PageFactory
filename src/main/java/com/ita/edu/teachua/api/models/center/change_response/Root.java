package com.ita.edu.teachua.api.models.center.change_response;

import lombok.Data;

import java.util.List;

@Data
public class Root {
    public int id;
    public String name;
    public List<Location> locations;
    public String description;
    public String urlWeb;
    public String urlBackgroundPicture;
    public String urlLogo;
    public List<Integer> clubsId;
    public int userId;
    public String contacts;
    public int centerExternalId;
}
