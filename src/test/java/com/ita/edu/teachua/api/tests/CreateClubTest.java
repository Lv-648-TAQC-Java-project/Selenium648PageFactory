package com.ita.edu.teachua.api.tests;


import com.ita.edu.teachua.api.authorization.Authorization;
import com.ita.edu.teachua.api.clients.ClubClient;
import com.ita.edu.teachua.api.clients.SignInClient;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class CreateClubTest extends ApiTestRunner {
    @Test(description="TUA-463")
    public void VerifyThatUserAsOwnerCanCreateNewClubWhichRegisteredOnHim(){
       authorization = new Authorization(new SignInClient(
               valueProvider.getBaseApiUrl(),
               ContentType.JSON,
               valueProvider.getSignInClientUrl(),
               200),
               "TestTeach.ua@meta.ua","123456789");
       ClubClient clubClient = new ClubClient(valueProvider.getBaseApiUrl(),ContentType.JSON,valueProvider.getClubClientUrl(),200);
       clubClient.addNewClub(authorization.prepareAuthorizedRequest());
       System.out.println(clubClient.getNewClub());

    }
}
