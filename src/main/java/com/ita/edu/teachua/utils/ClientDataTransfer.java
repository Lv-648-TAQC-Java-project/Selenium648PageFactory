package com.ita.edu.teachua.utils;

import com.ita.edu.teachua.api.models.category.CategoryModel;
import com.ita.edu.teachua.api.models.club.add_club_request.AddClub;
import com.ita.edu.teachua.api.models.district.DistrictModel;

public class ClientDataTransfer {
    GsonParser parser;

    public AddClub getAddClub() {
        parser = new GsonParser();
        parser.parseAddClubJson();
        return parser.getAddClub();
    }
    public CategoryModel getAddCategory(){
        parser = new GsonParser();
        parser.parseAddCategoryJson();
        return parser.getAddCategory();
    }
    public DistrictModel getAddDistrict(){
        parser = new GsonParser();
        parser.parseAddDistrictJson();
        return parser.getAddDistrict();
    }
}
