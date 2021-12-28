package com.ita.edu.teachua.api.tests;


import com.ita.edu.teachua.api.clients.ClubClient;
import com.ita.edu.teachua.api.models.club.add_club_request.AddClub;
import com.ita.edu.teachua.api.models.club.add_club_response.ClubRoot;
import com.ita.edu.teachua.api.models.error.BaseErrorBody;
import com.ita.edu.teachua.utils.ClientDataTransfer;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthorizedClubTest extends AuthorizedApiTestRunner {

    @Test(description="TUA-405")
    public void VerifyThatClubCannotBeCreatedWhenOneOfTheMandatoryFieldsAreNotFilled() throws IOException{

        SoftAssert softAssert = new SoftAssert();
        ClubClient clubClient = new ClubClient(authorization.getToken());
        AddClub addClub = new ClientDataTransfer().getAddClub();

        JSONObject addClubJSON = new JSONObject(addClub);
        BaseErrorBody baseErrorBody;
        Response response;

        JSONArray categoriesName;
        String name;
        Integer ageFrom;
        Integer ageTo;
        String description;

        categoriesName = (JSONArray)addClubJSON.remove("categoriesName");
        response = clubClient.addNewClub(addClubJSON);
        baseErrorBody = response.then().log().all()
                .extract()
                .as(BaseErrorBody.class);
        softAssert.assertEquals(baseErrorBody.getStatus(),(Integer)500);
        softAssert.assertEquals(baseErrorBody.getError(),"Internal Server Error");
        addClubJSON.put("categoriesName",categoriesName);

        description =  (String)addClubJSON.remove("description");
        response = clubClient.addNewClub(addClubJSON);
        baseErrorBody = response.then().log().all()
                .extract()
                .as(BaseErrorBody.class);
        softAssert.assertEquals(baseErrorBody.getStatus(),(Integer)500);
        softAssert.assertEquals(baseErrorBody.getError(),"Internal Server Error");
        addClubJSON.put("description", description);


        name = (String)addClubJSON.remove("name");
        response = clubClient.addNewClub(addClubJSON);
        baseErrorBody = response.then().log().all()
                .extract()
                .as(BaseErrorBody.class);
        softAssert.assertEquals(baseErrorBody.getStatus(),(Integer)400);
        softAssert.assertEquals(baseErrorBody.getMessage(),"name must not be empty");
        addClubJSON.put("name", name);

        ageFrom = (Integer)addClubJSON.remove("ageFrom");
        response = clubClient.addNewClub(addClubJSON);
        baseErrorBody = response.then().log().all()
                .extract()
                .as(BaseErrorBody.class);
        softAssert.assertEquals(baseErrorBody.getStatus(),(Integer)400);
        softAssert.assertEquals(baseErrorBody.getMessage(),"ageFrom поле не може бути пустим");
        addClubJSON.put("ageFrom", ageFrom);

        ageTo = (Integer)addClubJSON.remove("ageTo");
        response = clubClient.addNewClub(addClubJSON);
        baseErrorBody = response.then().log().all()
                .extract()
                .as(BaseErrorBody.class);
        softAssert.assertEquals(baseErrorBody.getStatus(),(Integer)400);
        softAssert.assertEquals(baseErrorBody.getMessage(),"ageTo поле не може бути пустим");
        addClubJSON.put("ageTo", ageTo);



        addClubJSON.remove("contacts");
        response = clubClient.addNewClub(addClubJSON);

        softAssert.assertEquals(response.getStatusCode(),400);
        softAssert.assertEquals(response.getBody().jsonPath().get("message"),"contacts must not be empty");

        if(response.getStatusCode()==200) {
            clubClient.deleteClub(response.getBody().jsonPath().get("id"));
        }


        softAssert.assertAll();

    }
    @Test(description="TUA-371/372/463")
    public void VerifyThatUserAsOwnerCanCreateNewClubWhichRegisteredOnHim() throws IOException {

        ClubClient clubClient = new ClubClient(authorization.getToken());
        AddClub addClub = new ClientDataTransfer().getAddClub();
        Response response = clubClient.addNewClub(addClub);
        ClubRoot clubRoot = response.then().log().all()
                .extract()
                .as(ClubRoot.class);

        Integer clubRegisteredUserId = clubRoot.getUser().getId();
        Integer currentAuthorizedUserId = authorization.getCurrentAuthorizedUserID();

        clubClient.deleteClub(clubRoot.getId());
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(clubRegisteredUserId,currentAuthorizedUserId);

    }


    @DataProvider
    public Object[][] VerifyThatClubCannotBeCreatedWhenEenteringInvalidDataDataProvider() {
        return new Object[][]{
                {
                        "Новий тип гуртка",
                        "Category not found by name: Новий тип гуртка",
                        "Танці, хореографія",
                        "ЪЫЭЁЁ",
                        "name can't contain russian letters",
                        "name",
                        "name Довжина назви має бути від 5 до 100 символів",
                        "characterscharacsterscharacterscharacterscharacterscharacterscharacterscharacterschacharacterscharact",
                        "testName",
                        1,
                        "ageFrom must be greater than or equal to 2",
                        2,
                        19,
                        18,
                        "ageTo must be less than or equal to 18",
                        "ЪЫЭЁЪЫЭЁЪЫЭЁЪЫЭЁЪЫЭЁЪЫЭЁЪЫЭЁЪЫЭЁЪЫЭЁЪЫЭЁЪЫЭЁЪЫЭЁЪЫЭЁЪЫЭЁЪЫЭЁЪЫЭЁЪЫЭЁЪЫЭЁЪЫЭЁЪЫЭЁЪЫЭЁЪЫЭЁ",
                        "Це поле може містити тільки українські та англійські літери, цифри та спеціальні символи",
                        "Description",
                        "Довжина опису не може бути меншою за 40 символів",
                        "descriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptndescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptionriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriiptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescrasdfw",
                        "Довжина опису не може бути більшою за 1500 символів"
                }
        };
    }

    @Test(description="TUA-409",dataProvider = "VerifyThatClubCannotBeCreatedWhenEenteringInvalidDataDataProvider")
    public void VerifyThatClubCannotBeCreatedWhenEnteringInvalidData(String notExistingCategoryName,
                                                                      String categoryNotFoundMessage,
                                                                      String existingCategoryName,
                                                                      String russianCharactersClubName,
                                                                      String russianClubNameForbiddenMessage,
                                                                      String toShortClubName,
                                                                      String invalidLengthClubNameMessage,
                                                                      String toLongClubName,
                                                                      String validClubName,
                                                                      Integer toLowAgeFrom,
                                                                      String ageFromToLowMessage,
                                                                      Integer validAgeFrom,
                                                                      Integer toHighAgeTo,
                                                                      Integer validAgeTo,
                                                                      String ageToToHighMessage,
                                                                      String russianCharactersDescription,
                                                                      String allowedDescriptionCharactersMessage,
                                                                      String toShortDescription,
                                                                      String toShortDescriptionMessage,
                                                                      String toLongDescription,
                                                                      String toLongDescriptionMessage) throws IOException {

        SoftAssert softAssert = new SoftAssert();
        ClubClient clubClient = new ClubClient(authorization.getToken());
        AddClub addClub = new ClientDataTransfer().getAddClub();
        Response response;
        BaseErrorBody errorBody;
        List<String> categoriesName = new ArrayList<>();

        categoriesName.add(notExistingCategoryName);
        addClub.setCategoriesName(categoriesName);  //adding a name for a category that does not exist

        response = clubClient.addNewClub(addClub);
        errorBody = response.then().log().all()
                .extract()
                .as(BaseErrorBody.class);
        softAssert.assertEquals(errorBody.getStatus(),(Integer)404);
        softAssert.assertEquals(errorBody.getMessage(),categoryNotFoundMessage);

        categoriesName.clear();
        categoriesName.add(existingCategoryName);  //adding the name of an existing category

        addClub.setCategoriesName(categoriesName);
        addClub.setName(russianCharactersClubName); //setting club name with russian characters

        response = clubClient.addNewClub(addClub);
        errorBody = response.then().log().all()
                .extract()
                .as(BaseErrorBody.class);

        softAssert.assertEquals(errorBody.getStatus(),(Integer)400);
        softAssert.assertEquals(errorBody.getMessage(),russianClubNameForbiddenMessage);

        addClub.setName(toShortClubName); // setting a short name for the club

        response = clubClient.addNewClub(addClub);
        errorBody = response.then().log().all()
                .extract()
                .as(BaseErrorBody.class);

        softAssert.assertEquals(errorBody.getStatus(),(Integer)400);
        softAssert.assertEquals(errorBody.getMessage(),invalidLengthClubNameMessage);

        addClub.setName(toLongClubName); // setting a long name for the club

        response = clubClient.addNewClub(addClub);
        errorBody = response.then().log().all()
                .extract()
                .as(BaseErrorBody.class);

        softAssert.assertEquals(errorBody.getStatus(),(Integer)400);
        softAssert.assertEquals(errorBody.getMessage(),invalidLengthClubNameMessage);

        addClub.setName(validClubName); //setting valid club name
        addClub.setAgeFrom(toLowAgeFrom);  //setting to low "age from"

        response = clubClient.addNewClub(addClub);
        errorBody = response.then().log().all()
                .extract()
                .as(BaseErrorBody.class);

        softAssert.assertEquals(errorBody.getStatus(),(Integer)400);
        softAssert.assertEquals(errorBody.getMessage(),ageFromToLowMessage);

        addClub.setAgeFrom(validAgeFrom); //setting valid age for "age from"
        addClub.setAgeTo(toHighAgeTo); //setting to high "age to"

        response = clubClient.addNewClub(addClub);
        errorBody = response.then().log().all()
                .extract()
                .as(BaseErrorBody.class);

        softAssert.assertEquals(errorBody.getStatus(),(Integer)400);
        softAssert.assertEquals(errorBody.getMessage(),ageToToHighMessage);

        addClub.setAgeTo(validAgeTo); //setting valid age for "age from"

        //getting stringify JSON field description of addClub model for further change according to the test steps
        JSONObject clubDescription = new JSONObject(addClub.getDescription());
        JSONArray blocks = (JSONArray) clubDescription.get("blocks");

        ((JSONObject) blocks.get(0)).put("text", russianCharactersDescription); //setting description which contains russian characters
        clubDescription.put("blocks",blocks);
        addClub.setDescription(String.valueOf(clubDescription));

        response = clubClient.addNewClub(addClub);
        errorBody = response.then().log().all()
                .extract()
                .as(BaseErrorBody.class);

        softAssert.assertEquals(errorBody.getStatus(),(Integer)400);
        softAssert.assertEquals(errorBody.getMessage(),allowedDescriptionCharactersMessage);
        //addClub.setDescription(validClubDescription);

        ((JSONObject) blocks.get(0)).put("text",toShortDescription); //setting to short description
        clubDescription.put("blocks",blocks);
        addClub.setDescription(clubDescription.toString());response = clubClient.addNewClub(addClub);

        errorBody = response.then().log().all()
                .extract()
                .as(BaseErrorBody.class);

        softAssert.assertEquals(errorBody.getStatus(),(Integer)400);
        softAssert.assertEquals(errorBody.getMessage(),toShortDescriptionMessage);
        //addClub.setDescription(validClubDescription);
        ((JSONObject) blocks.get(0)).put("text",toLongDescription); //setting to long description
        clubDescription.put("blocks",blocks);
        addClub.setDescription(clubDescription.toString());

        response = clubClient.addNewClub(addClub);
        errorBody = response.then().log().all()
                .extract()
                .as(BaseErrorBody.class);

        softAssert.assertEquals(errorBody.getMessage(),toLongDescriptionMessage);

        softAssert.assertAll();
    }

    @Test(description="TUA-501")
    public void VerifyThatUserCannotCreateNewClubWithRussianCharactersInNameField() throws IOException {
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