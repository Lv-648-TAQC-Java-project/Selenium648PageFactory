package com.ita.edu.teachua.api.models.category;

import com.ita.edu.teachua.api.clients.CategoryClient;
import lombok.Data;

@Data
public class CategoryModel {
    private int id;
    private int sortby;
    private String name;
    private String description;
    private String urlLogo;
    private String backgroundColor;
    private String tagBackgroundColor;
    private String tagTextColor;
}
