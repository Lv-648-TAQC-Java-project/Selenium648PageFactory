package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.ClubClient;
import com.ita.edu.teachua.api.models.club.add_club_response.ClubRoot;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AuthorizedClubTest extends AuthorizedApiTestRunner {

    @Test(description="TUA-463")
    public void VerifyThatUserAsOwnerCanCreateNewClubWhichRegisteredOnHim() throws IOException {
        Specifications.setResponseSpecification(200);
        ClubClient clubClient = new ClubClient(authorization.getToken());
        Response response = clubClient.addNewClub();
        ClubRoot clubRoot = response.then().log().all()
               .extract()
               .as(ClubRoot.class);

        Integer clubRegisteredUserId = clubRoot.getUser().getId();
        Integer currentAuthorizedUserId = authorization.getCurrentAuthorizedUserID();

        clubClient.deleteClub(clubRoot.getId());

        Assert.assertEquals(clubRegisteredUserId,currentAuthorizedUserId);

    }
}
