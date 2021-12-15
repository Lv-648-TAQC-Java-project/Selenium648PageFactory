package com.ita.edu.teachua.api.models.club.add_club;

public class Category {
    private Integer id;
    private Integer sortby;
    private String name;
    private String description;
    private String urlLogo;
    private String backgroundColor;
    private String tagBackgroundColor;
    private String tagTextColor;

    public Category(Integer id, Integer sortby, String name, String description, String urlLogo, String backgroundColor, String tagBackgroundColor, String tagTextColor) {
        this.id = id;
        this.sortby = sortby;
        this.name = name;
        this.description = description;
        this.urlLogo = urlLogo;
        this.backgroundColor = backgroundColor;
        this.tagBackgroundColor = tagBackgroundColor;
        this.tagTextColor = tagTextColor;
    }

    public Integer getId() {
        return id;
    }

    public Integer getSortby() {
        return sortby;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getTagBackgroundColor() {
        return tagBackgroundColor;
    }

    public String getTagTextColor() {
        return tagTextColor;
    }
}
