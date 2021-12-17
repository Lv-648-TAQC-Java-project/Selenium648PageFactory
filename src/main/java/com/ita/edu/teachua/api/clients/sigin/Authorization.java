package com.ita.edu.teachua.api.clients.sigin;
import com.ita.edu.teachua.api.models.user.User_Simple;

import java.io.IOException;


public class Authorization {
    User_Simple userSimple;
    SignInClient signInClient;
    String token;

    public Authorization(String email, String password) throws IOException {

        this.userSimple = new User_Simple(email, password);
        this.signInClient = new SignInClient();
        this.token = signInClient
                .successSignInRequest(userSimple)
                .getAccessToken();
    }

    public String getToken(){
        return token;
    }

}
