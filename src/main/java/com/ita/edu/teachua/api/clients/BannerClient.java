package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.api.models.banner.BannerModel;
import com.ita.edu.teachua.utils.MainValueProvider;
import io.restassured.response.Response;

import java.io.IOException;

public class BannerClient extends BaseClient {
    private final String bannerUrl;
    private final String bannersUrl;
    protected MainValueProvider valueProvider;
    private String token;

    public BannerClient(String token) throws IOException{
        super();
        this.bannersUrl = mainValueProvider.getBannersClientUrl();
        this.bannerUrl = mainValueProvider.getBannerClientUrl();
        this.token = token;
        valueProvider = new MainValueProvider();
    }
    public Response addNewBanner(BannerModel banner){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .body(banner)
                .log().all()
                .when()
                .post(bannerUrl);
    }
    public Response getBanners(){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .get(bannersUrl);
    }
}

