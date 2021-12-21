package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.sigin.FeedbackClient;
import com.ita.edu.teachua.api.models.feedback.Feedback;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class FeedbackTest extends AuthorizedApiTestRunner {

    @Test(description = "TUA-370")
    @Description("[API] Verify that feedback without text is not added to the club")
    public void createFeedbackWithEmptyTextFiledTest() throws IOException {
        FeedbackClient feedbackClient = new FeedbackClient(authorization.getToken());
        Feedback feedback = Feedback.builder()
                .rate(4.0f)
                .text("")
                .clubId(5)
                .userId(authorization.getCurrentAuthorizedUserID())
                .build();
        Response response = feedbackClient.addNewFeedback(feedback);
        Assert.assertEquals(response.getStatusCode(), 400);
    }


    @Test(description = "TUA-376")
    @Description("[API] Add feedback to the club")
    public void addFeedbackToClub() throws IOException {
        FeedbackClient feedbackClient = new FeedbackClient(authorization.getToken());
        Feedback feedback = Feedback.builder()
                .text("It is demo feedback")
                .rate(5.0f)
                .clubId(389)
                .userId(authorization.getCurrentAuthorizedUserID())
                .build();
        Response response = feedbackClient.addNewFeedback(feedback);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.body().path("rate"), feedback.getRate());
        Assert.assertEquals(response.body().path("text"), feedback.getText());
        Assert.assertEquals(response.body().path("clubId"), feedback.getClubId());
    }

}