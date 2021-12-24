package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.BannerClient;
import com.ita.edu.teachua.api.models.banner.BannerModel;
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

    }

    @Test
    public void getBanner() throws IOException {
        Specifications.setResponseSpecification(200);
        BannerClient bannerClient = new BannerClient(authorization.getToken());
        Response response = bannerClient.getBanner(11);
        BannerModel bannerModel = response
                .then().log().all()
                .extract().as(BannerModel.class);
        Assert.assertEquals(bannerModel.getId(),(Integer) 11);
        Assert.assertEquals(bannerModel.getSequenceNumber(), (Integer) 1);
    }

}
