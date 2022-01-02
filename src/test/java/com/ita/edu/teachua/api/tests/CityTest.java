package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.CityClient;
import com.ita.edu.teachua.api.clients.sigin.Authorization;
import com.ita.edu.teachua.api.models.city.city_request.City;
import com.ita.edu.teachua.api.models.city.city_response.CityResponse;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class CityTest extends AuthorizedApiTestRunner {
    @Description("[API] Add city 'Канів'")
    @Test(description = "TUA")
    public void deleteCityByIdTest() throws IOException {
        Specifications.setResponseSpecification(200);
        authorization = new Authorization(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword());
        CityClient cityClient = new CityClient(authorization.getToken());
        City city = City.builder()
                .name("Канів")
                .latitude(45.005f)
                .longitude(27.546f)
                .build();

        Response responseCreate = cityClient.addNewCity(city);
        Integer cityId = responseCreate.path("id");

        cityClient.deleteCityById(cityId);
    }

    @Description("[API] Get list of cities")
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

    @Description("[API] Change the longitude and latitude of the city")
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
        Response response = cityClient.addNewCity(city);
        Integer cityId = response.path("id");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.path("latitude"), 32.0643f);
        softAssert.assertEquals(response.path("longitude"), 49.2542f);

        city.setLatitude(49.2542f);
        city.setLongitude(32.0643f);
        Response responseUpdate = cityClient.updateCityById(city, cityId);

        softAssert.assertEquals(responseUpdate.path("latitude"), 49.2542f);
        softAssert.assertEquals(responseUpdate.path("longitude"), 32.0643f);

        cityClient.deleteCityById(cityId);
        softAssert.assertAll();
    }

    @Description("Verify that city without name can not be added")
    @Test(description = "TUA")
    public void addCityWithoutNameTest() throws IOException {
        authorization = new Authorization(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword());
        CityClient cityClient = new CityClient(authorization.getToken());
        City city = City.builder()
                .name("")
                .latitude(32.0643f)
                .longitude(49.2542f)
                .build();
        Response response = cityClient.addNewCity(city);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 400);
        softAssert.assertEquals(response.path("message"), "name must not be empty");
        softAssert.assertAll();

    }

}