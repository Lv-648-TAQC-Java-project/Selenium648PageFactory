package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.ClubClient;
import com.ita.edu.teachua.api.models.club.add_club_request.AddClub;
import com.ita.edu.teachua.api.models.club.add_club_response.ClubRoot;
import com.ita.edu.teachua.api.models.error.BaseErrorBody;
import com.ita.edu.teachua.utils.ClientDataTransfer;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AuthorizedClubTest extends AuthorizedApiTestRunner {

    @Test(description="TUA-463")
    public void VerifyThatUserAsOwnerCanCreateNewClubWhichRegisteredOnHim() throws IOException {
        Specifications.setResponseSpecification(200);
        ClubClient clubClient = new ClubClient(authorization.getToken());
        AddClub addClub = new ClientDataTransfer().getAddClub();
        Response response = clubClient.addNewClub(addClub);
        ClubRoot clubRoot = response.then().log().all()
               .extract()
               .as(ClubRoot.class);

        Integer clubRegisteredUserId = clubRoot.getUser().getId();
        Integer currentAuthorizedUserId = authorization.getCurrentAuthorizedUserID();

        clubClient.deleteClub(clubRoot.getId());

        Assert.assertEquals(clubRegisteredUserId,currentAuthorizedUserId);

    }
    @Test(description="TUA-501")
    public void VerifyThatUserCannotCreateNewClubWithRussianCharactersInNamefield() throws IOException {
        Specifications.setResponseSpecification(400);
        ClubClient clubClient = new ClubClient(authorization.getToken());
        AddClub addClub = new ClientDataTransfer().getAddClub();
        addClub.setName("Э э ъ Ъ Ы ы");
        Response response = clubClient.addNewClub(addClub);
        BaseErrorBody error = response.then().log().all()
                 .extract()
                 .as(BaseErrorBody.class);
        Assert.assertEquals(error.getStatus(),(Integer)400);
        Assert.assertEquals(error.getMessage(),"name can't contain russian letters");
    }
}