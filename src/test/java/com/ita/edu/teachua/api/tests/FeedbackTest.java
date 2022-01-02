package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.FeedbackClient;
import com.ita.edu.teachua.api.models.feedback.feedback_request.FeedbackRequest;
import com.ita.edu.teachua.api.models.feedback.feedback_response.Feedback;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.io.IOException;

public class FeedbackTest extends AuthorizedApiTestRunner {

    @Test(description = "TUA-370")
    @Description("[API] Verify that feedback without text is not added to the club")
    public void createFeedbackWithEmptyTextFiledTest() throws IOException {
        Specifications.setResponseSpecification(400);
        FeedbackClient feedbackClient = new FeedbackClient(authorization.getToken());
        FeedbackRequest feedback = FeedbackRequest.builder()
                .rate(4.0f)
                .text("")
                .clubId(5)
                .userId(authorization.getCurrentAuthorizedUserID())
                .build();
        feedbackClient.addNewFeedback(feedback);
    }


    @Description("[API] Add feedback to the club")
    @Test(description = "TUA-376")
    public void addFeedbackToClubTest() throws IOException {
        Specifications.setResponseSpecification(200);
        FeedbackClient feedbackClient = new FeedbackClient(authorization.getToken());
        FeedbackRequest feedback = FeedbackRequest.builder()
                .text("Some examples of positive feedback")
                .rate(5f)
                .clubId(389)
                .userId(authorization.getCurrentAuthorizedUserID())
                .build();

        Response response = feedbackClient.addNewFeedback(feedback);
        Float rate = response.path("rate");
        String textFeedback = response.path("text");
        Integer clubId = response.path("clubId");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(response.path("id"));
        softAssert.assertEquals(rate, 5.0f);
        softAssert.assertEquals(textFeedback, "Some examples of positive feedback");
        softAssert.assertEquals(clubId, (Integer) 389);
        softAssert.assertAll();
    }

    @Description("[API] Get feedback by its id")
    @Test(description = "TUA")
    public void getFeedbackByIdTest() throws IOException {
        Specifications.setResponseSpecification(200);
        FeedbackClient feedbackClient = new FeedbackClient(authorization.getToken());
        Response response = feedbackClient.getFeedbackById(10);
        Feedback feedbackRequest = response.then()
                .log().all()
                .extract().as(Feedback.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(feedbackRequest.getId(), (Integer) 10);
        softAssert.assertEquals(feedbackRequest.getText(), "Verify if error message appears if entered data is invalid\n");
        softAssert.assertAll();
    }

}