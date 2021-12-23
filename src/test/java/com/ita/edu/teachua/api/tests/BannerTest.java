package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.BannerClient;
import com.ita.edu.teachua.api.models.banner.BannerModel;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class BannerTest extends AuthorizedApiTestRunner {
    @Test
    public void addInvalidNewBannerTest() throws IOException {
        BannerClient bannerClient = new BannerClient(authorization.getToken());
        BannerModel banner = BannerModel.builder()
                .title("demo banner")
                .subtitle("myBanner")
                .link("/upload/*/*.png")
                .picture("sdftrbhj")
                .sequenceNumber(1)
                .build();
        Response response = bannerClient.addNewBanner(banner);
        Assert.assertEquals(response.getStatusCode(), 400, "picture Incorrect file path. It must be like /upload/*/*.png");
    }

    @Test
    public void getListOfBanners() throws IOException {
        Specifications.setResponseSpecification(200);
        BannerClient bannerClient = new BannerClient(authorization.getToken());
        Response get = bannerClient.getBanners();
        List<BannerModel> banners = get
                .then().log().all()
                .extract().body().jsonPath().getList(".", BannerModel.class);
        banners.forEach(x->Assert.assertTrue(x.getPicture().contains("/upload/banner/")));
        //List<Integer> sequenceNumber = banners.stream().map(BannerModel::getSequenceNumber).collect(Collectors.toList());

    }
}
