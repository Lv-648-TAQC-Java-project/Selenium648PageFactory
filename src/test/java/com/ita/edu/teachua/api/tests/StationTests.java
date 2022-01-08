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
    public void createChangeAndDeleteStation() throws IOException {
        StationClient stationClient = new StationClient(authorization.getToken());
        Response addStationResponse = stationClient.addNewStation();
        StationResponseModel stationResponseModel = addStationResponse.then().log().all()
                .extract().as(StationResponseModel.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(stationResponseModel.getName(), "Т");

        Response changeStationResponse = stationClient.changeStation(stationResponseModel.getId());
        StationResponseModel changedStation = changeStationResponse.then().log().all()
                .extract().as(StationResponseModel.class);
        softAssert.assertEquals(changedStation.getName(), "Т");
        softAssert.assertAll();

        Response delete = stationClient.deleteStation(stationResponseModel.getId());
        Assert.assertEquals(delete.getStatusCode(), 200);
    }

    @Test
    public void getStation() throws IOException {
        Specifications.setResponseSpecification(200);
        authorization = new Authorization(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword());
        SoftAssert softAssert = new SoftAssert();
        StationClient stationClient = new StationClient(authorization.getToken());
        Response get = stationClient.getStation(3);
        StationResponseModel stationResponseModel = get.then().log().all()
                .extract().as(StationResponseModel.class);
        Assert.assertEquals(get.getStatusCode(), 200);
        softAssert.assertEquals(stationResponseModel.getName(), "F");
        softAssert.assertAll();
    }

    @Test
    public void getStations() throws IOException {
        Specifications.setResponseSpecification(200);
        StationClient stationClient = new StationClient(authorization.getToken());
        Response response = stationClient.getStations();
        List<StationResponseModel> contactModelList = response
                .then().log().all()
                .extract().body().jsonPath().getList(".", StationResponseModel.class);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
