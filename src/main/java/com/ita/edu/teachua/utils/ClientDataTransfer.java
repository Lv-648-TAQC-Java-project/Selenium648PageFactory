package com.ita.edu.teachua.utils;

import com.ita.edu.teachua.api.models.challenge.response.AddChallengeResponse;
import com.ita.edu.teachua.api.models.club.add_club_request.AddClub;

public class ClientDataTransfer {
    GsonParser parser;

    public AddClub getAddClub() {
        parser = new GsonParser();
        parser.parseAddClubJson();
        return parser.getAddClub();
    }
    public AddChallengeResponse getAddChallenge(){
        parser=new GsonParser();
        parser.parseAddChallengeJson();
        return parser.getAddChallengeResponse();
    }

}
