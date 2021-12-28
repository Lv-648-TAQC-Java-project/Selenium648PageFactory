package com.ita.edu.teachua.api.tests;


import com.ita.edu.teachua.api.clients.ClubClient;
import com.ita.edu.teachua.api.models.club.add_club_request.AddClub;
import com.ita.edu.teachua.api.models.club.add_club_response.ClubRoot;
import com.ita.edu.teachua.api.models.error.BaseErrorBody;
import com.ita.edu.teachua.utils.ClientDataTransfer;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthorizedClubTest extends AuthorizedApiTestRunner {
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
    public void VerifyThatClubCannotBeCreatedWhenEenteringInvalidData(String notExistingCategoryName,
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
                                                                      String toLongDescriptionMessage) throws IOException, ParseException {

        SoftAssert softAssert = new SoftAssert();
        ClubClient clubClient = new ClubClient(authorization.getToken());
        AddClub addClub = new ClientDataTransfer().getAddClub();
        Response response;
        BaseErrorBody errorBody;
        List<String> categoriesName = new ArrayList<>();

        categoriesName.add(notExistingCategoryName);
        addClub.setCategoriesName(categoriesName);  //adding a name for a category that does not exist

        Specifications.setResponseSpecification(404);

        response = clubClient.addNewClub(addClub);
        errorBody = response.then().log().all()
                .extract()
                .as(BaseErrorBody.class);
        softAssert.assertEquals(errorBody.getMessage(),categoryNotFoundMessage);

        categoriesName.clear();
        categoriesName.add(existingCategoryName);  //adding the name of an existing category

        addClub.setCategoriesName(categoriesName);
        addClub.setName(russianCharactersClubName); //setting club name with russian characters

        Specifications.setResponseSpecification(400);

        response = clubClient.addNewClub(addClub);
        errorBody = response.then().log().all()
                .extract()
                .as(BaseErrorBody.class);

        softAssert.assertEquals(errorBody.getMessage(),russianClubNameForbiddenMessage);

        addClub.setName(toShortClubName); // setting a short name for the club

        response = clubClient.addNewClub(addClub);
        errorBody = response.then().log().all()
                .extract()
                .as(BaseErrorBody.class);

        softAssert.assertEquals(errorBody.getMessage(),invalidLengthClubNameMessage);

        addClub.setName(toLongClubName); // setting a long name for the club

        response = clubClient.addNewClub(addClub);
        errorBody = response.then().log().all()
                .extract()
                .as(BaseErrorBody.class);

        softAssert.assertEquals(errorBody.getMessage(),invalidLengthClubNameMessage);

        addClub.setName(validClubName); //setting valid club name
        addClub.setAgeFrom(toLowAgeFrom);  //setting to low "age from"

        response = clubClient.addNewClub(addClub);
        errorBody = response.then().log().all()
                .extract()
                .as(BaseErrorBody.class);

        softAssert.assertEquals(errorBody.getMessage(),ageFromToLowMessage);

        addClub.setAgeFrom(validAgeFrom); //setting valid age for "age from"
        addClub.setAgeTo(toHighAgeTo); //setting to high "age to"

        response = clubClient.addNewClub(addClub);
        errorBody = response.then().log().all()
                .extract()
                .as(BaseErrorBody.class);

        softAssert.assertEquals(errorBody.getMessage(),ageToToHighMessage);

        addClub.setAgeTo(validAgeTo); //setting valid age for "age from"

        //parsing stringify JSON field description of addClub model for further change according to the test steps
        JSONObject clubDescription = (JSONObject)new JSONParser().parse(addClub.getDescription());
        String validClubDescription = clubDescription.toJSONString();
        List<JSONObject> blocks = (List<JSONObject>) clubDescription.get("blocks");

        blocks.get(0).put("text", russianCharactersDescription); //setting description which contains russian characters
        clubDescription.put("blocks",blocks);
        addClub.setDescription(clubDescription.toJSONString());

        response = clubClient.addNewClub(addClub);
        errorBody = response.then().log().all()
                .extract()
                .as(BaseErrorBody.class);

        softAssert.assertEquals(errorBody.getMessage(),allowedDescriptionCharactersMessage);
        //addClub.setDescription(validClubDescription);

        blocks.get(0).put("text",toShortDescription); //setting to short description
        clubDescription.put("blocks",blocks);
        addClub.setDescription(clubDescription.toJSONString());response = clubClient.addNewClub(addClub);

        errorBody = response.then().log().all()
                .extract()
                .as(BaseErrorBody.class);

        softAssert.assertEquals(errorBody.getMessage(),toShortDescriptionMessage);
        //addClub.setDescription(validClubDescription);
        blocks.get(0).put("text",toLongDescription); //setting to long description
        clubDescription.put("blocks",blocks);
        addClub.setDescription(clubDescription.toJSONString());

        response = clubClient.addNewClub(addClub);
        errorBody = response.then().log().all()
                .extract()
                .as(BaseErrorBody.class);

        softAssert.assertEquals(errorBody.getMessage(),toLongDescriptionMessage);

        softAssert.assertAll();
    }
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