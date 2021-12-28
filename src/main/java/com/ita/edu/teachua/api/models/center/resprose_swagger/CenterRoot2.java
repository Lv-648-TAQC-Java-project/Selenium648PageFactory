package com.ita.edu.teachua.api.models.center.resprose_swagger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class CenterRoot2 {
    public int id;
    public String name;
    public String urlBackgroundPicture;
    public String email;
    public Object phones;
    public String description;
    public String urlWeb;
    public String urlLogo;
    public Object socialLinks;
    public User user;
    public List<Location> locations;
    public List<Club> clubs;
    public List<Contact> contacts;
}
