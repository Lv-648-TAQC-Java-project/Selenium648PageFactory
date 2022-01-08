package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.BannerClient;
import com.ita.edu.teachua.api.clients.sigin.Authorization;
import com.ita.edu.teachua.api.models.banner.BannerModel;
import com.ita.edu.teachua.api.models.error.BaseErrorBody;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class BannerTest extends AuthorizedAsAdminApiTestRunner {

    @Test
    public void getListOfBanners() throws IOException {
        Specifications.setResponseSpecification(200);
        BannerClient bannerClient = new BannerClient(authorization.getToken());
        Response response = bannerClient.getBanners();
        List<BannerModel> banners = response
                .then().log().all()
                .extract().body().jsonPath().getList(".", BannerModel.class);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(banners.stream().count(), 4);
    }

    @Test
    public void getBanner() throws IOException {
        Specifications.setResponseSpecification(200);
        BannerClient bannerClient = new BannerClient(authorization.getToken());
        Response response = bannerClient.getBanner(10);
        BannerModel bannerModel = response
                .then().log().all()
                .extract().as(BannerModel.class);
        Assert.assertEquals(bannerModel.getTitle(), "Навчай українською");
        Assert.assertEquals(bannerModel.getSequenceNumber(), (Integer) 1);
    }

    @Test
    public void addNewBannerWithInvalidData() throws IOException{
        authorization = new Authorization(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword());
        BannerClient bannerClient = new BannerClient(authorization.getToken());
        Response response = bannerClient.addNewBanner();
        BaseErrorBody errorBody = response.then().log().all().extract().as(BaseErrorBody.class);
        Assert.assertEquals((int) errorBody.getStatus(), 400);
        Assert.assertEquals(errorBody.getMessage(), "picture Incorrect file path. It must be like /upload/*/*.png");
    }

    /*public void addNewBanner() throws IOException {
        Specifications.setResponseSpecification(200);
        BannerClient bannerClient = new BannerClient(authorization.getToken());
        File file = new File("C:\\Users\\s\\Desktop\\banner.json.png");
        Response response = RestAssured
                .given()
                .multiPart("file", file, "application/json")
                .post("https://speak-ukrainian.org.ua/dev/api/banner")
                .thenReturn();
        BannerModel bannerModel = response
                .then().log().all()
                .extract().as(BannerModel.class);
        Assert.assertEquals(bannerModel.getSequenceNumber(), (Integer) 4);
        Assert.assertEquals(response.body().path("2kjbvccvut"), bannerModel.getSubtitle());
        Response deleteBanner = BannerClient.deleteBanner(bannerModel.getId(19));
        Assert.assertEquals(deleteBanner.getStatusCode(200));
    }*/
}
