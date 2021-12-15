package com.ita.edu.teachua.utils;

import com.google.gson.Gson;
import com.ita.edu.teachua.api.models.club.add_club.AddClub;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GsonParser {
    private AddClub addClub;
    private Gson gson;
    public GsonParser() {
        gson = new Gson();
    }
    public void parseAddClubJson(){
        try(FileReader reader = new FileReader("src/main/java/com/ita/edu/teachua/utils/addClub.json")) {
            this.addClub = gson.fromJson(reader,AddClub.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public AddClub getAddClub(){
        return addClub;
    }
}
