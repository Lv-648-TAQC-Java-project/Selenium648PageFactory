package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.utils.MainValueProvider;

import java.io.IOException;

public class DistrictClient extends BaseClient{

    private final String clientUrl;
    protected MainValueProvider mainValueProvider;
    private String token;

    public DistrictClient() throws IOException {
        mainValueProvider = new MainValueProvider();
        this.clientUrl = mainValueProvider.getDistrictClientUrl();
        this.token = token;
    }

}
