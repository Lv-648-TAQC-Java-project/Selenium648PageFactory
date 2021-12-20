package com.ita.edu.teachua.api.tests;


import com.ita.edu.teachua.api.clients.DistrictClient;
import com.ita.edu.teachua.api.models.district.DistrictModel;
import com.ita.edu.teachua.api.models.district.SuccessDistrictModel;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

public class DistrictTest extends AuthorizedAsAdminApiTestRunner{
    @Test
    public void createDistrict() throws IOException {
        Specifications.setResponseSpecification(200);
        DistrictClient districtClient = new DistrictClient(authorization.getToken());
        Response response = districtClient.addNewDistrict();

        SuccessDistrictModel successDistrictModel = response
                .then().log().all()
                .extract().as(SuccessDistrictModel.class);

        System.out.println(successDistrictModel.getId());
    }

}
