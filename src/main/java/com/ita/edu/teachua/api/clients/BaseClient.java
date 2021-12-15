package com.ita.edu.teachua.api.clients;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

import io.restassured.response.ExtractableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public abstract class BaseClient {
    protected final String baseApiUrl;
    protected final ContentType contentType;
    protected final int status;

    public BaseClient(String baseApiUrl, ContentType contentType, int status) {
        this.baseApiUrl=baseApiUrl;
        this.contentType = contentType;
        this.status = status;
        setSpecification(requestSpecification(),responseSpecification());
    }
    public RequestSpecification requestSpecification(){
        return new RequestSpecBuilder()
                .setBaseUri(baseApiUrl)
                .setContentType(contentType)
                .build();
    }

    public ResponseSpecification responseSpecification(){
        return new ResponseSpecBuilder()
                .expectStatusCode(status)
                .build();
    }

    public void setSpecification(RequestSpecification request, ResponseSpecification response){
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }

}
