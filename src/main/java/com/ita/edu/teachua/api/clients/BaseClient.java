package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.utils.ValueProvider;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;


import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

import java.io.IOException;


public class BaseClient {
    protected final String baseApiUrl;
    protected final ContentType contentType;
    protected ValueProvider valueProvider;

    public BaseClient()  {
        try {
            valueProvider = new ValueProvider();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.baseApiUrl=valueProvider.getBaseApiUrl();
        this.contentType = ContentType.JSON;
    }

    protected RequestSpecification preparedRequest() {
        return given()
                .baseUri(baseApiUrl)
                .contentType(contentType)
                .accept(contentType);
    }
}
