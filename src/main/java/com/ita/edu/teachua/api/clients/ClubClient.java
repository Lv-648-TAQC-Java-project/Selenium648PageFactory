package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.api.models.club.ClubRoot;
import com.ita.edu.teachua.api.models.club.add_club.AddClub;
import com.ita.edu.teachua.utils.GsonParser;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ClubClient extends BaseClient {
    private final String clientUrl;
    private AddClub addClub;
    private ClubRoot clubRoot;



    public ClubClient(String baseApiUrl, ContentType contentType, String clientUrl, int status) {
        super(baseApiUrl, contentType, status);
        this.clientUrl = clientUrl;
        setAddClubFromJson();
    }
    public void setAddClubFromJson(){
        GsonParser parser = new GsonParser();
        parser.parseAddClubJson();
        this.addClub = parser.getAddClub();
    }
    public void addNewClub(RequestSpecification preparedRequest){
        clubRoot = preparedRequest
                .body(addClub)
                .when()
                .post(clientUrl)
                .then().log().all()
                .extract()
                .as(ClubRoot.class);
    }
    public ClubRoot getNewClub(){
        return clubRoot;
    }
    /*private AddClub fillAddClub(){

        addClub = given()
                .body(payLoad)
                .when()
                .post("clientUrl")
                .then().log().all()
                .extract().
                as(AddClub.class);
        return addClub;
    }*/

    /*public SuccessSignIn successSignInRequest(User user){
        successSignIn = given()
                .body(user)
                .when()
                .post(clientUrl)
                .then().log().all()
                .extract()
                .as(SuccessSignIn.class);
        return successSignIn;
    }*/
}
