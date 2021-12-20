package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.ChallengeClient;
import com.ita.edu.teachua.api.models.challenge.request.root.Root;
import com.ita.edu.teachua.api.models.challenge.response.AddChallengeResponse;
import com.ita.edu.teachua.api.models.club.add_club_response.ClubRoot;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class AddChallenge extends AuthorizedAsAdminApiTestRunner{
    @Test(description="TUA-429")
    public void addChallengeTest() throws IOException {
        Specifications.setResponseSpecification(200);
        ChallengeClient challengeClient=new ChallengeClient(authorization.getToken());
        Response response = challengeClient.addChallenge();
        Root addChallenge = response.then().log().all()
                .extract()
                .as(Root.class);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(addChallenge.getName(),"Example name");
        softAssert.assertEquals(addChallenge.getTitle(),"Example title");
        softAssert.assertEquals(addChallenge.getDescription(),"Lorem ipsum dolor sit amet, consectetuer adipiscin");
        softAssert.assertEquals(addChallenge.getUser().getFirstName(),"admin");
        softAssert.assertEquals(addChallenge.getUser().getLastName(),"Admin");
        softAssert.assertAll();
    }
}
