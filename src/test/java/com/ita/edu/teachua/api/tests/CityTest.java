package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.CityClient;
import com.ita.edu.teachua.api.clients.sigin.Authorization;
import com.ita.edu.teachua.api.models.city.city_request.City;
import com.ita.edu.teachua.api.models.city.city_response.CityResponse;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class CityTest extends AuthorizedApiTestRunner {


    @Description("[API] Change the values of the longitude and latitude of the city")
    @Test(description = "TUA")
    public void changeLongitudeAndLatitudeOfCityTest() throws IOException {
        Specifications.setResponseSpecification(200);
        authorization = new Authorization(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword());
        CityClient cityClient = new CityClient(authorization.getToken());
        City city = City.builder()
                .name("Черкаси_1")
                .latitude(32.0643f)
                .longitude(49.2542f)
                .build();

        CityResponse cityResponse = cityClient.addNewCity(city)
                .then()
                .log().all()
                .extract().as(CityResponse.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(cityResponse.getName(), "Черкаси_1");
        softAssert.assertEquals(cityResponse.getLatitude(), 32.0643f);
        softAssert.assertEquals(cityResponse.getLongitude(), 49.2542f);

        int id = cityResponse.getId();
        city.setLatitude(49.2542f);
        city.setLongitude(32.0643f);
        Response responseUpdate = cityClient.updateCityById(city, id);

        softAssert.assertEquals(responseUpdate.path("latitude"), 49.2542f);
        softAssert.assertEquals(responseUpdate.path("longitude"), 32.0643f);

        cityClient.deleteCityById(id);
        softAssert.assertAll();
    }


    @Description("Verify that city without latitude and longitude is not added")
    @Test(description = "TUA")
    public void addCityWithoutNameTest() throws IOException {
        authorization = new Authorization(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword());
        CityClient cityClient = new CityClient(authorization.getToken());
        City city = City.builder()
                .name("Черкаси")
                .latitude(null)
                .longitude(null)
                .build();
        Response response = cityClient.addNewCity(city);
        Assert.assertEquals(response.getStatusCode(), 400);
    }


    @Description("[API] Get array of cities")
    @Test(description = "TUA")
    public void getListOfCitiesTest() throws IOException {
        Specifications.setResponseSpecification(200);
        CityClient cityClient = new CityClient(authorization.getToken());
        Response response = cityClient.getCities();
        CityResponse[] cityResponses = response.then()
                .log().all()
                .extract().as(CityResponse[].class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(cityResponses[0].getName(), "Київ");
        softAssert.assertEquals(cityResponses[1].getName(), "Харків");
        softAssert.assertEquals(cityResponses[2].getName(), "Дніпро");
        softAssert.assertEquals(cityResponses[3].getName(), "Одеса");
        softAssert.assertEquals(cityResponses[4].getName(), "Запоріжжя");
        softAssert.assertAll();
    }

}