package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.api.models.city.City;
import com.ita.edu.teachua.utils.MainValueProvider;
import io.restassured.response.Response;

import java.io.IOException;

public class CityClient extends BaseClient {
    protected MainValueProvider valueProvider;
    private final String cityUrl;
    private final String citiesUrl;
    private String token;


    public CityClient(String token) throws IOException {
        super();
        try {
            valueProvider = new MainValueProvider();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.cityUrl = mainValueProvider.getCityUrl();
        this.citiesUrl = mainValueProvider.getCitiesUrl();
        this.token = token;
    }


    public Response addNewCity(City city){
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .body(city)
                .log().all()
                .when()
                .post(cityUrl);

    }

    public Response deleteCityById(int id) {
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s", token))
                .log().all()
                .when()
                .delete(String.format("%s/%d", cityUrl, id));
    }

}