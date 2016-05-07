package com.gojimo.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GojimoRestClient {
    public static final String API_URL = "https://api.gojimo.net";
    private static GojimoService service;

    public static GojimoService service() {
        if (service == null)
            service = gojimoService();
        return service;
    }

    private static GojimoService gojimoService() {
        return new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GojimoService.class);
    }
}
