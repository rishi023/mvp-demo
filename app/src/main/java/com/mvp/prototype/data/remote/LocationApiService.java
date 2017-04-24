package com.mvp.prototype.data.remote;

import com.mvp.prototype.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class LocationApiService {

    private static Gson gson = (new GsonBuilder()).setDateFormat(Constants.GSON_DATE_FORMAT).create();

    public static LocationApi getLocationApi() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(Constants.REST_END_POINT)
                .setConverter(new GsonConverter(gson))
                .build();
        return restAdapter.create(LocationApi.class);
    }

}
