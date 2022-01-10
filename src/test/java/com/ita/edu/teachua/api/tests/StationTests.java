package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.StationClient;
import com.ita.edu.teachua.api.clients.sigin.Authorization;
import com.ita.edu.teachua.api.models.station.StationResponseModel;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class StationTests extends AuthorizedAsAdminApiTestRunner {

    @Test
    public void getStationByID() throws IOException {
        Specifications.setResponseSpecification(200);
        authorization = new Authorization(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword());
        SoftAssert softAssert = new SoftAssert();
        StationClient stationClient = new StationClient(authorization.getToken());
        Response get = stationClient.getStation(3);
        StationResponseModel stationResponseModel = get.then().log().all()
                .extract().as(StationResponseModel.class);
        Assert.assertEquals(get.getStatusCode(), 200);
        softAssert.assertEquals(stationResponseModel.getName(), "Берестейська");
        softAssert.assertEquals(stationResponseModel.getCityName(), "Київ");
        softAssert.assertAll();
    }

    @Test
    public void getStationsByName() throws IOException {
        Specifications.setResponseSpecification(200);
        SoftAssert softAssert = new SoftAssert();
        StationClient stationClient = new StationClient(authorization.getToken());
        Response response = stationClient.getStationsByCityName("Київ");
        List<StationResponseModel> stationModelList = response
                .then().log().all()
                .extract().body().jsonPath().getList(".", StationResponseModel.class);
        Assert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertEquals(stationModelList.get(0).getId(), Integer.valueOf(1));
        softAssert.assertEquals(stationModelList.get(0).getName(), "Академмістечко");
        softAssert.assertEquals(stationModelList.get(0).getCityName(), "Київ");
        softAssert.assertAll();
    }

    @Test
    public void getStations() throws IOException {
        Specifications.setResponseSpecification(200);
        StationClient stationClient = new StationClient(authorization.getToken());
        Response response = stationClient.getStations();
        List<StationResponseModel> stationsResponseModelList = response
                .then().log().all()
                .extract().body().jsonPath().getList(".", StationResponseModel.class);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
