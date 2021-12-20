package com.ita.edu.teachua.utils;

import com.ita.edu.teachua.api.models.category.CategoryModel;
import com.ita.edu.teachua.api.models.club.add_club_request.AddClub;

public class ClientDataTransfer {
    GsonParser parser;

    public AddClub getAddClub() {
        parser = new GsonParser();
        parser.parseAddClubJson();
        return parser.getAddClub();
    }
    public AddClub getAddRusClub() {
        parser = new GsonParser();
        parser.parseAddRusClubJson();
        return parser.getAddClub();
    }
    public CategoryModel getAddCategory(){
        parser = new GsonParser();
        parser.parseAddCategoryJson();
        return parser.getAddCategory();
    }
}
