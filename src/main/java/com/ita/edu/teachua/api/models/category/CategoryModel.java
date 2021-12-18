package com.ita.edu.teachua.api.models.category;

import com.ita.edu.teachua.api.clients.CategoryClient;

public class CategoryModel {
    private int id;
    private int sortby;
    private String name;
    private String description;
    private String urlLogo;
    private String backgroundColor;
    private String tagBackgroundColor;
    private String tagTextColor;

    private CategoryModel(){}

    public CategoryModel(int id, int sortby, String name, String description, String urlLogo, String backgroundColor, String tagBackgroundColor, String tagTextColor) {
        this.id = id;
        this.sortby = sortby;
        this.name = name;
        this.description = description;
        this.urlLogo = urlLogo;
        this.backgroundColor = backgroundColor;
        this.tagBackgroundColor = tagBackgroundColor;
        this.tagTextColor = tagTextColor;
    }

    public int getId() {
        return id;
    }

    public int getSortby() {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setSortby(int sortby) {
        this.sortby = sortby;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setTagBackgroundColor(String tagBackgroundColor) {
        this.tagBackgroundColor = tagBackgroundColor;
    }

    public void setTagTextColor(String tagTextColor) {
        this.tagTextColor = tagTextColor;
    }
}
