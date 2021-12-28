package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.CityClient;
import com.ita.edu.teachua.api.clients.sigin.Authorization;
import com.ita.edu.teachua.api.models.city.City;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

public class CityTest extends AuthorizedApiTestRunner {

    @Test
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

}