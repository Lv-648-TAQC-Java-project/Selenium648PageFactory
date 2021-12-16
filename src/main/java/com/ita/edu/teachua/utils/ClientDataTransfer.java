package com.ita.edu.teachua.utils;

import com.ita.edu.teachua.api.models.club.add_club.AddClub;

public class ClientDataTransfer {
    GsonParser parser;

    public AddClub getAddClub() {
        parser = new GsonParser();
        parser.parseAddClubJson();
        return parser.getAddClub();
    }
}
