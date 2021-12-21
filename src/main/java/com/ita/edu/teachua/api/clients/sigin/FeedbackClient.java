package com.ita.edu.teachua.api.clients.sigin;

import com.ita.edu.teachua.api.clients.BaseClient;
import com.ita.edu.teachua.api.models.feedback.Feedback;
import com.ita.edu.teachua.utils.MainValueProvider;
import io.restassured.response.Response;

import java.io.IOException;

public class FeedbackClient extends BaseClient {
    protected MainValueProvider valueProvider;
    private final String feedbackUrl;
    private String token;


    public FeedbackClient(String token) throws IOException {
        super();
        try {
            valueProvider = new MainValueProvider();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.feedbackUrl = mainValueProvider.getFeedbackUrl();
        this.token = token;
    }

    public Response addNewFeedback(Feedback feedback) {
        return preparedRequest()
                .header("Authorization", "Bearer " + token)
                .body(feedback)
                .log().all()
                .when()
                .post(feedbackUrl);
    }
}