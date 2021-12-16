package com.ita.edu.teachua.api.tests;


import com.ita.edu.teachua.api.authorization.Authorization;
import com.ita.edu.teachua.api.clients.ClubClient;
import com.ita.edu.teachua.api.clients.SignInClient;
import com.ita.edu.teachua.api.models.club.ClubRoot;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateClubTest extends AuthorizedApiTestRunner {
    @Test(description="TUA-463")
    public void VerifyThatUserAsOwnerCanCreateNewClubWhichRegisteredOnHim(){
       ClubClient clubClient = new ClubClient(authorization.getToken());
       Response response = clubClient.addNewClub();
       response.then().log().all()
               .extract()
               .as(ClubRoot.class);
       System.out.println(response);

       //System.out.println(clubClient.getNewClub());

    }
}
