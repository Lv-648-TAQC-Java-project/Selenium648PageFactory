package com.ita.edu.teachua.utils;

import com.google.gson.Gson;

import com.ita.edu.teachua.api.models.challenge.response.AddChallengeResponse;
import com.ita.edu.teachua.api.models.category.Category;
import com.ita.edu.teachua.api.models.center.center_request.Center;
import com.ita.edu.teachua.api.models.club.add_club_request.AddClub;
import com.ita.edu.teachua.api.models.district.DistrictModel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GsonParser {
    private Gson gson;

    private AddClub addClub;
    private AddChallengeResponse addChallengeResponse;
    private Category category;
    private Center center;

    private DistrictModel districtModel;

    public GsonParser() {
        gson = new Gson();
    }

    public void parseAddClubJson(){
        try(FileReader reader = new FileReader("src/main/resources/request_bodies/club/addClub.json")) {
            this.addClub = gson.fromJson(reader,AddClub.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void  parseAddChallengeJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_body.challenge/addChallenge.json")) {
            this.addChallengeResponse = gson.fromJson(reader, AddChallengeResponse.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AddChallengeResponse getAddChallengeResponse(){
        return addChallengeResponse;
    }


    public AddClub getAddClub() {
        return addClub;
    }

    public void parseAddCategoryJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/category/category.json")) {
            this.category = gson.fromJson(reader, Category.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseAddDistrictJson(){
        try (FileReader reader = new FileReader("src/main/resources/request_body.district/district.json")) {
            this.districtModel = gson.fromJson(reader, DistrictModel.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Category getAddCategory() {
        return category;
    }

    public void parseAddCenterJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/center/center.json")) {
            this.center = gson.fromJson(reader, Center.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Center getAddCenter() {
        return center;
    }

    public DistrictModel getAddDistrict() {
        return districtModel;
    }
}