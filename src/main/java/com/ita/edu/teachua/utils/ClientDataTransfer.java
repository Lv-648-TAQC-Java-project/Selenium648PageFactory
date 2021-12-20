package com.ita.edu.teachua.utils;


import com.ita.edu.teachua.api.models.challenge.response.AddChallengeResponse;
import com.ita.edu.teachua.api.models.category.CategoryModel;
import com.ita.edu.teachua.api.models.center.center_request.CenterModel;
import com.ita.edu.teachua.api.models.club.add_club_request.AddClub;
import com.ita.edu.teachua.api.models.district.DistrictModel;

public class ClientDataTransfer {
    GsonParser parser;

    public AddClub getAddClub() {
        parser = new GsonParser();
        parser.parseAddClubJson();
        return parser.getAddClub();
    }

    public AddChallengeResponse getAddChallenge(){
        parser=new GsonParser();
        parser.parseAddChallengeJson();
        return parser.getAddChallengeResponse();
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
    public DistrictModel getAddDistrict(){
        parser = new GsonParser();
        parser.parseAddDistrictJson();
        return parser.getAddDistrict();
    }
    public CenterModel getAddCenter(){
        parser = new GsonParser();
        parser.parseAddCenterJson();
        return parser.getAddCenter();
    }

}
