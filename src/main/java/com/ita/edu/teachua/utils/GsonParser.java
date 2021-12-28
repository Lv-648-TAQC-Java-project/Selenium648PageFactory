package com.ita.edu.teachua.utils;

import com.google.gson.Gson;

import com.ita.edu.teachua.api.models.banner.BannerModel;
import com.ita.edu.teachua.api.models.challenge.response.AddChallengeResponse;
import com.ita.edu.teachua.api.models.category.CategoryModel;
import com.ita.edu.teachua.api.models.center.center_request.CenterModel;
import com.ita.edu.teachua.api.models.city.City;
import com.ita.edu.teachua.api.models.club.add_club_request.AddClub;
import com.ita.edu.teachua.api.models.district.DistrictModel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GsonParser {
    private Gson gson;

    private AddClub addClub;
    private AddChallengeResponse addChallengeResponse;
    private CategoryModel categoryModel;
    private CenterModel centerModel;

    private DistrictModel districtModel;
    private BannerModel bannerModel;
    private City city;

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
            this.categoryModel = gson.fromJson(reader, CategoryModel.class);
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

    public CategoryModel getAddCategory() {
        return categoryModel;
    }

    public void parseAddCenterJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/center/center.json")) {
            this.centerModel = gson.fromJson(reader, CenterModel.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CenterModel getAddCenter() {
        return centerModel;
    }

    public DistrictModel getAddDistrict() {
        return districtModel;
    }

    public void parseAddNewBannerJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/banner/banner")) {
            this.bannerModel = gson.fromJson(reader, BannerModel.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public BannerModel getAddNewBanner() {
        return bannerModel;
    }


    public void parseAddNewCityJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/city/city")) {
            this.city = gson.fromJson(reader, City.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public City getAddNewCity() {
        return city;
    }
}